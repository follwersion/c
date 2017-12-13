package dolberg_konstantin.part3;

import untouchable.Adresse_I;

public class ImmoAgrar3 extends Immobilie3 {
    
    private int nutzFlaeche;

    public ImmoAgrar3(Adresse_I adresse, String besitzer, int preis, int flaeche, int nutzFlaeche) {
        super(adresse, besitzer, preis, flaeche);
        this.nutzFlaeche = nutzFlaeche;
    }
    // den konstruktor überschreiben mit dem zusätzlichen parameter "status" aus sder superklasse
    public ImmoAgrar3(Adresse_I adresse, String besitzer, int preis, int flaeche, int nutzFlaeche, Status3 status) {
        super(adresse, besitzer, preis, flaeche, status);
        this.nutzFlaeche = nutzFlaeche;
    }

    public String toString() {
        return super.toString() + String.format("ImmoAgrar3 [nutzFlaeche=%s]", nutzFlaeche);
    }

    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + nutzFlaeche;
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        ImmoAgrar3 other = (ImmoAgrar3) obj;
        if (nutzFlaeche != other.nutzFlaeche)
            return false;
        return true;
    }        
}
