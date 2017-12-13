package dolberg_konstantin;

public class NonExistingAccountException extends Exception {
	
	private static final long serialVersionUID = -498268285599478294L;
	String account;

	public NonExistingAccountException(String account) {
		super("Zu löschender Account ist ungültig! ");
		this.account = account;
	}

	public String toString() {
		return super.toString() + String.format("NonExistingAccountException [account=%s]", account);
	}
	
	

}
