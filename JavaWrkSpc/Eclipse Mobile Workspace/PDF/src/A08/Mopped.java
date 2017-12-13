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

public class Mopped extends Kfz {
    private double hubraum;
    private static final String vTyp = "Motorrad";
    public Mopped(String vName, String farbe,  boolean zustand, boolean verfügbarkeit, String kraftstoff, double hubraum) {
        super (vTyp, vName, farbe, zustand, verfügbarkeit, kraftstoff);
        this.hubraum = hubraum;
        double kosten;
        kosten = hubraum < 100 ? 500 : hubraum >= 100 && hubraum < 250 ? 1000 : hubraum >= 250 && hubraum < 500 ? 3000 : hubraum >= 500 && hubraum < 1000 ? 6000
                : 10000;
        setKosten(kosten);
    }
    public void setHubraum(double hubraum) {
        this.hubraum = hubraum;
    }
    public double getHubraum() {
        return hubraum;
    }
    public void warten() {
        System.out.println("Motorrad (#" + getId() + ") wurde gewartet");
        setZustand(true);
    }
    public String toString() {
        return super.toString() + String.format("\nHubraum: %s\n", getHubraum() + "\n");
    }
    public static String getVtyp() {
        return vTyp;
    }
}