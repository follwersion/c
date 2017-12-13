package ti1prp_.aufgabe03;

/*
 * Praktikum: P1P
 * Semester:  WS07
 * Team:      S1T7
 * Author:    Bruns, Felix   #1907766
 *            Schulz, Thomas #1899432
 * Aufgabe:   A1 - Umrechnung Celsius in Fahrenheit
 */

public class PrimeFactorization {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // Zahl, die in Primfaktoren zerlegt werden soll
        long number = 123456, i, j;
        
        // Ist die Zahl zulässig?
        if(number < 1){
            System.out.printf("Die Zahl muss größer als 0 sein!!!\n");
            return;
        }
        
        System.out.printf("Primfaktoren von %d\n", number);
        System.out.printf("--------------------------\n");
        
        // Solange i kleiner gleich der Zahl ist
        for(i = 2, j = 0; i <= number; ){
            // Ist die Zahl durch i teilbar?
            if(number % i == 0){
                // Ja! Zahl durch i teilen aber i nicht erhöhen!!
                number /= i;
                if(j > 0) System.out.printf("*");
                System.out.printf("%d", i);
                j++;
            }
            else{
                // i erhöhen, wenn die Zahl nicht durch i teilbar war.
                i++;
            }
        }
        
        System.out.printf("\n--------------------------\n");
    }

}
