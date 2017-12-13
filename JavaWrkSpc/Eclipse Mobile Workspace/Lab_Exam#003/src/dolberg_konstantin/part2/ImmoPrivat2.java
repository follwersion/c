package dolberg_konstantin.part2;

import untouchable.Adresse_I;

public class ImmoPrivat2 extends Immobilie2 {
    
    private int anzZimmer;

    public ImmoPrivat2(Adresse_I adresse, String besitzer, int preis, int flaeche, int anzZimmer) {
        super(adresse, besitzer, preis, flaeche);
        this.anzZimmer = anzZimmer;
    }
 
    public String toString() {
        return super.toString() + String.format("ImmoPrivat2 [anzZimmer=%s]", anzZimmer);
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        ImmoPrivat2 other = (ImmoPrivat2) obj;
        if (anzZimmer != other.anzZimmer)
            return false;
        return true;
    }    
}
