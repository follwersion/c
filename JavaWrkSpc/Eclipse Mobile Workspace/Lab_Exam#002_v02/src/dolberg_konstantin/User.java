package dolberg_konstantin;

public abstract class User {
	
	String account;
	Password pw;
	Person person;
	int id;
	static int idCounter = 1;
	
	public User(String account, Password pw, Person person) {
		this.account = account;
		this.pw = pw;
		this.person = person;
		this.id = idCounter++;
	}
	
	public String toString() {
		return String.format("User [id=%s, account=%s, person=%s, pw=%s]",
				id, account, person, pw);
	}
	
	
}
