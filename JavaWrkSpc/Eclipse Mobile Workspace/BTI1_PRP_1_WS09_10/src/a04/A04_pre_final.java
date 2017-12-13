/*
 * Praktikum:           P1P 
 * Semester:            WS09
 * Team-Name:           S3T4
 * Namen:               Dolberg, Konstantin     #1959949
 *                      Eisenbraun, Alexander   #1965085
 * Aufgaben-Nr.:        A03
 * Kontrolleur:     
 * Datum der Abnahme:   22.10.2009
 * Quellen:             URL: https://pub.informatik.haw-hamburg.de/home/pub/prof/schafers/S09W_P1/Aufgabenzettel_Nr1_v02.pdf
 *                      URL: http://www.mathepower.com/primfaktor.php
 */
package a04;
import java.util.ArrayList;

public class A04_pre_final {

    public static void main(String[] args) {
        
        int[][] r1 = {{1,1}, {5,5}};
        int[][] r2 = {{5,5}, {9,9}};  //touching
        int minus = minusChecker(r1, r2);
        r1 = convert2Plus(r1, minus);
        r2 = convert2Plus(r2, minus);
        int länge = längeKoordinatensystem(r1, r2) + 1;
        int[][] koordinatenSystem = new int[länge][länge];

        int px1 = intervallStart(r1[0][0], r1[1][0]);
        int px2 = intervallEnde(r1[0][0], r1[1][0]);
        int py1 = intervallStart(r1[0][1], r1[1][1]);
        int py2 = intervallEnde(r1[0][1], r1[1][1]);
        int qx1 = intervallStart(r2[0][0], r2[1][0]);
        int qx2 = intervallEnde(r2[0][0], r2[1][0]);
        int qy1 = intervallStart(r2[0][1], r2[1][1]);
        int qy2 = intervallEnde(r2[0][1], r2[1][1]);

        koordinatenSystem = fill1(koordinatenSystem, px1, px2, py1, py2);
        koordinatenSystem = fill2(koordinatenSystem, qx1, qx2, qy1, qy2);

        ArrayList<Integer> speicherX = new ArrayList<Integer>();
        ArrayList<Integer> speicherY = new ArrayList<Integer>();
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int checker = 1;
        int checker1 = 1;
        for (int i = 0; i < koordinatenSystem.length; i++) {
            for (int j = 0; j < koordinatenSystem.length; j++) {
                if (koordinatenSystem[i][j] == 3) {
                    count3++;
                    speicherX.add(i);
                    speicherY.add(j);
                }
                if (koordinatenSystem[i][j] == 1) {
                    count1++;
                }
                if (koordinatenSystem[i][j] == 2) {
                    count2++;
                }
            }
        }
        if ( ( count2==0 ) ^ ( count1==0 ) ) {
            System.out.println("contained");
            checker1=0;
        }
        if ( ( count1 == 0 ) && ( count2 == 0 ) ) {
            System.out.println("same");
            checker1 = 0;
        }
        if ( count3 == 1 ) {
            System.out.println("touching");
        } 
        if ( ( speicherX.size() >= 1 ) && ( speicherY.size() >= 1 ) ) {
            if ( speicherX.get(speicherX.size() - 1) == speicherX.get(0)
                    || speicherY.get(speicherY.size() - 1) == speicherY.get(0)) {
                System.out.println("aligned");
                checker1 = 0;
            }
        }
        if (count3 == 0) {
            System.out.println("disjoint");
        } else if (count3 >= 2 && checker != 0 && checker1 != 0) {
            System.out.println("intersecting");
        }
        // Ausgabe
       
        for (int i = koordinatenSystem.length-1; i >=0 ; i--) {
            System.out.print("y"+i+"|");
            for (int j = 0; j < koordinatenSystem.length; j++) {
                System.out.printf("%2d", koordinatenSystem[i][j]);
            }
            System.out.println();
            }
        System.out.println( "x----------->" );
    }// main

    // -------------------------------------------------------------------------
    public static int minusChecker(int[][] r1,int[][] r2) {
        int checker0 = 0;
        for (int i = 0; i < 2; i++) {						//ermitteln des höchsten negativen Wertes
            for (int j = 0; j < 2; j++) {
//                if (r1[i][j] < checker0) {
//                    checker0 = r1[i][j];
//                }
                checker0 = (r1[i][j] < checker0) ? r1[i][j] : checker0;                
//                if (r2[i][j] < checker0) {
//                    checker0 = r2[i][j];
//                }
                checker0 = (r2[i][j] < checker0) ? r2[i][j] : checker0;
            }
        }
        return checker0;
    }// minusChecker
    public static int [][] convert2Plus(int[][] r1,int minusWert) {
        for (int i = 0; i < 2; i++) {						//schieben der Rechtecke in den positiven 
            for (int j = 0; j < 2; j++) {					//Bereich
                r1[i][j] = r1[i][j] - minusWert;
                
            }
        }
        return r1;
    }// convert2Plus
    public static int längeKoordinatensystem(int[][] r1, int[][] r2) {
        int längeSystem = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) { 		// bestimmen des höchsten Werts
//                if (r1[i][j] > längeSystem) { 	// für die größe des
//                    längeSystem = r1[i][j];		// koordinatenwertes
//                }
                längeSystem = (r1[i][j] > längeSystem) ? r1[i][j] : längeSystem;
//                if (r2[i][j] > längeSystem) {
//                    längeSystem = r2[i][j];
//                }
                längeSystem = (r2[i][j] > längeSystem) ? r2[i][j] : längeSystem;
            }
        }
        return längeSystem;
    }// längeKoordinatensystem
    public static int intervallStart(int punkt1, int punkt2) {//ermitteln der startwerte zum füllen
        int start = (punkt1 < punkt2) ? (punkt1) : (punkt2);
        return start;
    }// start

    public static int intervallEnde(int punkt1, int punkt2) {//ermitteln der endwerte zum füllen
        int ende = (punkt1 > punkt2) ? (punkt1) : (punkt2);
        return ende;
    }// ende
    public static int[][] fill1(int[][] feld, int start1, int end1,
            int start2, int end2) {
        for (int i = start1; i <= end1; i++) { // füllen des ersten Rechtecks mit einsen
            for (int j = start2; j <= end2; j++) {
                feld[i][j] = 1;
            }
        }
        return feld;
    }// fill1
    public static int[][] fill2(int[][] feld, int start1, int end1,
            int start2, int end2) {
        for (int i = start1; i <= end1; i++) { // füllen des zweiten Rechtecks
            for (int j = start2; j <= end2; j++) {
                if (feld[i][j] == 1) {
                    feld[i][j] = 3;
                } else {
                    feld[i][j] = 2;
                }
            }
        }
        return feld;
    }// fill2
}// A04_pre_final
