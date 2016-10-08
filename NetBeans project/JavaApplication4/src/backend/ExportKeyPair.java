package backend;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.logging.Level;
import java.util.logging.Logger;

import util.AESCipher;
import keystores.LocalKeyPairStore;

//sluzi da prihvati informacije neophodne za cuvanje kljuca
public class ExportKeyPair {

    String password = null;
    String alias = null;
    KeyStore ks = null;
    String path = null;
    boolean encrypt = false;

    // ima kriptovanja
    public ExportKeyPair(String alias, String password, String path) {
        this.alias = alias;
        this.password = password;
        encrypt = true;

        this.path = path.endsWith(".p12") ? path : path + ".p12";
    }

    // nema kriptovanja
    public ExportKeyPair(String alias, String path) {
        this.alias = alias;

        this.path = path.endsWith(".p12") ? path : path + ".p12";
    }

    public void export() {
        try {
            ks = LocalKeyPairStore.getIstance();
            Key key = ks.getKey(alias, LocalKeyPairStore.getFixedPassword());
            Certificate[] chain = ks.getCertificateChain(alias);

            FileOutputStream fos = new FileOutputStream(path);

            KeyStore exportKeyStore = KeyStore.getInstance("PKCS12");
            exportKeyStore.load(null, null);
            exportKeyStore.setKeyEntry(alias, key, LocalKeyPairStore.getFixedPassword(), chain);

            exportKeyStore.store(fos, LocalKeyPairStore.getFixedPassword());

            fos.close();
			//neophodna je provera ovog dela ovde
            //mozda treba jos dorade ako fajl vec postoji i te fore
            if (encrypt) {

                File file = new File(path);

                try {
                    AESCipher.encrypt(password, file, file);
                } catch (InvalidKeyException ex) {
                }
            }
        } catch (UnrecoverableKeyException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
