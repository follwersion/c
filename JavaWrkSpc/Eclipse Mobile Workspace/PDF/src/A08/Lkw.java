/*
 * Praktikum:           P1P 
 * Semester:            WS09
 * Team-Name:           S3T4
 * Namen:               Dolberg, Konstantin     #1959949
 *                      Eisenbraun, Alexander   #1965085
 * Aufgaben-Nr.:        A08
 * Kontrolleur:     
 * Datum der Abnahme:   03.12.2009
 * Quellen:             URL: https://pub.informatik.haw-hamburg.de/home/pub/prof/schafers/S09W_P1/Aufgabenzettel_Nr4_v08.pdf
 */
package a08;

public class Lkw extends Kfz {
    private int zuladung;
    private static final String vTyp = "LKW";
    
    public Lkw( String vName, String farbe,  boolean zustand, boolean verfügbarkeit, String kraftstoff, int zuladung) {
        super(vTyp,vName, farbe,  zustand, verfügbarkeit, kraftstoff);
        this.zuladung = zuladung;
        double kosten;
        kosten = zuladung < 10 ? 8000f : zuladung >= 10 && zuladung < 20 ? 9000 : zuladung >= 20 && zuladung < 30 ? 10000 : zuladung >= 30 && zuladung < 40 ? 12500
                : 20000;
        setKosten(kosten);
    }
    public void setZuladung(int zuladung) {
        this.zuladung = zuladung;
    }
    public int getZuladung() {
        return zuladung;
    }
    public void warten() {
        System.out.println("Lkw (#" + getId() + ") wurde gewartet");
        setZustand(true);
    }
    public String toString() {
        return super.toString() + String.format("\nZuladung: %s\n", getZuladung() + "\n");
    }
    public static String getVtyp() {
        return vTyp;
    }
}