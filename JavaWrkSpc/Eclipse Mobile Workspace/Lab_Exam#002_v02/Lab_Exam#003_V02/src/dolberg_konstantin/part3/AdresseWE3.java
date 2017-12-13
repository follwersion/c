package dolberg_konstantin.part3;

public class AdresseWE3 extends Adresse3 {
    
    private int etage;
    private int wNr;
    
    public AdresseWE3(String ort, String srasse, int hausNr, int etage, int wNr) {
        super(ort, srasse, hausNr);
        this.etage = etage;
        this.wNr = wNr;
    }

    public String toString() {
        return super.toString() + String.format("AdresseWE3 [etage=%s, wNr=%s]", etage, wNr);
    }

    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + etage;
        result = prime * result + wNr;
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        AdresseWE3 other = (AdresseWE3) obj;
        if (etage != other.etage)
            return false;
        if (wNr != other.wNr)
            return false;
        return true;
    }
}
