package dolberg_konstantin.part3;

public class NonExistingPropertyException3 extends Exception {

    private static final long serialVersionUID = -656831268152561746L;

    public NonExistingPropertyException3() {
        super("Fehler! ");
    }
  
    public String toString() {
        return super.toString() + String.format("NonExistingPropertyException3 []");
    }
}
