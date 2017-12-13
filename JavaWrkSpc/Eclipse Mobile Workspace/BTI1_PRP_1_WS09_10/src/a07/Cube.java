/*
 * Praktikum:           P1P 
 * Semester:            WS09
 * Team-Name:           S3T4
 * Namen:               Dolberg, Konstantin     #1959949
 *                      Eisenbraun, Alexander   #1965085
 * Aufgaben-Nr.:        A07
 * Kontrolleur:     
 * Datum der Abnahme:   03.12.2009
 * Quellen:             URL: https://pub.informatik.haw-hamburg.de/home/pub/prof/schafers/S09W_P1/Aufgabenzettel_Nr3_v05.pdf
 */
package a07;

public class Cube extends Cuboid {

    // Cube-Konstruktor, bei gültigen Cuboid, test auf Cube
    public Cube(Point[] p) {
        super(p);
        check();

    }

    // Test auf Cube
    public boolean check() {
        if (super.checkAnzahlPoints() && super.checkCuboid()) {
            return getBreite() == getHöhe() && getHöhe() == getLänge() ? true
                    : false;
        } else {
            return false;
        }
    }

    public String toString() {
        return super.toString();
    }

    public String myToString() {
        return check() ? String.format("%s", "Würfel")
                : String
                        .format("%s",
                                "Das Objekt ist kein Würfel oder die Ahnzahl der Punkte ist Falsch");
    }
}