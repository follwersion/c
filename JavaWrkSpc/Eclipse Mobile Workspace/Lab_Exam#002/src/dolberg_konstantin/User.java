package dolberg_konstantin;

public abstract class User {
	
	String account;
	Password pw;
	Person person;
	int id;
	static int idTemp = 1;
	
	public User(String account, Password pw, Person person) {
		this.account = account;
		this.pw = pw;
		this.person = person;
		this.id = idTemp++;
	}

	public String toString() {
		return String.format("\nUser [account=%s, id=%s, person=%s, pw=%s]\n",
				account, id, person, pw);
	}	
}
