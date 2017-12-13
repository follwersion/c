/*
 * Praktikum:			P1P 
 * Semester:			WS09
 * Team-Name:			S3T4
 * Namen:				Dolberg, Konstantin		#1959949
 * 						Eisenbraun, Alexander	#1965085
 * Aufgaben-Nr.:		Z1
 * Kontrolleur:		
 * Datum der Abnahme:	22.10.2009
 * Quellen:             URL: https://pub.informatik.haw-hamburg.de/home/pub/prof/schafers/S09W_P1/Aufgabenzettel_Nr1_v02.pdf
 */
package z01;

import java.util.Scanner;

public class Z01 {

    public static void main(String[] args) {

        int bitAnzahl = 0;

        System.out.print("Zahl deren Bitanzahl ausgegeben werden soll eingeben:\n");
        Scanner scan = new Scanner(System.in);

        long zahl = scan.nextLong();

        System.out.print("Für den Wert: '" + zahl);

        while (zahl != 0) { // Wenn die Zahl 0 ist, werden die
                            // Schleifendurchläufe ausgegeben.
            zahl = zahl / 2;
            bitAnzahl++;
        }

        System.out.print("' lautet das Ergebnis '" + bitAnzahl + "' Bit.");

    }

}
