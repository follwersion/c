package dolberg_konstantin.part1;

public class AdresseWE1 extends Adresse1 {
    
    private int etage;
    private int wNr;
    
    public AdresseWE1(String ort, String srasse, int hausNr, int etage, int wNr) {
        super(ort, srasse, hausNr);
        this.etage = etage;
        this.wNr = wNr;
    }

    public String toString() {
        return super.toString() + String.format("AdresseWE1 [etage=%s, wNr=%s]", etage, wNr);
    }
    
}
