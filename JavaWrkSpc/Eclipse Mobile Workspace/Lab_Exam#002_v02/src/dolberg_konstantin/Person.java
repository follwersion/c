package dolberg_konstantin;

public class Person {
	
	String sname;
	String fname;
	String dep;
	int id;
	static int idCounter = 1;
	
	public Person(String sname, String fname, String dep) {
		this.sname = sname;
		this.fname = fname;
		this.dep = dep;
		this.id = idCounter++;
	}

	public String toString() {
		return String.format("Person [dep=%s, fname=%s,sname=%s , id=%s]", dep,
				fname, sname, id);
	}
	
	

}
