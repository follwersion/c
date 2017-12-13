package _untouchable_;

public class Name {

	public String sname;
	public String fname;

	public Name() {
		super();
		this.sname = "Dolberg";
		this.fname = "Konstantin";
	}

	public Name(String sname, String fname) {
		super();
		this.sname = sname;
		this.fname = fname;
	}

	public void printName() {
		System.out.printf("Nachname= %s, Vorname= %s\n", sname, fname);
	}
	
	public String toString() {
		return "Name [fname=" + fname + ", sname=" + sname + "]";
	}
	
//	public String toString() {
//		return String.format("Name [sname=%s, fname=%s]", sname, fname);
//	}

}
