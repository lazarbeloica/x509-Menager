package beans;

public class BasicConstraintsExtension {

	boolean critical = false;
	boolean basicConstraint = false;
	boolean ca = false;
	String path = "";

	public boolean isCritical() {
		return critical;
	}

	public void setCritical(boolean critical) {
		this.critical = critical;
	}

	public boolean isBasicConstraint() {
		return basicConstraint;
	}

	public void setBasicConstraint(boolean basicConstraint) {
		this.basicConstraint = basicConstraint;
	}

	public boolean isCa() {
		return ca;
	}

	public void setCa(boolean ca) {
		this.ca = ca;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
