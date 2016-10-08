/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.ArrayList;
import java.util.Enumeration;
import keystores.*;

/**
 *
 * @author User
 */
public class SignedCertList {
    ArrayList<String> aliasesList = null;
	KeyStore ks = null;

	public SignedCertList() {

		Enumeration<String> aliases = null;

		ks = LocalSignedCertKeyStore.getIstance();
		try {
			aliases = ks.aliases();
		} catch (KeyStoreException e) {
		}

		aliasesList = new ArrayList();
		for (Enumeration<String> e = aliases; e != null && e.hasMoreElements();) {
			aliasesList.add(e.nextElement());
		}
	}
	
	public ArrayList<String> getList(){
		return aliasesList;
	}
}
