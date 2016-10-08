package conectors;

import backend.CSRGenerator;

public class CerSigReq {

	public static boolean request(String alias, String path){
		CSRGenerator csr = new CSRGenerator();
		csr.generateCSR(alias, path);
		return true;
	}
}
