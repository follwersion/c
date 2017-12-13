package labExam1002;

public class Entwickler extends Spezielle {

    public Entwickler(String account, Password pw, Person person) {
        super(account, pw, person);
        // TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("Entwickler [toString()=%s]", super.toString());
    }
    
    

}
