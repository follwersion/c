package ti1prp_.aufgabe01;

/*
 * Praktikum: P1P
 * Semester:  WS07
 * Team:      S1T7
 * Author:    Bruns, Felix   #1907766
 *            Schulz, Thomas #1899432
 * Aufgabe:   A1 - Umrechnung Celsius in Fahrenheit
 */

public class Celsius2Fahrenheit {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // Integer Variable, die den Celsius Wert enthält. 
        int cel;
        
        // Ausgabe des Anfangs der Tabelle.
        System.out.printf("Celsius\t=>\tFahrenheit\n");
        System.out.printf("--------------------------\n");
        
        // Start bei 0, Ende bei 100 Grad Celsius, 5er Schritte.
        for(cel = 0; cel <= 100; cel += 3){
            // Berechnung, Rundung und Ausgabe des Fahrenheit Wertes.
            System.out.printf("%d°C\t=>\t%d°F\n", cel, (int)((cel * 9.0/5.0 + 32.0) + 0.5));
        }
        
        // Ende der Tabelle.
        System.out.printf("--------------------------\n");
    }
}
