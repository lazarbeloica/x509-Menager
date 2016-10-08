/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conectors;

import backend.ImportKeyPair;

/**
 *
 * @author User
 */
public class KeyPairImporter {

    //ako je izvezeni fajl kriptovan aes-om
    public static boolean importKeyPair(String alias, String password, String path) throws Exception {
        ImportKeyPair im = new ImportKeyPair(alias, password, path);
        im.importKeyPair();
        return true;
    }

    //ako je bez kriptovanja
    public static boolean importKeyPair(String alias, String path) throws Exception {
        ImportKeyPair im = new ImportKeyPair(alias, path);
        im.importKeyPair();

        return true;
    }

}
