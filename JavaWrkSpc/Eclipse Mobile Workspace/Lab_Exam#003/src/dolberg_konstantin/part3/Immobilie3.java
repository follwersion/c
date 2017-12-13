package dolberg_konstantin.part3;

import untouchable.Adresse_I;
import untouchable.Immobilie_I;

public abstract class Immobilie3 implements Immobilie_I {
    
    private Adresse_I adresse;
    private String besitzer;
    private int preis;
    private int flaeche;
    private Status3 status = Status3.PRUEF;
    
    // "status" wird durch "setStatus" auf seinen defaultWert gesetzt
    public Immobilie3(Adresse_I adresse, String besitzer, int preis, int flaeche) {
        this.adresse = adresse;
        this.besitzer = besitzer;
        this.preis = preis;
        this.flaeche = flaeche;
        this.setStatus(status);
    }
    // den konstruktor überschreiben mit dem zusätzlichen parameter "status"
    public Immobilie3(Adresse_I adresse, String besitzer, int preis, int flaeche, Status3 status) {
        this.adresse = adresse;
        this.besitzer = besitzer;
        this.preis = preis;
        this.flaeche = flaeche;
        this.status = status;
    }

    public String toString() {
        return String.format(
                "Immobilie3 [adresse=%s, besitzer=%s, flaeche=%s, preis=%s, status=%s]",
                adresse, besitzer, flaeche, preis, status);
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

    public void setStatus(Status3 status) {
        this.status = status;
    }

    public Status3 getStatus() {
        return status;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
        result = prime * result
                + ((besitzer == null) ? 0 : besitzer.hashCode());
        result = prime * result + flaeche;
        result = prime * result + preis;
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Immobilie3 other = (Immobilie3) obj;
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
