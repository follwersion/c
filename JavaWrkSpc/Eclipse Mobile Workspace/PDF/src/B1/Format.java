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

public enum Format {
    PAL, NTSC;
    public String toString() {
        String resu;

        switch (this) {
            case PAL:
                resu = "PAL";
                break;
            case NTSC:
                resu = "NTSC";
                break;
            default:
                resu = "";
        }
        return resu;
    }
}