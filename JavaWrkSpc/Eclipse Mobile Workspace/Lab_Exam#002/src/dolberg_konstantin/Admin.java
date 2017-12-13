package dolberg_konstantin;

public class Admin extends Spezielle {
	
	enum Authorization {GUEST, NORMAL, MASTER, ADMIN};
	private Authorization authorization;

	public Admin(String account, Password pw, Person person) {
		super(account, pw, person);
		this.authorization = Authorization.NORMAL;
	}
	
	public String toString() {
		return String.format("Admin [authorization=%s]", authorization) + super.toString();
	}

	public Authorization getAuthorization() {
		return authorization;
	}

	public void setAuthorization(Authorization authorization) {
		this.authorization = authorization;
	}

}
