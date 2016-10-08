package conectors;

import backend.ExportCert;

public class SignedCertExporter {

	public static boolean export(String alias, String path) {
		ExportCert.exportCert(alias, path);
		return true;
	}
}
