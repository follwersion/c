package dolberg_konstantin.part2;

import untouchable.Adresse_I;

public class ImmoGewerbe2 extends Immobilie2 {
    
    private int drecksKlasse;

    public ImmoGewerbe2(Adresse_I adresse, String besitzer, int preis,
            int flaeche, int drecksKlasse) {
        super(adresse, besitzer, preis, flaeche);
        this.drecksKlasse = drecksKlasse;
    }

    public String toString() {
        return super.toString() + String.format("ImmoGewerbe2 [drecksKlasse=%s]", drecksKlasse);
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        ImmoGewerbe2 other = (ImmoGewerbe2) obj;
        if (drecksKlasse != other.drecksKlasse)
            return false;
        return true;
    }        
}
