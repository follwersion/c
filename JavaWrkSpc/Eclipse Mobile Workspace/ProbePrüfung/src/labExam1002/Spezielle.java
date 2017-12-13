package labExam1002;

public abstract class Spezielle extends User {

    public Spezielle(String account, Password pw, Person person) {
        super(account, pw, person);
        // TODO Auto-generated constructor stub
    }


    public String toString() {
        return String.format("Spezielle [toString()=%s]", super.toString());
    }

 
    

}
