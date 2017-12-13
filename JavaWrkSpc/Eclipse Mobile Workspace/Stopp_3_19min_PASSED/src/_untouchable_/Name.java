package _untouchable_;

public class Name {
	
	String sname;
	String fname;
		
	public Name() {
		this.sname = "Dolberg";
		this.fname = "Konstantin";
	}

	public Name(String sname, String fname) {
		this.sname = sname;
		this.fname = fname;
	}
	
	public void printName() {
		System.out.println("Nachname=" + sname + "; Vorname=" + fname);
	}

	public String toString() {
		return String.format("Name [fname=%s, sname=%s]", fname, sname);
	}
}
