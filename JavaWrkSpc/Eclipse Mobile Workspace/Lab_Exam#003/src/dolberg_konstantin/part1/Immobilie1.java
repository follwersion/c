package dolberg_konstantin.part1;

import untouchable.Adresse_I;
import untouchable.Immobilie_I;

public abstract class Immobilie1 implements Immobilie_I {
    
    private Adresse_I adresse;
    private String besitzer;
    private int preis;
    private int flaeche;
    
    public Immobilie1(Adresse_I adresse, String besitzer, int preis, int flaeche) {
        this.adresse = adresse;
        this.besitzer = besitzer;
        this.preis = preis;
        this.flaeche = flaeche;
    }

    public String toString() {
        return String.format(
                "Immobilie1 [adresse=%s, besitzer=%s, flaeche=%s, preis=%s]",
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
}
