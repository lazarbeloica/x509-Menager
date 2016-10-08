package rs.ac.bg.etf.bmbl.zp.project;



import java.util.Date;

import conectors.KeyPairDetails;
import util.SignedCerts;
import backend.*;
import beans.GenerateWindowTransporter;
import gui.KeyPairExportWindow;
import gui.MainWindow;
import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {

	//	new MainWindow();
	/*	GenerateWindowTransporter transp = new GenerateWindowTransporter();
		transp.setKeyPairName("name");
		transp.setKeySize("512");
		transp.setSerialNum("51051135");
		transp.setUserC("ads");
		transp.setUserCN("ads");
		transp.setUserE("ads");
		transp.setUserL("ads");
		transp.setUserO("ads");
		transp.setUserOU("ads");
		transp.setUserST("ads");
		transp.setPassword("sdfd");
		
		transp.setValidFrom(new Date(2015, 10, 20));
		transp.setValidTo(new Date(2020, 10, 20));
		GenerateKeyPair gen = new GenerateKeyPair();
		
		gen.GenerateKeyPair(transp);
		
		ExportKeyPair ex = new ExportKeyPair("name", "alohaha".toCharArray() ,".\\here2");
		ex.export();
		
		CSRGenerator csr = new CSRGenerator();
		csr.generateCSR("name", ".\\csr");
		SignCert.signCert("name", ".\\csr");
		boolean res = SignedCerts.chekCert("name");
		
		ExportCert.exportCert("name", ".\\evogaOdje");
		
		System.out.println(CertDetails.toString("name"));
		*/
		new MainWindow();
            
	}

}
