package dolberg_konstantin.part1;

import untouchable.Adresse_I;

public class ImmoAgrar1 extends Immobilie1 {
    
    private int nutzFlaeche;

    public ImmoAgrar1(Adresse_I adresse, String besitzer, int preis, int flaeche, int nutzFlaeche) {
        super(adresse, besitzer, preis, flaeche);
        this.nutzFlaeche = nutzFlaeche;
    }

    public String toString() {
        return super.toString() + String.format("ImmoAgrar1 [nutzFlaeche=%s]", nutzFlaeche);
    }
}
