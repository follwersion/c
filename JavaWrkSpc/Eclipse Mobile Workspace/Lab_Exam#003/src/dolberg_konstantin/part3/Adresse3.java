package dolberg_konstantin.part3;

import untouchable.Adresse_I;

public class Adresse3 implements Adresse_I {
    
    private String ort;
    private String srasse;
    private int hausNr;
    
    public Adresse3(String ort, String srasse, int hausNr) {
        this.ort = ort;
        this.srasse = srasse;
        this.hausNr = hausNr;
    }
    
    public String toString() {
        return String.format("Adresse3 [ort=%s, srasse=%s, hausNr=%s]",
                ort, srasse, hausNr);
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

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + hausNr;
        result = prime * result + ((ort == null) ? 0 : ort.hashCode());
        result = prime * result + ((srasse == null) ? 0 : srasse.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Adresse3 other = (Adresse3) obj;
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
