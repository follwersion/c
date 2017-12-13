package dolberg_konstantin.part3;

import untouchable.Adresse_I;

public class ImmoPrivat3 extends Immobilie3 {
    
    private int anzZimmer;

    public ImmoPrivat3(Adresse_I adresse, String besitzer, int preis, int flaeche, int anzZimmer) {
        super(adresse, besitzer, preis, flaeche);
        this.anzZimmer = anzZimmer;
    }
    
    public ImmoPrivat3(Adresse_I adresse, String besitzer, int preis, int flaeche, int anzZimmer, Status3 status) {
        super(adresse, besitzer, preis, flaeche, status);
        this.anzZimmer = anzZimmer;
    }
 
    public String toString() {
        return super.toString() + String.format("ImmoPrivat3 [anzZimmer=%s]", anzZimmer);
    }

    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + anzZimmer;
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        ImmoPrivat3 other = (ImmoPrivat3) obj;
        if (anzZimmer != other.anzZimmer)
            return false;
        return true;
    }    
}
