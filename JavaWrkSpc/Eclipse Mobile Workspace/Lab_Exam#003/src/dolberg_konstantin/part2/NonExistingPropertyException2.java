package dolberg_konstantin.part2;

public class NonExistingPropertyException2 extends Exception {

    private static final long serialVersionUID = 8775097584918675658L;

    public NonExistingPropertyException2() {
        super("Fehler! ");
    }
  
    public String toString() {
        return String.format("NonExistingPropertyException2 []");
    }
}
