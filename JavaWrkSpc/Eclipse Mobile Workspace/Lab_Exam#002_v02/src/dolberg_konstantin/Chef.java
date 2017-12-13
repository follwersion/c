package dolberg_konstantin;

public class Chef extends Spezielle {

	public Chef(String account, Password pw, Person person) {
		super(account, pw, person);
	}

	public String toString() {
		return super.toString() + String.format("Chef []");
	}
}
