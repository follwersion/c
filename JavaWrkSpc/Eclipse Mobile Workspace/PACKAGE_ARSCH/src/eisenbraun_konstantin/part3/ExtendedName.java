package eisenbraun_konstantin.part3;

public class ExtendedName extends _untouchable_.Name {

	String titel;

	public ExtendedName(String titel, String fname, String sname) {
		super(fname, sname);
		this.titel = titel;
	}
	
	public String toString() {
		return String.format("ExtendedName [titel=%s]", titel)
				+ super.toString();
	}
}