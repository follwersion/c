/*
 * Praktikum:           P1P 
 * Semester:            WS09
 * Team-Name:           S3T4
 * Namen:               Dolberg, Konstantin     #1959949
 *                      Eisenbraun, Alexander   #1965085
 * Aufgaben-Nr.:        A06
 * Kontrolleur:     
 * Datum der Abnahme:   01.12.2009
 * Quellen:             URL: https://pub.informatik.haw-hamburg.de/home/pub/prof/schafers/S09W_P1/Aufgabenzettel_Nr3_v05.pdf
 *                      URL: http://java.sun.com/j2se/1.4.2/docs/api/java/util/List.html
 *                      URL: http://java.sun.com/javase/6/docs/api/java/util/Comparator.html
 */
package a06_for_a09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import static cards.Card.Constant.*;
import cards.Card;
import cards.Card.*;

public class ControlPoker {
    String resuHand;
    // Default Konstruktor um ein Objekt ohne Parameter erstellen zu k�nnen
    public ControlPoker() {
    }
    // Konstruktor erh�lt die sortierte "hand" und f�hrt alle Methoden aus 
    public ControlPoker(ArrayList<Card> hand) {
        strasse(hand);
        flush(hand);
        fourOfAKind(auswerten(hand));
        fullHouse(auswerten(hand));
        treeOfAKindAndLess(auswerten(hand));
    }
    // [0]=Flush, [1]=Straight, [2]=FourOfAKind, [3]=FullHouse, [4]=ThreeOfAKind
    // [5]=TwoPair, [6]=OnePair, [7]=Wheel, [8]=StraightFlush, [9]=RoyalFLush
    boolean[] bestHand = new boolean[10];
    // Je nach Boolean wird das korrekte ergebnis durch "toString" returned  
    public String bestHand() {
      return resuHand;
    }
    public ArrayList<Card> resuHand(ArrayList<Card> hand) {
        if (bestHand[9]){
            resuHand="STRAIGHT_FLUSH";
            return  flush(hand);
        }
        if (bestHand[8]){
            resuHand="STRAIGHT_FLUSH";
            return  flush(hand);
        }
        if (bestHand[2]){
            resuHand="QUADS";
            return fourOfAKind(auswerten(hand));
        }
        if (bestHand[3]){
            resuHand="FULL_HOUSE";
            return  fullHouse(auswerten(hand));
        }
        if (bestHand[0] ){
            resuHand="FLUSH";
            return  flush(hand);
        }
        if ((bestHand[1] || bestHand[7]) && !bestHand[0]){
            resuHand="STRAIGHT";
            return  strasse(hand);
        }
        if (bestHand[4] && !bestHand[1] && !bestHand[0] && !bestHand[3]){
            resuHand="TRIPS";
            return treeOfAKindAndLess(auswerten(hand));
        }
        if (bestHand[5] && !bestHand[1] && !bestHand[0] && !bestHand[3]){
            resuHand="TWO_PAIR";
            return treeOfAKindAndLess(auswerten(hand));
        }
        if (bestHand[6] && !bestHand[1] && !bestHand[0] && !bestHand[3]){
            resuHand="ONE_PAIR";
            return treeOfAKindAndLess(auswerten(hand));
        }else{
            resuHand="HIGH_CARD";
            return treeOfAKindAndLess(auswerten(hand));
        }
    }
    // Zufallsdeck nach gr��e sortieren
    public ArrayList<Card> sortArray(Card[] karte) {
        ArrayList<Card> sorted = new ArrayList<Card>();
        for (int i = 0; i < karte.length; i++) {
            sorted.add(karte[i]);
        }
        // Mit neuem Comparator sortiert "* (-1)" dreht das ergebnis um
        Collections.sort(sorted, new Comparator<Card>() {
            public int compare(Card o1, Card o2) {
                return o1.compareTo(o2) * -1;
            }
        });
        return sorted;
    }

    // ArrayList "karte" auf Einlinge, Zwillinge, Drillinge, Vierlinge auswerten
    public ArrayList<ArrayList<Card>> auswerten(ArrayList<Card> hand) {
        ArrayList<ArrayList<Card>> g = new ArrayList<ArrayList<Card>>();
        ArrayList<Card> vier = new ArrayList<Card>();
        ArrayList<Card> drei = new ArrayList<Card>();
        ArrayList<Card> zwei = new ArrayList<Card>();
        ArrayList<Card> ein = new ArrayList<Card>();
        int i = 0;
        while (i < hand.size()) {
            if (i < hand.size() - 3 && check(hand, i, 4)) {
                for (int j = 0; j < 4; j++) {
                    vier.add(hand.get(i++));
                }
            } else if (i < hand.size() - 2 && check(hand, i, 3)) {
                for (int j = 0; j < 3; j++) {
                    drei.add(hand.get(i++));
                }
            } else if (i < hand.size() - 1 && check(hand, i, 2)) {
                for (int j = 0; j < 2; j++) {
                    zwei.add(hand.get(i++));
                }
            } else {
                ein.add(hand.get(i++));
            }
        }
        g.add(vier);
        g.add(drei);
        g.add(zwei);
        g.add(ein);
        return g;
    }

    // Redundanz verhindern
    private boolean check(ArrayList<Card> hand, int i, int n) {
        for (int j = 1; j < n; j++) {
            if (!(hand.get(i).getRank().value() == hand.get(i + j).getRank()
                    .value())) {
                return false;
            }
        }
        return true;
    }

    // ArrayList "hand" nach Farben sortieren und ausgeben
    public ArrayList<Card> suite(ArrayList<Card> hand, Suit tmp) {
        int flushCounter = 0;
        ArrayList<Card> flush = new ArrayList<Card>();
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).getSuit() == tmp) {
                flushCounter++;
                flush.add(hand.get(i));
            }
        }
        return flush.size() >= 5 ? flush : null;
    }

    // ArrayList "hand" auf Flush, Straight Flush & Royal Flush testen
    public ArrayList<Card> flush(ArrayList<Card> hand) {
        ArrayList<Card> flush = new ArrayList<Card>();
        flush = suite(hand, CLUB) == null ? flush : suite(hand, CLUB);
        flush = suite(hand, SPADES) == null ? flush : suite(hand, SPADES);
        flush = suite(hand, HEART) == null ? flush : suite(hand, HEART);
        flush = suite(hand, DIAMOND) == null ? flush : suite(hand, DIAMOND);
        bestHand[0] = (flush.size() == 0) ? false : true; //Flush
        if (bestHand[0] && (strasse(flush) != null)) {
            flush = strasse(flush);
            bestHand[8] = (flush.size() == 0) ? false : true; //Straight Flush
        }
        if (bestHand[8] && !bestHand[7] && flush.get(0).getRank().equals(Rank.ACE)) {
            bestHand[9] = true; //Royal Flush
        }        
        //Bei einem Flush mit 7 Karten, die 2 niedrigsten removen
        for (int i = 0; i < 2; i++) {
            if (flush.size() > 5) {
                flush.remove(flush.size() - 1);
            }
        }
        return flush;
    }
    // ArrayList "hand" auf Straight & Straight als Wheel testen
    public ArrayList<Card> strasse(ArrayList<Card> hand) {
        ArrayList<Card> strasse = new ArrayList<Card>();
        strasse.add(hand.get(0));
        for (int i = 0; i < hand.size() - 1; i++) {
            if (!hand.get(i).getRank().equals(hand.get(i + 1).getRank()))
                strasse.add(hand.get(i + 1));
        }
        for (int i = 0; i < strasse.size() - 4; i++) {
            // Die erste minus die letzte Karte ergibt bei einem Straight immer 4
            if (strasse.get(i).getRank().value() - strasse.get(i + 4).getRank().value() == 4) {
                bestHand[1] = true; //Straight
                return new ArrayList<Card>(strasse.subList(i, i + 5)); // Von i bis i + 5 (l�nge des Straight) sublist schreiben
            // Das Ass minus die 5 (strasse.size() - 4) ergibt bei einem Wheel immer 9
            } else if (strasse.get(0).getRank().value() - strasse.get(strasse.size() - 4).getRank().value() == 9) {
                ArrayList<Card> tmp = new ArrayList<Card>();
                tmp.addAll(strasse.subList(strasse.size() - 4, strasse.size()));
                tmp.add(strasse.get(0));
                bestHand[1] = true; //Straight
                bestHand[7] = true; //Wheel
                return tmp;
            }
        }
        return null;
    }
    // ArrayList "hand" auf Four of a kind testen
    public ArrayList<Card> fourOfAKind(ArrayList<ArrayList<Card>> hand) {
        ArrayList<Card> four = new ArrayList<Card>();
        if (!hand.get(0).isEmpty()) {
            for (int i = 0; i < 4; i++) {
                four.add(hand.get(0).get(i));
            }
            bestHand[2] = true; //Four of a kind
            if (!hand.get(1).isEmpty()) {
                four.add(hand.get(1).get(0));
            } else if (!hand.get(2).isEmpty()&& hand.get(2).get(0).getRank().value() > hand.get(3).get(0).getRank().value()) {
                four.add(hand.get(2).get(0));
            } else {
                four.add(hand.get(3).get(0));
            }
        }
        return four;
    }
    // ArrayList "hand" auf Full House testen
    public ArrayList<Card> fullHouse(ArrayList<ArrayList<Card>> karte) {
        ArrayList<Card> full = new ArrayList<Card>();
        if (karte.get(0).isEmpty() && !karte.get(1).isEmpty()
                && !karte.get(2).isEmpty()) {
            full.addAll(adder(karte, 1, 0, 3));
            full.addAll(adder(karte, 2, 0, 2));
            bestHand[3] = true; //Full House
        }
        if (karte.get(0).isEmpty() && (karte.get(1).size() == 6)) {
            full.addAll(adder(karte, 1, 0, 5));
            bestHand[3] = true; //Full House
        }
        return full;
    }
    // ArrayList "hand" auf ThreeOfAKind & alles darunter testen
    public ArrayList<Card> treeOfAKindAndLess(ArrayList<ArrayList<Card>> hand) {
        ArrayList<Card> three = new ArrayList<Card>();
        if (!bestHand[3] && !bestHand[2]) {
            if (hand.get(0).isEmpty() && !hand.get(1).isEmpty()
                    && hand.get(2).isEmpty()) {
                three.addAll(adder(hand, 1, 0, 3));
                three.addAll(adder(hand, 3, 0, 2));
                bestHand[4] = true; //Three of a kind
            } else if (hand.get(0).isEmpty() && hand.get(1).isEmpty()
                    && !hand.get(2).isEmpty() && hand.get(2).size() == 4) {
                three.addAll(adder(hand, 2, 0, 4));
                three.addAll(adder(hand, 3, 0, 1));
                bestHand[5] = true; //Two Pair (2 2er)
            } else if (hand.get(2).size() == 4 && !hand.get(3).isEmpty()) {
                three.addAll(adder(hand, 2, 0, 4));
                three.addAll(adder(hand, 3, 0, 1));
            } else if (hand.get(2).size() == 2 && hand.get(3).size() >= 3) {
                three.addAll(adder(hand, 2, 0, 2));
                three.addAll(adder(hand, 3, 0, 3));
                bestHand[6] = true; //One Pair
            } else if (hand.get(2).size() == 6) {
                three.addAll(adder(hand, 2, 0, 4));
                bestHand[5] = true; //Two Pair (3 2er) & auswahl kicker
                if (hand.get(2).get(4).getRank().value() < hand.get(3).get(0)
                        .getRank().value()) {
                    three.addAll(adder(hand, 3, 0, 1));
                } else {
                    three.addAll(adder(hand, 2, 4, 5));
                }
            } else {
                three.addAll(adder(hand, 3, 0, 5)); //High Card
            }
        }
        return three;
    }
    // Redundanz vermeiden
    private ArrayList<Card> adder(ArrayList<ArrayList<Card>> hand, int a,
            int b, int c) {
        ArrayList<Card> tmp = new ArrayList<Card>();
        for (; b < c; b++) {
            tmp.add(hand.get(a).get(b));
        }
        return tmp;
    }
}