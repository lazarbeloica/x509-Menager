package backend;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;

import keystores.LocalSignedCertKeyStore;
import org.bouncycastle.util.encoders.Base64;

public class ExportCert {

	static String EXT = ".cer";

	static KeyStore cs = LocalSignedCertKeyStore.getIstance();

	public static void exportCert(String alias, String path){
		
		path += path.endsWith(EXT) ? "" : EXT;
		X509Certificate cert = null;
		try{
			cert = (X509Certificate) cs.getCertificate(alias);
			
			Base64 enc = new Base64();
			
			byte[] toEncode = cert.getEncoded();
			String encodedCert = new String(Base64.encode(toEncode));
		
			FileOutputStream fos = new FileOutputStream(path);
			PrintWriter pw = new PrintWriter(fos, true);
			pw.write(encodedCert);
			
			pw.close();
			fos.close();
			
		}catch (IOException e){
			e.printStackTrace();
		} catch (CertificateEncodingException e) {
			e.printStackTrace();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		}
	}
}
