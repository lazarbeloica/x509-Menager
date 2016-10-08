package conectors;

import backend.ExportKeyPair;

public class KeyPairExporter {

    //ako je izvezeni fajl kriptovan aes-om

    public static boolean exportKeyPair(String alias, String password, String path) {
        ExportKeyPair ex = new ExportKeyPair(alias, password, path);
        ex.export();
        return true;
    }

    //ako je bez kriptovanja

    public static boolean exportKeyPair(String alias, String path) {
        ExportKeyPair ex = new ExportKeyPair(alias, path);
        ex.export();
        return true;
    }

}
