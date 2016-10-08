package backend;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.X509Certificate;

import keystores.LocalKeyPairStore;

import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.openssl.jcajce.JcaPEMWriter;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.pkcs.*;
import org.bouncycastle.pkcs.jcajce.*;
import org.bouncycastle.asn1.x509.*;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;






public class CSRGenerator {

	static KeyStore ks = LocalKeyPairStore.getIstance();

	public static void generateCSR(String alias, String path) {

		try {
			X509Certificate cert = (X509Certificate) ks
					.getCertificateChain(alias)[0]; // dohvata samo prvi iz niza

			PublicKey pub = cert.getPublicKey();
			PrivateKey priv = (PrivateKey) ks.getKey(alias,
					LocalKeyPairStore.getFixedPassword());

			PKCS10CertificationRequestBuilder p10ReqBuilder = new JcaPKCS10CertificationRequestBuilder(
					new X500Name(cert.getSubjectX500Principal().getName()), pub);

			
			ContentSigner signer = null;
			try {
				signer = new JcaContentSignerBuilder("SHA1withRSA").build(priv);
			} catch (OperatorCreationException e) {
				e.printStackTrace();
			}			
			
			PKCS10CertificationRequest csr = p10ReqBuilder.build(signer);
			
			//cuvanje csr negde u fajl sistemu
			StringWriter strWriter = new StringWriter();

			JcaPEMWriter pemWriter = new JcaPEMWriter(strWriter);
			pemWriter.writeObject(csr);
			pemWriter.close();
			
			if(!path.endsWith(".p10"))
				path += ".p10";
			FileWriter fw = new FileWriter(new File(path));
			fw.write(strWriter.toString());
			fw.flush();
			fw.close();
			
		} catch (KeyStoreException e) {
			e.printStackTrace();
		} catch (UnrecoverableKeyException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	

}
