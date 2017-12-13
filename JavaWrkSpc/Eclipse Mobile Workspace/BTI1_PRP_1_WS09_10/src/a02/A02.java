/*
 * Praktikum:           P1P 
 * Semester:            WS09
 * Team-Name:           S3T4
 * Namen:               Dolberg, Konstantin		#1959949
 *                      Eisenbraun, Alexander	#1965085
 * Aufgaben-Nr.:        A02
 * Kontrolleur:         Schäfers
 * Datum der Abnahme:   22.10.2009
 * Quellen: URL:        .../pub/prof/schafers/S09W_P1/Aufgabenzettel_Nr1_v02.pdf
 *          URL:        http://de.wikipedia.org/wiki/Fibonacci-Folge
 */
package a02;

public class A02 {

    public static void main(String[] args) {

        long wunschAnzahlDerAuszugebendenWerte = 82;
        // Bis zur wievielten Fibonaccizahl wird tatsächlich gerechnet
        // (EingabeWert - 1)
        long echterEingabewert = wunschAnzahlDerAuszugebendenWerte - 1;
        long ergebnis;
        long zahl1 = 0;
        long zahl2 = 1;

        // Der Wertebereich eines "Long" wird sonst überschritten
        if (echterEingabewert > 81) {
            System.out
                    .print(" -Die Rechnung kann nur bis zur 82. Zahl ausgeführt werden- ");
        } else {
            if (echterEingabewert < -1) {
                System.out.print(" -Die Zahl darf nicht negativ sein- ");
            }
            if (echterEingabewert >= 0) {
                System.out.print(zahl1);
            }
            if (echterEingabewert >= 1) {
                System.out.print(", " + zahl2);
            }
            for (int i = 2; i <= echterEingabewert; i++) {
                ergebnis = zahl1 + zahl2;
                zahl1 = zahl2;
                zahl2 = ergebnis;
                System.out.print(", " + ergebnis);
            }
        }
    }
}