/*
 * Praktikum:           P1P 
 * Semester:            WS09
 * Team-Name:           S3T4
 * Namen:               Dolberg, Konstantin     #1959949
 *                      Eisenbraun, Alexander   #1965085
 * Aufgaben-Nr.:        B1
 * Kontrolleur:         Behnke
 * Datum der Abnahme:   14.01.2010
 * Quellen:             URL: https://pub.informatik.haw-hamburg.de/home/pub/prof/schafers/S09W_P1/Aufgabenzettel_Nr5_v06.pdf
 */
package b1;

public class CD extends Disc {
    private String interpret;

    CD(String title, Inhalt inhalt, String interpret) {
        super(title, inhalt);
        this.interpret = interpret;
    }

    public String getInterpret() {
        return interpret;
    }

    public String toString() {
        return (super.toString() + ", Interpret: " + interpret + "]");
    }
}