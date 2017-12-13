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

public class Kfz extends Vehikel {
    private String kraftstoff;     
    
    public Kfz(String vTyp, String vName, String farbe, boolean zustand, boolean verfügbarkeit,String kraftstoff) {
        super(vTyp, vName, farbe, zustand, verfügbarkeit);
        this.kraftstoff=kraftstoff;       
    }
    public void setKraftstoff(String kraftstoff) {
        this.kraftstoff = kraftstoff;
    }
    public String getKraftstoff() {
        return kraftstoff;
    }   
    public String toString() {
        return super.toString()+String.format("\nKraftstoff: %s", getKraftstoff());
    }
}