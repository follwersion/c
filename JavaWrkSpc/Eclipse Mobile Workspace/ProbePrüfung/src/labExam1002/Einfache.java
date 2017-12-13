package labExam1002;

public abstract class Einfache extends User {

    public Einfache(String account, Password pw, Person person) {
        super(account, pw, person);
        // TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("Einfache [toString()=%s]", super.toString());
    }
    
    

}
