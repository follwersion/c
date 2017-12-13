/*
 * Praktikum:			P1P 
 * Semester:			WS09
 * Team-Name:			S3T4
 * Namen:				Dolberg, Konstantin		#1959949
 * 						Eisenbraun, Alexander	#1965085
 * Aufgaben-Nr.:		A01
 * Kontrolleur:		
 * Datum der Abnahme:	22.10.2009
 * Quellen:				URL: https://pub.informatik.haw-hamburg.de/home/pub/prof/schafers/S09W_P1/Aufgabenzettel_Nr1_v02.pdf
 *                      URL: https://pub.informatik.haw-hamburg.de/home/pub/prof/schafers/S09W_P1/P1TI1_no04_vw02_cw41_091009_v02.pdf
 */
package a01;

public class A01 {

    public static void main(String[] args) {

        int celsius = 0;
        int fahrenheit = 0;
        int schrittfolge = 5;

        System.out.printf("Temperatur-Umrechnungstabelle\n=============================\n%3s %26s", "C", "F\n--------------\n");

        for (int i = 0; i <= 20; i++) {

            fahrenheit = (celsius * 10) * 9 / 5 + 325;

            fahrenheit = fahrenheit / 10;

            System.out.printf("%3s %10s \n", celsius, fahrenheit);

            celsius += schrittfolge;
        }

    }

}
