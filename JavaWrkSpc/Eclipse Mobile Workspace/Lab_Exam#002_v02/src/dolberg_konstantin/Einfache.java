package dolberg_konstantin;

public abstract class Einfache extends User {

	public Einfache(String account, Password pw, Person person) {
		super(account, pw, person);
	}

	public String toString() {
		return super.toString() + String.format("Einfache []");
	}
}
