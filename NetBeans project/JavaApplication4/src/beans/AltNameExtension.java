package beans;

import java.util.ArrayList;

import org.bouncycastle.asn1.x509.GeneralName;

public class AltNameExtension {

	ArrayList<GeneralName> nameList = new ArrayList<GeneralName>();
	boolean critical = false;

	public ArrayList<GeneralName> getNameList() {
		return nameList;
	}

	public void addDirectoryName(String name) {
		nameList.add(new GeneralName(GeneralName.directoryName, name));
	}
	
	public void addDNSName(String name) {
		nameList.add(new GeneralName(GeneralName.dNSName, name));
	}
	
	public void addEdiPartyName(String name) {
		nameList.add(new GeneralName(GeneralName.ediPartyName, name));
	}
	
	public void addIPAddress(String name) {
		nameList.add(new GeneralName(GeneralName.iPAddress, name));
	}
	
	public void addOtherName(String name) {
		nameList.add(new GeneralName(GeneralName.otherName, name));
	}
	
	public void addRegisteredID(String name) {
		nameList.add(new GeneralName(GeneralName.registeredID, name));
	}
	
	public void addRfc822Name(String name) {
		nameList.add(new GeneralName(GeneralName.rfc822Name, name));
	}
	
	public void addUniformResourceIdentifier(String name) {
		nameList.add(new GeneralName(GeneralName.uniformResourceIdentifier, name));
	}
	
	public void addX400Address(String name) {
		nameList.add(new GeneralName(GeneralName.x400Address, name));
	}

	public boolean isCritical() {
		return critical;
	}

	public void setCritical(boolean critical) {
		this.critical = critical;
	}

}
