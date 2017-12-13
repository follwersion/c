package dolberg_konstantin.part1;

import untouchable.Adresse_I;

public class Adresse1 implements Adresse_I {
    
    private String ort;
    private String srasse;
    private int hausNr;
    
    public Adresse1(String ort, String srasse, int hausNr) {
        this.ort = ort;
        this.srasse = srasse;
        this.hausNr = hausNr;
    }

    public String toString() {
        return String.format("Adresse1 [hausNr=%s, ort=%s, srasse=%s]", hausNr,
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
}
