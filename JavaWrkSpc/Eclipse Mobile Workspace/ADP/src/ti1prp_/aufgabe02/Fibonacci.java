package ti1prp_.aufgabe02;

/*
 * Praktikum: P1P
 * Semester:  WS07
 * Team:      S1T7
 * Author:    Bruns, Felix   #1907766
 *            Schulz, Thomas #1899432
 * Aufgabe:   A1 - Umrechnung Celsius in Fahrenheit
 */

public class Fibonacci {    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // Vorg�ngerzahlen (a, b) und Maximalanzahl der Zahlen
        long a = 1, b = 1, tmp, i, n = 3;
        
        if(n > 92 || n < 0){
            System.out.printf("Diese Zahl ist zu gro� oder kleiner als 0! W�hlen sie eine Zahl von 0 bis einschlie�lich 92.\n");
            return;
        }
        
        System.out.printf("Fibonacci-Sequenz\n");
        System.out.printf("--------------------------\n");
        
        // Solange a kleiner als der Maximalwert ist
        for(i = 0; i < n; i++){
            System.out.printf("%d%s", a, (i < n - 1)?", ":"");
            
            // Summe der Vorg�ngerzahlen berechnen und diese neu setzen
            tmp = a + b;
            a = b;
            b = tmp;
        }
        
        System.out.printf("\n--------------------------\n");
    }

}
