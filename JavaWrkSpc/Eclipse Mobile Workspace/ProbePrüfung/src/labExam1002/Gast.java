package labExam1002;

public class Gast extends Einfache {
    
    short zf = 1000;

    public Gast(String account, Password pw, Person person) {
        super(account, pw, person);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("Gast [zf=%s, toString()=%s]", zf, super
                .toString());
    }

    
}
