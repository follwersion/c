package labExam1002;

public abstract class User {
    
    String account;
    Password pw;
    Person person;
    int id;
    static int usrCounter = 1;
    
    
    public User(String account, Password pw, Person person) {
        super();
        this.account = account;
        this.pw = pw;
        this.person = person;
        this.id = usrCounter;
        usrCounter++;
    }

    public String toString() {
        return String.format("User [account=%s, id=%s, person=%s, pw=%s]",
                account, id, person, pw);
    }
    

}
