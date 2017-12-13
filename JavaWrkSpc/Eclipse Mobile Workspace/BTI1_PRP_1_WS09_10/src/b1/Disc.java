package b1;

abstract class Disc {
     private String titel;
     private Inhalt inhalt;
    
    
    public Disc(String title, Inhalt inhalt) {
     this.titel = title;
     this.inhalt =inhalt;
    }
    public String getTitle() {
        return titel;
    }

    public Inhalt getInhalt() {
        return inhalt;
    }
  
    public String toString() {
        return String.format("[Titel: %s, Inhalt: %s,", titel, inhalt);
    }
    
}
