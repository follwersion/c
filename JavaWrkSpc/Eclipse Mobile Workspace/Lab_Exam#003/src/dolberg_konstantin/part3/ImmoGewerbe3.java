package dolberg_konstantin.part3;

import untouchable.Adresse_I;

public class ImmoGewerbe3 extends Immobilie3 {
    
    private int drecksKlasse;

    public ImmoGewerbe3(Adresse_I adresse, String besitzer, int preis,
            int flaeche, int drecksKlasse) {
        super(adresse, besitzer, preis, flaeche);
        this.drecksKlasse = drecksKlasse;
    }
    
    public ImmoGewerbe3(Adresse_I adresse, String besitzer, int preis,
            int flaeche, int drecksKlasse, Status3 status) {
        super(adresse, besitzer, preis, flaeche, status);
        this.drecksKlasse = drecksKlasse;
    }

    public String toString() {
        return super.toString() + String.format("ImmoGewerbe3 [drecksKlasse=%s]", drecksKlasse);
    }

    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + drecksKlasse;
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        ImmoGewerbe3 other = (ImmoGewerbe3) obj;
        if (drecksKlasse != other.drecksKlasse)
            return false;
        return true;
    }        
}
