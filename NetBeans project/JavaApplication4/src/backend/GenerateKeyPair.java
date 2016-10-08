package backend;

import java.io.IOException;
import java.math.BigInteger;
import java.security.*;
import java.security.cert.*;
import java.util.ArrayList;

import org.bouncycastle.jce.X509KeyUsage;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.asn1.x500.*;
import org.bouncycastle.asn1.x500.style.BCStyle;
import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.cert.CertIOException;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;

import beans.AltNameExtension;
import beans.BasicConstraintsExtension;
import beans.GenerateWindowTransporter;
import beans.KeyUsageExtension;
import keystores.LocalKeyPairStore;

public class GenerateKeyPair {

	static class SubjectName { // struktura sa info o subject-u
		String CN, OU, O, L, ST, C, E;
	}

	private static KeyPairGenerator createKeyPairGenerator(
			String algorithmIdentifier, int bitCount) {
		KeyPairGenerator kpg;
		try {
			kpg = KeyPairGenerator.getInstance(algorithmIdentifier);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		kpg.initialize(bitCount);
		return kpg;
	}

	private static KeyPair createKeyPair(String encryptionType, int bitCount) {
		KeyPairGenerator keyPairGenerator;
		try {
			keyPairGenerator = createKeyPairGenerator(encryptionType, bitCount);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		KeyPair keyPair = keyPairGenerator.genKeyPair();
		return keyPair;
	}

	private X509Certificate createCert(PublicKey pub, PrivateKey priv,
			GenerateWindowTransporter transp) {
		// koristi se Bouncy Castle stil
		X500NameBuilder builder = new X500NameBuilder(BCStyle.INSTANCE);

		SubjectName name = new SubjectName();
		name.CN = transp.getUserCN();
		name.O = transp.getUserO();
		name.OU = transp.getUserOU();
		name.L = transp.getUserL();
		name.ST = transp.getUserST();
		name.C = transp.getUserC();
		name.E = transp.getUserE();

		builder.addRDN(BCStyle.CN, name.CN);
		builder.addRDN(BCStyle.O, name.O);
		builder.addRDN(BCStyle.OU, name.OU);
		builder.addRDN(BCStyle.L, name.L);
		builder.addRDN(BCStyle.ST, name.ST);
		builder.addRDN(BCStyle.C, name.C);
		builder.addRDN(BCStyle.E, name.E);

		// PRAVLJENJE PROVAJDERA ZA POTPIISIVANJE
		ContentSigner signiture = null;
		try {
			signiture = new JcaContentSignerBuilder("SHA1WithRSA").build(priv);
		} catch (OperatorCreationException e) {
			e.printStackTrace();
		}
		// PRAAVLJENJE v3 SERTIFIKATA
		// prvi builder je za izdavaca, a drugi za subject ciji se javni kljuc
		// sertifikuje
		X509v3CertificateBuilder certBuilder = new JcaX509v3CertificateBuilder(
				builder.build(), new BigInteger(transp.getSerialNum()),
				transp.getValidFrom(), transp.getValidTo(), builder.build(),
				pub);

		// ovde treba da se dodaju ekstenizje

		KeyUsageExtension keyUsage = transp.getKeyUsage();
		if (keyUsage != null) {
			try {
				certBuilder.addExtension(Extension.keyUsage,
						keyUsage.isCritical(),
						new X509KeyUsage(keyUsage.getKeyUsage()).getEncoded());
			} catch (CertIOException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		AltNameExtension altName = transp.getAltName();
		if (altName != null) {
			ArrayList<GeneralName> issuerAltNames = altName.getNameList();
			if (issuerAltNames.size() > 0) {
				GeneralName[] all = new GeneralName[issuerAltNames.size()];
				int i = 0;
				for (GeneralName it : issuerAltNames) {
					all[i++] = it;
				}
				GeneralNames names = new GeneralNames(all);
				try {
					certBuilder.addExtension(Extension.issuerAlternativeName,
							altName.isCritical(), names);
				} catch (CertIOException e) {
					e.printStackTrace();
				}
			}
		}

		BasicConstraintsExtension bce = transp.getBasicConstraints();
		if (bce != null) {
			if (bce.isBasicConstraint()) {
				try {
					if (bce.isCa()) {
						int length = Integer.parseInt(bce.getPath());
						certBuilder.addExtension(Extension.basicConstraints,
								bce.isCritical(), new BasicConstraints(length));
					} else {
						certBuilder.addExtension(Extension.basicConstraints,
								bce.isCritical(), new BasicConstraints(false));
					}
				} catch (Exception e) {

				}
			}
		}
		// /////////////////////////////////////

		X509Certificate signedCert = null;
		try {
			signedCert = new JcaX509CertificateConverter()
					.getCertificate(certBuilder.build(signiture));
		} catch (CertificateException e) {
			e.printStackTrace();
		}
		return signedCert;
	}

	public void GenerateKeyPair(GenerateWindowTransporter transp) {

		// pozivanje privatne metode koja generise par kluceva
		KeyPair keyPair = createKeyPair("RSA",
				Integer.parseInt(transp.getKeySize()));

		PublicKey pub = keyPair.getPublic();
		PrivateKey priv = keyPair.getPrivate();
		// smestanje kljuca u keystore
		KeyStore keyStore = LocalKeyPairStore.getIstance();
		java.security.cert.Certificate cert = createCert(pub, priv, transp);
		java.security.cert.Certificate[] chain = new java.security.cert.Certificate[1];
		chain[0] = cert;

		try {
			keyStore.setKeyEntry(transp.getKeyPairName(), priv,
					LocalKeyPairStore.getFixedPassword(), chain);
                        LocalKeyPairStore.save();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		}

	}

}
