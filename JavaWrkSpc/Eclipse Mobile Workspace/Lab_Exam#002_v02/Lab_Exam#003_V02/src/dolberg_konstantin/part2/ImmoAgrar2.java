package dolberg_konstantin.part2;

import untouchable.Adresse_I;

public class ImmoAgrar2 extends Immobilie2 {
    
    private int nutzFlaeche;

    public ImmoAgrar2(Adresse_I adresse, String besitzer, int preis, int flaeche, int nutzFlaeche) {
        super(adresse, besitzer, preis, flaeche);
        this.nutzFlaeche = nutzFlaeche;
    }

    public String toString() {
        return super.toString() + String.format("ImmoAgrar2 [nutzFlaeche=%s]", nutzFlaeche);
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        ImmoAgrar2 other = (ImmoAgrar2) obj;
        if (nutzFlaeche != other.nutzFlaeche)
            return false;
        return true;
    }        
}
