package dolberg_konstantin;

public class Entwickler extends Spezielle {

	public Entwickler(String account, Password pw, Person person) {
		super(account, pw, person);
	}

	public String toString() {
		return String.format("Entwickler []")+ super.toString();
	}
	
	

}
