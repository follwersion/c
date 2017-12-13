package dolberg_konstantin;

public class Password {
	
	private String secret_pw;

	public Password(String secretPw) {
		super();
		this.secret_pw = secretPw;
	}

	public String toString() {
		return String.format("Password [secret_pw=%s]", "XXXXXXXX");
	}
	
	public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Password other = (Password) obj;
        if (secret_pw == null) {
            if (other.secret_pw != null)
                return false;
        } else if (!secret_pw.equals(other.secret_pw))
            return false;
        return true;        
	}
	
	  public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result
	                + ((secret_pw == null) ? 0 : secret_pw.hashCode());
	        return result;
	    }
	
}
