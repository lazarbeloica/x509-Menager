package util;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.ArrayList;
import java.util.Enumeration;

import keystores.LocalKeyPairStore;


//sluzi da dohvati sve alijase iz keyStora za kljuceve
//kako bi mogao da ih prikaze u gui-u
public class KeyPairList {

	ArrayList<String> aliasesList = null;
	KeyStore ks = null;

	public KeyPairList() {

		Enumeration<String> aliases = null;

		ks = LocalKeyPairStore.getIstance();
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
