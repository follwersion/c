package dolberg_konstantin.part1;

import untouchable.Adresse_I;

public class ImmoGewerbe1 extends Immobilie1 {
    
    private int drecksKlasse;

    public ImmoGewerbe1(Adresse_I adresse, String besitzer, int preis,
            int flaeche, int drecksKlasse) {
        super(adresse, besitzer, preis, flaeche);
        this.drecksKlasse = drecksKlasse;
    }

    public String toString() {
        return super.toString() + String.format("ImmoGewerbe1 [drecksKlasse=%s]", drecksKlasse);
    }
}
