package dolberg_konstantin;

public class Gast extends Einfache {
	
	short zf;
	
	public Gast(String account, Password pw, Person person) {
		super(account, pw, person);
		this.zf = 1000;
	}

	public String toString() {
		return super.toString() + String.format("Gast [zf=%s]", zf);
	}
}
