package _untouchable_;

public class Name {
    private String sname;
    private String fname;
        
    public Name() {
     this.sname ="Eisenbraun";
     this.fname ="Alexander";
    }
    public Name(String fname,String sname){
        this.fname =fname;
        this.sname =sname;        
    }
    public void printName(){
        System.out.printf("\n Nachname = %s ; Vorname = %s", sname, fname);
    }
   
    public String toString() {
        return String.format("%s [fname=%s, sname=%s] ",this.getClass().getName() ,fname , sname);
    }
    
   
    
}
