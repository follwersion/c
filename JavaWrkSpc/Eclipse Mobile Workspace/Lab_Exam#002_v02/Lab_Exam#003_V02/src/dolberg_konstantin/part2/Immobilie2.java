package dolberg_konstantin.part2;

import untouchable.Adresse_I;
import untouchable.Immobilie_I;

public abstract class Immobilie2 implements Immobilie_I {
    
    private Adresse_I adresse;
    private String besitzer;
    private int preis;
    private int flaeche;
    private Status2 status;
    
    public Immobilie2(Adresse_I adresse, String besitzer, int preis, int flaeche) {
        this.adresse = adresse;
        this.besitzer = besitzer;
        this.preis = preis;
        this.flaeche = flaeche;
        this.status = Status2.PRUEF;
    }

    public String toString() {
        return String.format(
                "Immobilie2 [adresse=%s, besitzer=%s, flaeche=%s, preis=%s]",
                adresse, besitzer, flaeche, preis);
    }

    public Adresse_I getAdresse() {
        return this.adresse;
    }

    public String getBesitzer() {
        return this.besitzer;
    }

    public int getFlaeche() {
        return this.flaeche;
    }

    public int getPreis() {
        return this.preis;
    }

    public void setStatus(Status2 status) {
        this.status = status;
    }

    public Status2 getStatus() {
        return status;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Immobilie2 other = (Immobilie2) obj;
        if (adresse == null) {
            if (other.adresse != null)
                return false;
        } else if (!adresse.equals(other.adresse))
            return false;
        if (besitzer == null) {
            if (other.besitzer != null)
                return false;
        } else if (!besitzer.equals(other.besitzer))
            return false;
        if (flaeche != other.flaeche)
            return false;
        if (preis != other.preis)
            return false;
        if (status == null) {
            if (other.status != null)
                return false;
        } else if (!status.equals(other.status))
            return false;
        return true;
    }
        
}
