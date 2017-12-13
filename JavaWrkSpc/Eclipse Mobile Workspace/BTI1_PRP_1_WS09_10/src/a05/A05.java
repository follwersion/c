/*
 * Praktikum:           P1P 
 * Semester:            WS09
 * Team-Name:           S3T4
 * Namen:               Dolberg, Konstantin     #1959949
 *                      Eisenbraun, Alexander   #1965085
 * Aufgaben-Nr.:        A05
 * Kontrolleur:         Behnke
 * Datum der Abnahme:   05.11.2009
 * Quellen:             URL: https://pub.informatik.haw-hamburg.de/home/pub/prof/schafers/S09W_P1/Aufgabenzettel_Nr2_v05.pdf
 *                      URL: http://java.sun.com/j2se/1.3/docs/api/java/util/ArrayList.html
 */
package a05;

import java.util.ArrayList;
import cards.*;
import static cards.Card.*;
import static cards.Card.Constant.*;

public class A05 {

    public static void main(String[] args) {
        // Zufallsdeck erstellen und in das Array "karte" schreiben
        Deck stapel = new Deck();
        Card[] karte = new Card[7];
        for (int i = 0; i < karte.length; i++) {
            karte[i] = stapel.deal();
        }
        // Zufallsdeck sortieren und in das Array "karte" schreiben
        for (int i = 0; i < karte.length - 1; i++) {
            for (int j = i + 1; j < karte.length; j++) {
                if (karte[i].getRank().value() < karte[j].getRank().value()) {
                    Card tmp = karte[j];
                    karte[j] = karte[i];
                    karte[i] = tmp;
                }
            }
        }
        // Sortiertes Array "karte" auf der Console ausgeben
        printCardArray(karte);
        System.out.println("\nSortiert nach Farben:");
        suite(karte, CLUB);
        suite(karte, SPADES);
        suite(karte, HEART);
        suite(karte, DIAMOND);
        System.out.println();
        System.out.println("\n" + auswerten(karte));
    }
    // Farben sortieren und ausgeben
    public static void suite(Card[] karte, Suit tmp) {
        int flushCounter = 0;
        for (int i = 0; i < karte.length; i++) {
            if (karte[i].getSuit() == tmp) {
                flushCounter++;
                System.out.println(tmp.toString() + karte[i]);
            }
        }
    }
    // Array "karte" auf Einlinge, Zwillinge, Drillinge, Vierlinge auswerten
    public static ArrayList<ArrayList<Card>> auswerten(Card[] karte) {
        ArrayList<ArrayList<Card>> g = new ArrayList<ArrayList<Card>>();
        ArrayList<Card> vier = new ArrayList<Card>();
        ArrayList<Card> drei = new ArrayList<Card>();
        ArrayList<Card> zwei = new ArrayList<Card>();
        ArrayList<Card> ein = new ArrayList<Card>();

        int i = 0;
        while (i < karte.length) {
            if ((i < karte.length - 3 && karte[i].getRank().value() == karte[i + 1].getRank().value()) && (karte[i + 1].getRank().value() == karte[i + 2].getRank().value()) && (karte[i + 2].getRank().value() == karte[i + 3].getRank().value())) {
                System.out.println("Vierling" + karte[i] + " " + karte[i + 1] + " " + karte[i + 2] + " " + karte[i + 3]);
                vier.add(karte[i]);
                vier.add(karte[i + 1]);
                vier.add(karte[i + 2]);
                vier.add(karte[i + 3]);
                i += 4;
            } else if ((i < karte.length - 2 && karte[i].getRank().value() == karte[i + 1].getRank().value()) && (karte[i + 1].getRank().value() == karte[i + 2].getRank().value())) {
                System.out.printf("Drilling: %5s %5s %5s\n", karte[i], karte[i + 1], karte[i + 2]);
                drei.add(karte[i]);
                drei.add(karte[i + 1]);
                drei.add(karte[i + 2]);
                i += 3;
            } else if ((i < karte.length - 1 && karte[i].getRank().value() == karte[i + 1].getRank().value())) {
                System.out.printf("Zwilling: %5s %5s\n", karte[i], karte[i + 1]);
                zwei.add(karte[i]);
                zwei.add(karte[i + 1]);
                i += 2;
            } else {
                System.out.printf("Einling: %7s\n", karte[i]);
                ein.add(karte[i]);
                i++;
            }
        }
        g.add(ein);
        g.add(zwei);
        g.add(drei);
        g.add(vier);
        return g;
    }
}