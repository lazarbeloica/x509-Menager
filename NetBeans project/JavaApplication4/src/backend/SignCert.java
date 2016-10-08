package backend;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.Extension;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;

import javax.security.auth.x500.X500Principal;

import keystores.LocalKeyPairStore;
import keystores.LocalSignedCertKeyStore;

import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.X500NameBuilder;
import org.bouncycastle.asn1.x500.style.BCStyle;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;
import org.bouncycastle.pkcs.jcajce.JcaPKCS10CertificationRequest;
import org.bouncycastle.util.io.pem.PemReader;

import util.SignedCerts;

public class SignCert {

	static final long MILLIS_PER_DAY = 86400000l;
	static final String PATH = ".\\keys\\CACerts.p12";

	static X509Certificate certificate = null;
	static PrivateKey privateKey = null;
	static final char[] password = "passwordCA".toCharArray();

	private static class CAInfo {
		static String cn = "ETFCA", ou = "RTI", o = "ETF", l = "Belgrade",
				st = "Serbia", c = "Serbia", e = "etf@etf.rs";
		static int keyLength = 2048;
		static String serial = "9999999";
		static int validity = 365;
		static int pathLength = 50;

	}

	public static X500Name getName() throws UnrecoverableKeyException,
			NoSuchAlgorithmException, CertificateException, KeyStoreException,
			IOException {
		if (certificate == null)
			load();
		return new X500Name(certificate.getSubjectX500Principal().getName());
	}

	private static X509Certificate createCACert(PublicKey publicKey,
			PrivateKey privateKey) throws Exception {

		X500NameBuilder builder = new X500NameBuilder(BCStyle.INSTANCE);
		builder.addRDN(BCStyle.CN, CAInfo.cn);
		builder.addRDN(BCStyle.O, CAInfo.o);
		builder.addRDN(BCStyle.OU, CAInfo.ou);
		builder.addRDN(BCStyle.L, CAInfo.l);
		builder.addRDN(BCStyle.ST, CAInfo.st);
		builder.addRDN(BCStyle.C, CAInfo.c);
		builder.addRDN(BCStyle.E, CAInfo.e);

		Date issuedDate = new Date();
		Date expiryDate = new Date(System.currentTimeMillis() + CAInfo.validity
				* MILLIS_PER_DAY);

		X500Name name = builder.build();
		X509v3CertificateBuilder certGen = new JcaX509v3CertificateBuilder(
				name, new BigInteger(CAInfo.serial), issuedDate, expiryDate,
				name, publicKey);
		
		ContentSigner signer = new JcaContentSignerBuilder("SHA1withRSA")
				.build(privateKey);

		X509Certificate cert = new JcaX509CertificateConverter()
				.getCertificate(certGen.build(signer));

		return cert;

	}

	private static KeyPairGenerator createKeyPairGenerator(
			String algorithmIdentifier, int bitCount)
			throws NoSuchProviderException, NoSuchAlgorithmException {
		KeyPairGenerator kpg = KeyPairGenerator
				.getInstance(algorithmIdentifier);
		kpg.initialize(bitCount);
		return kpg;
	}

	private static KeyPair createKeyPair(String encryptionType, int bitCount)
			throws NoSuchProviderException, NoSuchAlgorithmException {
		KeyPairGenerator keyPairGenerator = createKeyPairGenerator(
				encryptionType, bitCount);
		KeyPair keyPair = keyPairGenerator.genKeyPair();
		return keyPair;
	}

	private static void createAndSetup() {
		KeyStore ks = null;
		try {
			ks = KeyStore.getInstance("PKCS12");
			ks.load(null, null);

			KeyPair keyPair = createKeyPair("RSA", CAInfo.keyLength);
			privateKey = keyPair.getPrivate();

			X509Certificate cert = createCACert(keyPair.getPublic(), privateKey);

			Certificate[] chain = new Certificate[1];
			chain[0] = cert;

			ks.setKeyEntry("CA", privateKey, password, chain);
			
			File dir = new File(".\\keys");
			if(!dir.exists())
				dir.mkdir();
			
			FileOutputStream fos = new FileOutputStream(PATH);
			ks.store(fos, password);
			fos.close();
		} catch (Exception e) {
		}
	}

	private static void load() throws NoSuchAlgorithmException,
			CertificateException, IOException, KeyStoreException,
			UnrecoverableKeyException {
		KeyStore ks = null;
		try {
			FileInputStream fis = new FileInputStream(PATH);
			ks = KeyStore.getInstance("PKCS12");
			ks.load(fis, password);
			fis.close();

			privateKey = (PrivateKey) ks.getKey("CA", password);
			certificate = (X509Certificate) ks.getCertificateChain("CA")[0];

		} catch (FileNotFoundException e) {
			createAndSetup();
                        load();
		}
	}

	public static X509Certificate getCertificate()
			throws NoSuchAlgorithmException, CertificateException,
			KeyStoreException, IOException, UnrecoverableKeyException {
		if (certificate == null)
			load();
		return certificate;
	}

	public static PrivateKey getPrivateKey() throws UnrecoverableKeyException,
			NoSuchAlgorithmException, CertificateException, KeyStoreException,
			IOException {
		if (privateKey == null)
			load();
		return privateKey;
	}

	public static boolean signCert(String aliasK, String path) {

		try {
			path += path.endsWith(".p10") ? "" : ".p10";
			FileReader fr = new FileReader(path);

			PemReader pemReader = new PemReader(fr);
			PKCS10CertificationRequest csr = new PKCS10CertificationRequest(
					pemReader.readPemObject().getContent());

			pemReader.close();
			fr.close();

			JcaPKCS10CertificationRequest jcaCertRequest = new JcaPKCS10CertificationRequest(
					csr.getEncoded()).setProvider("BC");

			String name = jcaCertRequest.getSubject().toString();
			
		    
			// ne vredi, previse je komplikovano da se izvuce alijas
			/*
			KeyStore ks = LocalKeyPairStore.getIstance();
			Enumeration<String> aliases = ks.aliases();

			String alias = null;
			for (Enumeration<String> e = aliases; e != null
					&& e.hasMoreElements();) {
				String tmp = e.nextElement();
				X509Certificate cert = (X509Certificate) ks.getCertificate(tmp);

				String name1 = cert.getSubjectX500Principal().getName();
				
				if (name..equals(name1)) {
					alias = tmp;
					break;
				}*/
			

			return signCertA(aliasK, jcaCertRequest);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} /*catch (KeyStoreException e) {
			e.printStackTrace();
		}/*catch (InvalidKeyException e1) {
			e1.printStackTrace();
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}*/
		return false;

	}

	public static boolean signCertA(String alias, PKCS10CertificationRequest csr) {

		if (csr == null || alias == null)
			return false;

		KeyStore ks = LocalKeyPairStore.getIstance();
		try {
			Key key = ks.getKey(alias, LocalKeyPairStore.getFixedPassword());
			X509Certificate cert = (X509Certificate) ks
					.getCertificateChain(alias)[0];

			BigInteger serial = cert.getSerialNumber();

			Date issuedDate = cert.getNotBefore();
			Date expiryDate = cert.getNotAfter();

			JcaPKCS10CertificationRequest jcaRequest = new JcaPKCS10CertificationRequest(
					csr);

			X509v3CertificateBuilder certificateBuilder = new JcaX509v3CertificateBuilder(
					getName(), serial, issuedDate, expiryDate,
					jcaRequest.getSubject(), jcaRequest.getPublicKey());

			ContentSigner signer = new JcaContentSignerBuilder("SHA1withRSA")
					.build(getPrivateKey());

			X509Certificate signedCert = new JcaX509CertificateConverter()
					.getCertificate(certificateBuilder.build(signer));

			KeyStore cs = LocalSignedCertKeyStore.getIstance();
			cs.setCertificateEntry(alias, signedCert);
			LocalSignedCertKeyStore.save();
			SignedCerts.addCert(alias);
			SignedCerts.save();

		} catch (UnrecoverableKeyException e) {
			e.printStackTrace();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (CertificateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (OperatorCreationException e) {
			e.printStackTrace();
		}

		return true;

	}

}
