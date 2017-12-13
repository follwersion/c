package dolberg_konstantin.part1;

import untouchable.Adresse_I;

public class ImmoPrivat1 extends Immobilie1 {
    
    private int anzZimmer;

    public ImmoPrivat1(Adresse_I adresse, String besitzer, int preis, int flaeche, int anzZimmer) {
        super(adresse, besitzer, preis, flaeche);
        this.anzZimmer = anzZimmer;
    }
 
    public String toString() {
        return super.toString() + String.format("ImmoPrivat [anzZimmer=%s]", anzZimmer);
    }
}
