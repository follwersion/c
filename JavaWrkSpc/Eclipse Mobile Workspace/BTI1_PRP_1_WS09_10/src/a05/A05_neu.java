/*
 * Praktikum:           P1P 
 * Semester:            WS09
 * Team-Name:           S3T4
 * Namen:               Dolberg, Konstantin     #1959949
 *                      Eisenbraun, Alexander   #1965085
 * Aufgaben-Nr.:        A05
 * Kontrolleur:     
 * Datum der Abnahme:   05.11.2009
 * Quellen:             URL: https://pub.informatik.haw-hamburg.de/home/pub/prof/schafers/S09W_P1/Aufgabenzettel_Nr2_v05.pdf
 */
package a05;

import cards.*;
import static cards.Card.*;
import static cards.Card.Constant.*;

public class A05_neu {

    public static void main(String[] args) {
        Card[] karte = { DK, CQ, HQ, SQ, C9, D5, H5 };
        //Card[] karte = { DQ, CQ, HQ, S5, C5, D5, H5 };
        // Card[] karte = { DA, CA, HQ, SQ, CQ, D7, D2 };
        // Card[] karte = { DK, CJ, HT, S9, C9, D9, H9 };

//         Deck stapel = new Deck();
//         Card[] karte = new Card[7];
//         for (int i = 0; i < karte.length; i++) {
//         karte[i] = stapel.deal();
//         }
        printCardArray(karte);

        // Sortieren
        for (int i = 0; i < karte.length - 1; i++) {
            for (int j = i + 1; j < karte.length; j++) {
                if (karte[i].getRank().value() < karte[j].getRank().value()) {
                    Card tmp = karte[j];
                    karte[j] = karte[i];
                    karte[i] = tmp;
                }
            }
        }
        String club = "C";
        String spades = "S";
        String heart = "H";
        String diamond = "D";
        suite(karte, club);
        suite(karte, spades);
        suite(karte, heart);
        suite(karte, diamond);

        Card[] vierling = new Card[4];
        Card[] drilling = new Card[3];
        Card[] zwilling = new Card[2];

        printCardArray(karte);

        int x = 0;
        for (int j = 0; j < karte.length; j++) {
                      
            j = (x > 6) ? j = 6 : j;
                if ((karte[j].getRank().value() == karte[j + 1].getRank().value()) && (karte[j + 1].getRank().value() == karte[j + 2].getRank().value())
                        && (karte[j + 2].getRank().value() == karte[j + 3].getRank().value())) {
                    vierling[0] = karte[j];
                    vierling[1] = karte[j + 1];
                    vierling[2] = karte[j + 2];
                    vierling[3] = karte[j + 3];
                    System.out.println(vierling[0] + " " + vierling[1] + " " + vierling[2] + " " + vierling[3]);
                    x = j + 4;
                    System.out.println(j);
                }            
            System.out.println(j + " " + x);
            j = (x > 6) ? j = 6 : j;
                if ((karte[j].getRank().value() == karte[j + 1].getRank().value()) && (karte[j + 1].getRank().value() == karte[j + 2].getRank().value())) {
                    drilling[0] = karte[j];
                    drilling[1] = karte[j + 1];
                    drilling[2] = karte[j + 2];
                    System.out.println(drilling[0] + " " + drilling[1] + " " + drilling[2]);
                    x = j + 3;
                    System.out.println(j);
                }
            
            System.out.println(j + " " + x);
            j = (x > 6) ? j = 6 : j;
                if ((karte[j].getRank().value() == karte[j + 1].getRank().value())) {
                    zwilling[0] = karte[j];
                    zwilling[1] = karte[j + 1];
                    j++;
                    x = j + 2;
                    System.out.println(zwilling[0] + " " + zwilling[1]);
                }
            
            System.out.println(j + " " + x);
            j = (x < 6) ? j = 6 : j;
            if ((karte[0].getRank().value() != karte[1].getRank().value())) {
                System.out.println(karte[0]);
            }
            for (int j2 = 1; j2 < karte.length - 1; j2++) {
                if ((karte[j2].getRank().value() != karte[j2 + 1].getRank().value())) {
                    if ((karte[j2].getRank().value() != karte[j2 - 1].getRank().value())) {
                        System.out.println(karte[j2]);
                    }
                }
            }
            if ((karte[5].getRank().value() != karte[6].getRank().value())) {
                System.out.println(karte[6]);
            }
        }
    }

    // Methode um Farben nacheinander auszugeben
    public static void suite(Card[] karte, String tmp) {
        String tmp1 = tmp;
        for (int i = 0; i < karte.length; i++) {
            if (karte[i].getSuit().toString() == tmp1) {
                System.out.println(tmp1 + karte[i]);
            }
        }
    }
}
