package keystores;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

public class LocalKeyPairStore {
	// svi elementi su static kako bi bio omogucen pristup iz bilo kog dela
	// programa
	static KeyStore keyPairStore = null;
	static char[] password = "fixPassowrd".toCharArray();

	// lozinka za pristup celom fajlu, je fiksa, a za svaki kljuc se trazi
	// od korisnika

	public static KeyStore getIstance() {
		if (keyPairStore == null)
			load();
		return keyPairStore;
	}

	public static char[] getFixedPassword(){
		return password;
	}
	
	private static void load() {
		KeyStore ks = null;

		FileInputStream fis;
		try {
			fis = new FileInputStream(".\\keys\\KeyPairStore.p12");
			try {
				ks = KeyStore.getInstance("PKCS12"); // po specifikaciji iz
														// projekta
				ks.load(fis, password);
			} catch (KeyStoreException e) {
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (CertificateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			fis.close();
		} catch (FileNotFoundException e) {
			// da li direktorijum postoji
			File dir = new File(".\\keys");
			if (!dir.exists()) {
				// ako ne postoji, treba ga izmisliti
				try {
					dir.mkdir();
				} catch (SecurityException se) {
					// zbog security menagera
					se.printStackTrace();
				}
			}

			// sad treba stvoriti novu istancu keysore-a
			try {
				ks = KeyStore.getInstance("PKCS12");
				ks.load(null, null); // na ovaj nacin se stvara nova

				FileOutputStream fos = new FileOutputStream(
						".\\keys\\KeyPairStore.p12");
				ks.store(fos, password);
				fos.close();

			} catch (KeyStoreException e1) {
				e1.printStackTrace();
			} catch (NoSuchAlgorithmException e1) {
				e1.printStackTrace();
			} catch (CertificateException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		keyPairStore = ks;

	}

	public static void save() {
		if (keyPairStore != null) {
			try {
				FileOutputStream fos = new FileOutputStream(
						".\\keys\\KeyPairStore.p12");
				keyPairStore.store(fos, password);
				fos.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (KeyStoreException e) {
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (CertificateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		keyPairStore = null;
	}

}
