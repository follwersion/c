package dolberg_konstantin;

public class Admin extends Spezielle {

	public Admin(String account, Password pw, Person person) {
		super(account, pw, person);
	}

	public String toString() {
		return super.toString() + String.format("Admin []");
	}

	public char[] getAuthorization() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setAuthorization(Authorization admin) {
		// TODO Auto-generated method stub
		
	}
}
