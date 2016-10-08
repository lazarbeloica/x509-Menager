package beans;

import org.bouncycastle.jce.X509KeyUsage;

public class KeyUsageExtension {
	
	int keyUsage = 0;
	boolean critical = false;
	
	public void setCritical(){
		critical = true;
	}
	
	public boolean isCritical(){
		return critical;
	}
	
	public void setCRLSign(){
		keyUsage |= X509KeyUsage.cRLSign;
	}
	
	public void setDataEncipherment(){
		keyUsage |= X509KeyUsage.dataEncipherment;
	}
	
	public void setDecipherOnly(){
		keyUsage |= X509KeyUsage.decipherOnly;
	}
	
	public void setDigitalSignature(){
		keyUsage |= X509KeyUsage.digitalSignature;
	}
	
	public void setEncipherOnly(){
		keyUsage |= X509KeyUsage.encipherOnly;
	}
	
	public void setKeyAgreement(){
		keyUsage |= X509KeyUsage.keyAgreement;
	}
	
	public void setKeyCertSign(){
		keyUsage |= X509KeyUsage.keyCertSign;
	}
	
	public void setKeyEncipherment(){
		keyUsage |= X509KeyUsage.keyEncipherment;
	}
	
	public void setNonRepudiation(){
		keyUsage |= X509KeyUsage.nonRepudiation;
	}
	
	public int getKeyUsage(){
		return keyUsage;
	}
	

}
