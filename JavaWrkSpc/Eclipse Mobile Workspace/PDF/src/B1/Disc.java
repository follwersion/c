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

abstract class Disc {
    private String titel;
    private Inhalt inhalt;

    public Disc(String title, Inhalt inhalt) {
        this.titel = title;
        this.inhalt = inhalt;
    }

    public String getTitle() {
        return titel;
    }

    public Inhalt getInhalt() {
        return inhalt;
    }

    public String toString() {
        return String.format("[Titel: %s, Inhalt: %s,", titel, inhalt);
    }
}