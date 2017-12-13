package dolberg_konstantin.part2;

import _untouchable_.Halter_I;

public class Halter implements Halter_I {
	
	String sName;
	String fName;
	
	public Halter(String sName, String fName) {
		this.sName = sName;
		this.fName = fName;
	}

	public String getFName() {
		return this.fName;
	}

	public String getSName() {
		return this.sName;
	}

	public String toString() {
		return String.format("Halter [sName=%s, fName=%s]", sName, fName);
	}	
}
