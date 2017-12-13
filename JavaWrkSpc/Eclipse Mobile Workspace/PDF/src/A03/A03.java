/*
 * Praktikum:           P1P 
 * Semester:            WS09
 * Team-Name:           S3T4
 * Namen:               Dolberg, Konstantin     #1959949
 *                      Eisenbraun, Alexander   #1965085
 * Aufgaben-Nr.:        A03
 * Kontrolleur:         Sch�fers
 * Datum der Abnahme:   22.10.2009
 * Quellen: URL:        .../pub/prof/schafers/S09W_P1/S09W_P1/Aufgabenzettel_Nr1_v02.pdf
 *          URL:        http://www.mathepower.com/primfaktor.php                
 */
package a03;

public class A03 {

    public static void main(String[] args) {

        long zuZerlegenderWert = 51539607816L;
        long stop = (long) (Math.sqrt(zuZerlegenderWert));
        if (zuZerlegenderWert <= 1) {
            System.out.print("Die Primfaktorzerlegung muss f�r eine nat�rliche Zahl die nicht 0 oder 1 ist berechnet werden!");
        } else {
            System.out.print(zuZerlegenderWert + "= ");
            // Variable "i" ist der jeweilige Teiler.
            for (long i = 2; i <= stop; i++) {
                // Ist die Zahl ohne Rest durch 2 teilbar, wird durch 2 geteilt
                // und ausgegeben.
                while (zuZerlegenderWert % i == 0) {
                    zuZerlegenderWert = zuZerlegenderWert / i;
                    System.out.print(i);
                    // Wenn der Wert durch i 1 ist, ist die Primfaktorzerlegung
                    // abgeschlossen.
                    if (zuZerlegenderWert >= 2) {
                        System.out.print("*");
                    }
                }
            }
            if (zuZerlegenderWert > 1) {
                System.out.print(zuZerlegenderWert);
            }
        }
    }
}