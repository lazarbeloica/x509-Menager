package beans;

import java.security.PublicKey;
import java.util.Date;
import java.util.Set;

import org.bouncycastle.asn1.x500.X500Name;


public class CertDetailTransporter {

	X500Name signer = null;
	X500Name issuer = null;
	X500Name subject = null;

	Date validFrom = null;
	Date validTo = null;

	PublicKey pubKey = null;
	int version = 3;
	java.math.BigInteger serialNum = null;

	Set<String> criticalExt = null;
	Set<String> nonCriticalExt = null;

	String sigAlg = "";
	String pubKeyAlg = "rsaEncryption";
	
	
	
	public String getPubKeyAlg() {
		return pubKeyAlg;
	}

	public void setPubKeyAlg(String pubKeyAlg) {
		this.pubKeyAlg = pubKeyAlg;
	}

	public String getSigAlg() {
		return sigAlg;
	}

	public void setSigAlg(String sigAlg) {
		this.sigAlg = sigAlg;
	}

	public java.math.BigInteger getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(java.math.BigInteger bigInteger) {
		this.serialNum = bigInteger;
	}

	public Set<String> getCriticalExt() {
		return criticalExt;
	}

	public void setCriticalExt(Set<String> criticalExt) {
		this.criticalExt = criticalExt;
	}

	public Set<String> getNonCriticalExt() {
		return nonCriticalExt;
	}

	public void setNonCriticalExt(Set<String> nonCriticalExt) {
		this.nonCriticalExt = nonCriticalExt;
	}

	public X500Name getSigner() {
		return signer;
	}

	public void setSigner(X500Name signer) {
		this.signer = signer;
	}

	public X500Name getIssuer() {
		return issuer;
	}

	public void setIssuer(X500Name issuer) {
		this.issuer = issuer;
	}

	public X500Name getSubject() {
		return subject;
	}

	public void setSubject(X500Name subject) {
		this.subject = subject;
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

	public PublicKey getPubKey() {
		return pubKey;
	}

	public void setPubKey(PublicKey pubKey) {
		this.pubKey = pubKey;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
