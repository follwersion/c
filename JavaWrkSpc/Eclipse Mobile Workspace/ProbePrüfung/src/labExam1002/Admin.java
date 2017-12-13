package labExam1002;

public class Admin extends Spezielle {

    public Admin(String account, Password pw, Person person) {
        super(account, pw, person);
    }


    public String toString() {
        return String.format("Admin [toString()=%s]", super.toString());
    }
    
    

}
