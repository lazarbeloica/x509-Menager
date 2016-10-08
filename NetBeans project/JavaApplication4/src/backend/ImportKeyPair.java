package backend;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Enumeration;
import javax.crypto.BadPaddingException;

import util.AESCipher;
import keystores.LocalKeyPairStore;

public class ImportKeyPair {

    String newName = null;
    String password = null;
    String path = null;
    boolean encrypted = false;

    public ImportKeyPair(String newName, String password, String path) {

        this.newName = newName;
        this.password = password;
        this.path = path.endsWith(".p12") ? path : path + "p12";
        this.encrypted = true;
    }

    public ImportKeyPair(String newName, String path) {

        this.newName = newName;
        this.path = path.endsWith(".p12") ? path : path + "p12";
    }

    public void importKeyPair() throws Exception {

        KeyStore ks = LocalKeyPairStore.getIstance();

        if (encrypted) {
            File file = new File(path);
            AESCipher.decrypt(password, file, file);
            file = null;
        }

        FileInputStream fis = new FileInputStream(path);

        KeyStore tmpKeyStore = KeyStore.getInstance("PKCS12");
        tmpKeyStore.load(fis, LocalKeyPairStore.getFixedPassword());
        fis.close();

			//ovde je pretpostavljeno da svaki izvezeeni fajl 
        //sadrzi samo jedan par kljuceva
        Enumeration<String> aliases = tmpKeyStore.aliases();
        String thisAlias = aliases.nextElement();

        Key key = tmpKeyStore.getKey(thisAlias, LocalKeyPairStore.getFixedPassword());
        Certificate[] chain = tmpKeyStore.getCertificateChain(thisAlias);

        ks.setKeyEntry(newName, key, LocalKeyPairStore.getFixedPassword(), chain);
        LocalKeyPairStore.save();

    }
}
