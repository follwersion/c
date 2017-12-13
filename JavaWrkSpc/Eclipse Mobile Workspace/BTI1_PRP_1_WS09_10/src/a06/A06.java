/*
 * Praktikum:           P1P 
 * Semester:            WS09
 * Team-Name:           S3T4
 * Namen:               Dolberg, Konstantin     #1959949
 *                      Eisenbraun, Alexander   #1965085
 * Aufgaben-Nr.:        A06
 * Kontrolleur:         Sch�fers
 * Datum der Abnahme:   03.12.2009
 * Quellen:             URL: https://pub.informatik.haw-hamburg.de/home/pub/prof/schafers/S09W_P1/Aufgabenzettel_Nr3_v05.pdf
 *                      URL: http://java.sun.com/j2se/1.4.2/docs/api/java/util/List.html
 *                      URL: http://java.sun.com/javase/6/docs/api/java/util/Comparator.html
 */
package a06;

import java.util.ArrayList;
import cards.Card;
import cards.Deck;

public class A06 {

    public static void main(String[] args) {

        // Card [] karte = {DK,HT,H7,S6,S4,C4,C3}; //Straight
        // Card [] karte = {SK,DK,DJ,S5,S4,S3,S2}; //flush
        // Card [] karte = {CA,C5,C4,C3,C2,C9,D3}; //wheel als Straight Flush
        // Card [] karte = {CA,D5,C4,C3,D2,C9,H3}; //wheel als Straight
        // Card [] karte = {CA,CK,CQ,CJ,CT,C8,C2}; //royal
        // Card [] karte = {CK,C9,C7,CJ,CT,CQ,C2}; //Straight Flush
        // Card [] karte = {HK,HQ,DJ,ST,C9,C8,C2}; //Straight
        // Card [] karte = {HK,DK,CK,SK,C9,D9,H9}; //vierling+drilling
        // Card [] karte = {HK,DK,CK,SK,CT,DT,H5}; //vierling
        // Card [] karte = {HK,DK,CK,SQ,CQ,D9,H9}; //drilling+paar
        // Card [] karte = {HK,DK,CK,ST,CQ,D7,H9}; //drilling+highcard
        // Card [] karte = {HK,D5,CJ,ST,C9,D6,H2}; // nur einer
        // Card [] karte = {HA,HK,HJ,H9,H7,H5,H2}; //Flush
        // Card [] karte = {HJ,HT,H3,H2,C9,D9,H9}; //Flush
        // Card [] karte = {HJ,DJ,H8,S8,C9,D9,DT}; // 3 Zweier
        // Card [] karte = {SK,DQ,HJ,ST,C9,D7,D2}; //Stra�e
        // Card [] karte = {SK,DQ,HJ,ST,C9,CQ,D2}; //Stra�e
        // Card [] karte = {HA,DA,ST,DT,C9,D9,S5}; // Zweier
        // Card [] karte = {HA,C8,S4,D3,C2,D2,D5}; // 2 Zweier + straight
        // Card [] karte = {HA,DA,SQ,DJ,CT,DT,DK}; // 2 Zweier + straight

        for (int i = 0; i < 1000; i++) {
            System.out.println("DurchlaufNr.: " + i);
            Deck stapel = new Deck();
            Card[] karte = new Card[7];
            for (int j = 0; j < karte.length; j++) {
                karte[j] = stapel.deal();
            }
            System.out.println("Unsortiert:");
            for (int j = 0; j < karte.length; j++) {
                System.out.print(karte[j]);
            }
            ControlPoker checker = new ControlPoker();
            ArrayList<Card> hand = new ArrayList<Card>();
            // ArraySortieren & Ausgeben
            hand = checker.sortArray(karte);
            System.out.print("\nSortiert:\n");
            // Erstellen eines neuen Objekts der ControlPoker klasse und Ausgabe
            ControlPoker checker2 = new ControlPoker(hand);
            System.out.println(hand);
            System.out.println(checker2.bestHand(hand) + "\n");
        }
    }
}