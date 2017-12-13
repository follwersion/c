package b1;

public class CD extends Disc {
    private String interpret;

    CD(String title, Inhalt inhalt, String interpret) {
      super(title, inhalt); 
      this.interpret=interpret;
    }
    public String getInterpret() {
        return interpret;
    }

    public String toString() {
        return (super.toString() + ", Interpret: " + interpret+"]");
    }
}
