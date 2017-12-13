package nachname_vorname.part3;



public class TestFrame {
    
    public static void main(String[] args) {
        ExtendedName name1 = new ExtendedName("Horst","Hansen","Doktor");
        ExtendedName name2 = new ExtendedName("Peter","Pansen","Doktor");
        ExtendedName name3 = new ExtendedName("Uwe","Gans","Doktor");
        
       System.out.println(name1);
       System.out.println(name2);
       System.out.println(name3);
    }

}
