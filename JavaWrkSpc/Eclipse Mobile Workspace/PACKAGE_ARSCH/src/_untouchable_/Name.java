package _untouchable_;

public class Name {

	public String fname;
	public String sname;

	public Name() {
		super();
		this.fname = "Konstantin";
		this.sname = "Eisenzwerg";
	}

	public Name(String fname, String sname) {
		super();
		this.fname = fname;
		this.sname = sname;
	}

	public void printName() {
		System.out.printf("Nachname = %S ; Vorname = %S\n", sname, fname);
	}

	public String toString() {
		return String.format("Name [sname=%s, fname=%s]", sname, fname);
	}
}
