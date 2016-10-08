package conectors;

import backend.SignCert;

public class SignCerByCA {
	//mora i alijas da bi se certifikati iz CA isto zvali kao i kljucevi
	public static boolean sign(String alias, String pathToCSR) {

		return SignCert.signCert(alias, pathToCSR);
	}

}
