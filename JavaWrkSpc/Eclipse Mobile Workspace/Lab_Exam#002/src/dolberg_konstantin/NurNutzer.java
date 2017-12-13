package dolberg_konstantin;

public class NurNutzer extends Einfache {

	public NurNutzer(String account, Password pw, Person person) {
		super(account, pw, person);
	}

	public String toString() {
		return String.format("NurNutzer []") + super.toString();
	}
	
	

}
