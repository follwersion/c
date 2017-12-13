package labExam1002;

public class Chef extends Spezielle {

    public Chef(String account, Password pw, Person person) {
        super(account, pw, person);
        // TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("Chef [toString()=%s]", super.toString());
    }
    
    

}
