package dolberg_konstantin;

public class NonExistingComponentException extends Exception {

	String meldung;
	int cnsNo;
	
	public NonExistingComponentException(String meldung, int cnsNo) {
		super("Fehler! ");
		this.meldung = meldung;
		this.cnsNo = cnsNo;
	}

	public String toString() {
		return super.toString() + String.format("NonExistingComponentException [Meldung: %s%d]", meldung, cnsNo);
	}

}
