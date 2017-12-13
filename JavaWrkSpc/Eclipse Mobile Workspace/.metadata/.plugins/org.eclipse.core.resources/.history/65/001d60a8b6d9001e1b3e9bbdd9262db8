/*
 * Praktikum:           P1P
 * Semester:            WS09
 * Team-Name:           S3T4
 * Namen:               Dolberg, Konstantin #1959949
 *                      Eisenbraun, Alexander #1965085
 * Aufgaben-Nr.:        A01
 * Kontrolleur:         Schäfers
 * Datum der Abnahme:   22.10.2009
 * Quellen: URL:        .../pub/prof/schafers/S09W_P1/Aufgabenzettel_Nr1_v02.pdf
 *                      .../pub/prof/schafers/S09W_P1/P1TI1_no04_vw02_cw41_091009_v02.pdf
 */
package a01;

public class A01 {

    public static void main(String[] args) {

        int celsius = 0;
        int fahrenheit = 0;
        int schrittfolge = 3;
        System.out.printf("Temperatur-Umrechnungstabelle\n"
                + "=============================\n%3s %26s", "C",
                "F\n--------------\n");
        // Variante 2:
        for (; celsius <= 20; celsius += schrittfolge) {
            fahrenheit = (int) (celsius * 1.8 + 32.5);
            System.out.printf("%3s %10s \n", celsius, fahrenheit);
        }
    }
}

// Variante 1:
// for (int i = 0; i <= (100/schrittfolge); i++) {
// fahrenheit = (celsius * 10) * 9 / 5 + 325; fahrenheit = fahrenheit / 10;
// System.out.printf("%3s %10s \n", celsius, fahrenheit);
// celsius += schrittfolge;
// }
