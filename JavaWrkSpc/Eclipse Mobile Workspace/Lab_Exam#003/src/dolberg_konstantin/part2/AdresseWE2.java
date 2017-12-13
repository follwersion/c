package dolberg_konstantin.part2;

public class AdresseWE2 extends Adresse2 {
    
    private int etage;
    private int wNr;
    
    public AdresseWE2(String ort, String srasse, int hausNr, int etage, int wNr) {
        super(ort, srasse, hausNr);
        this.etage = etage;
        this.wNr = wNr;
    }

    public String toString() {
        return super.toString() + String.format("AdresseWE2 [etage=%s, wNr=%s]", etage, wNr);
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        AdresseWE2 other = (AdresseWE2) obj;
        if (etage != other.etage)
            return false;
        if (wNr != other.wNr)
            return false;
        return true;
    }
}
