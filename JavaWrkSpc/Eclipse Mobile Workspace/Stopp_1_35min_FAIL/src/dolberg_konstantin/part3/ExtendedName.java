package dolberg_konstantin.part3;

public class ExtendedName extends _untouchable_.Name {

	String titel;

	public ExtendedName(String sname, String fname, String titel) {
		super(sname, fname);
		this.titel = titel;
	}

	public String toString() {
		return "ExtendetName [titel=" + titel + "]" + super.toString();
	}

}
