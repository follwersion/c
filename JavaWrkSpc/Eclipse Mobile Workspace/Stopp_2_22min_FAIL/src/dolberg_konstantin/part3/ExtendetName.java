package dolberg_konstantin.part3;

public class ExtendetName extends _untouchable_.Name {
	
	String titel;

	public ExtendetName(String sname, String fname, String titel) {
		super(sname, fname);
		this.titel = titel;
	}

	public String toString() {
		return String.format("ExtendetName [titel=%s]", titel) + super.toString();
	}
	
	

}
