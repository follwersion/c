package dolberg_konstantin;

public abstract class Spezielle extends User {

	public Spezielle(String account, Password pw, Person person) {
		super(account, pw, person);
	}

	public String toString() {
		return String.format("Spezielle []") + super.toString(); 
	}
	
	

}
