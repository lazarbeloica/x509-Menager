package conectors;

import backend.GenerateKeyPair;
import beans.GenerateWindowTransporter;

public class KeyPairCreation {

	public static boolean createKeyPair(GenerateWindowTransporter transp){
		GenerateKeyPair gen = new GenerateKeyPair();
		gen.GenerateKeyPair(transp);
		return true;
	}
	
}
