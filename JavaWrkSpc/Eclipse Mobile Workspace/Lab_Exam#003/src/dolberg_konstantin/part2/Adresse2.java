package dolberg_konstantin.part2;

import untouchable.Adresse_I;

public class Adresse2 implements Adresse_I {
    
    private String ort;
    private String srasse;
    private int hausNr;
    
    public Adresse2(String ort, String srasse, int hausNr) {
        this.ort = ort;
        this.srasse = srasse;
        this.hausNr = hausNr;
    }

    public String toString() {
        return String.format("Adresse2 [hausNr=%s, ort=%s, srasse=%s]", hausNr,
                ort, srasse);
    }

    public int getHausNr() {
        return this.hausNr;
    }

    public String getOrt() {
        return this.ort;
    }

    public String getStrasse() {
        return this.srasse;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Adresse2 other = (Adresse2) obj;
        if (hausNr != other.hausNr)
            return false;
        if (ort == null) {
            if (other.ort != null)
                return false;
        } else if (!ort.equals(other.ort))
            return false;
        if (srasse == null) {
            if (other.srasse != null)
                return false;
        } else if (!srasse.equals(other.srasse))
            return false;
        return true;
    }    
}
