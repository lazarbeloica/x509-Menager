package beans;

import java.util.Date;

import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class GenerateWindowTransporter {

	String keySize = "";
	Date validFrom = null;
	Date validTo = null;
	String serialNum = "";

	int version = 3; // hardkodovana podrazuevana verzija

	String userCN = "";
	String userOU = "";
	String userO = "";
	String userL = "";
	String userST = "";
	String userC = "";
	String userE = "";

	String keyPairName = "";
	String password = "";

	// ekstenzije
	KeyUsageExtension keyUsage = null;
	AltNameExtension altName = null;
	BasicConstraintsExtension basicConstraints = null;

	public BasicConstraintsExtension getBasicConstraints() {
		return basicConstraints;
	}

	public void setBasicConstraints(BasicConstraintsExtension basicConstraints) {
		this.basicConstraints = basicConstraints;
	}

	public AltNameExtension getAltName() {
		return altName;
	}

	public void setAltName(AltNameExtension altName) {
		this.altName = altName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getKeySize() {
		return keySize;
	}

	public void setKeySize(String keySize) {
		this.keySize = keySize;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getUserCN() {
		return userCN;
	}

	public void setUserCN(String userCN) {
		this.userCN = userCN;
	}

	public String getUserOU() {
		return userOU;
	}

	public void setUserOU(String userOU) {
		this.userOU = userOU;
	}

	public String getUserO() {
		return userO;
	}

	public void setUserO(String userO) {
		this.userO = userO;
	}

	public String getUserL() {
		return userL;
	}

	public void setUserL(String userL) {
		this.userL = userL;
	}

	public String getUserST() {
		return userST;
	}

	public void setUserST(String userST) {
		this.userST = userST;
	}

	public String getUserC() {
		return userC;
	}

	public void setUserC(String userC) {
		this.userC = userC;
	}

	public String getUserE() {
		return userE;
	}

	public void setUserE(String userE) {
		this.userE = userE;
	}

	public KeyUsageExtension getKeyUsage() {
		return keyUsage;
	}

	public void setKeyUsage(KeyUsageExtension keyUsage) {
		this.keyUsage = keyUsage;
	}

	public String getKeyPairName() {
		return keyPairName;
	}

	public void setKeyPairName(String keyPairName) {
		this.keyPairName = keyPairName;
	}

}
