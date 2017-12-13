/*
 * Praktikum:           P1P 
 * Semester:            WS09
 * Team-Name:           S3T4
 * Namen:               Dolberg, Konstantin     #1959949
 *                      Eisenbraun, Alexander   #1965085
 * Aufgaben-Nr.:        A06
 * Kontrolleur:     
 * Datum der Abnahme:   19.11.2009
 * Quellen:             URL: https://pub.informatik.haw-hamburg.de/home/pub/prof/schafers/S09W_P1/Aufgabenzettel_Nr3_v05.pdf
 */
package a06;

import java.util.ArrayList;
import cards.*;
import static cards.Card.*;
import static cards.Card.Constant.*;

public class A06_new1 {

    public static void main(String[] args) {

        // Zufallsdeck erstellen und in das Array "karte" schreiben
//        Deck stapel = new Deck();
//        Card[] karte = new Card[7];
//        for (int i = 0; i < karte.length; i++) {
//            karte[i] = stapel.deal();
//        }
        
        // Card [] karte = {SK,DK,DJ,S5,S4,S3,S2}; //flush
        // Card [] karte = {CA,C5,C4,C3,C2,C9,D3}; //wheel als Flush
         Card [] karte = {CA,D5,C4,C3,D2,C9,D7}; //wheel als Straight
        // Card [] karte = {CA,CK,CQ,CJ,CT,C8,C2}; //royal
        // Card [] karte = {CK,C9,C7,CJ,CT,CQ,C2}; //Straight Flush
        // Card [] karte = {HK,HQ,DJ,ST,C9,C8,C2}; //Straight
        // Card [] karte = {HK,DK,CK,SK,C9,D9,H9}; //vierling+drilling
        // Card [] karte = {HK,DK,CK,SK,CT,D9,H8}; //vierling+paar
        // Card [] karte = {HK,DK,CK,SQ,CQ,D9,H9}; //drilling+paar
        // Card [] karte = {HK,DK,CK,ST,CQ,D7,H9}; //drilling+highcard
        // Card [] karte = { HK, DQ, CJ, ST, C9, D6, H2 }; // nur einer
        // Card [] karte = {HA,HK,HQ,HJ,CQ,D9,H9}; //Flush
        // Card [] karte = {HJ,HT,H3,H2,C9,D9,H9}; //Flush
        // Card [] karte = {HJ,DJ,H8,S8,C9,D9,DT}; // 3 Zweier
        // Card [] karte = {SK,DQ,HJ,ST,C9,D7,D2}; //Straße
    	// Card [] karte = {SK,DQ,HJ,ST,C9,CQ,D2}; //Straße
    	 
        System.out.println("Unsortiert:");
        printCardArray(karte); // Unsortiertes Array "karte" ausgeben
        for (int i = 0; i < karte.length - 1; i++) { // Zufallsdeck sortieren
            // und in das Array "karte" schreiben
            for (int j = i + 1; j < karte.length; j++) {
                if (karte[i].getRank().value() < karte[j].getRank().value()) {
                    Card tmp = karte[j];
                    karte[j] = karte[i];
                    karte[i] = tmp;
                }
            }
        }
        System.out.println("Sortiert:");
        printCardArray(karte); // Sortiertes Array "karte" ausgeben
        ArrayList<Card> flush = new ArrayList<Card>();
        flush = suite(karte, CLUB) == null ? flush : suite(karte, CLUB);
        flush = suite(karte, SPADES) == null ? flush : suite(karte, SPADES);
        flush = suite(karte, HEART) == null ? flush : suite(karte, HEART);
        flush = suite(karte, DIAMOND) == null ? flush : suite(karte, DIAMOND);
        ArrayList<Card> karte2 = new ArrayList<Card>();
        if (checkFlush) {
            System.out.println(straight(flush));
        }
        if (!straight) {
            System.out.println(fourOfAKind(auswerten(karte)));
        }
        if (!fourOfKind) {
            System.out.println(fullHouse(auswerten(karte)));
        }
        if (checkFlush && !straight) {
            System.out.println(flush);
        } else if (!checkFlush) {
            for (int i = 0; i < karte.length; i++) {
                karte2.add(karte[i]);
            }
            System.out.println(straight(karte2));
            if (!straight && !fourOfKind && !fullHouse) {
                System.out.println(treeOfAKindAndLess(auswerten(karte)));
            }
        }
    }

    static boolean checkFlush = false;
    static boolean straight = false;
    static boolean fourOfKind = false;
    static boolean fullHouse = false;
    static boolean wheel =false;

    public static ArrayList<Card> straight(ArrayList<Card> karte) {
    	Rank tempFirst= karte.get(0).getRank();
    	Rank tempLast= karte.get(karte.size()-1).getRank();
    	int counterWheel = 0;
        if (karte.size() != 0) {
            boolean royal = false;
            int counterStraight = 0;
            for (int j = 0; j < 1; j++) {
                if (karte.get(0).getRank().value() == ACE.value() && checkFlush) {
                    royal = true;
                }
                // Abfrage auf Straights
                for (int i = 0; i < karte.size(); i++) {
            		System.out.println(i+" "+straight);
            		
            		if(karte.get(0).getRank().value()==ACE.value()){
                    
                    royal = true;
                }	
            		
            		if(karte.get(i).getRank().equals(tempFirst)){
            		tempFirst=tempFirst.decremented();
                    counterStraight++;
                    straight = counterStraight==4 ? true: false;
            		}
                 if(i<karte.size()-1 && karte.get(i).getRank().equals(karte.get(i+1).getRank())){
                	karte.remove(i);
                }
            		if (straight){
            		karte.remove(karte.size()-1);
        		}
            }
            	if(royal && !straight ){
                	for (int i = karte.size()-1; i > 0; i--) {
            			
                		
                    	if( karte.get(0).getRank().equals(ACE) && karte.get(karte.size()-1).getRank().equals(TWO)
                    			&&karte.get(i).getRank().equals(tempLast)){
                			
                			tempLast=tempLast.incremented();
                			wheel=counterWheel==3 ? true : false;
                			counterWheel++;
                		}else{
                			karte.remove(i);
                		}
                	}
            }
            if (checkFlush && royal && straight) {
                System.out.println("ROYAL FLUSH");
            }
            if (straight && !royal) {
                System.out.println("STRAIGHT");
            }
            if (checkFlush && (!straight && royal || straight && !royal || !straight && !royal)) {
                System.out.println("FLUSH");
            }
            }
         }
        return karte;
    }
    // Bei einem vorhandenen Vierling wird dieser + den Kicker in
    // "bestFive" geschrieben
    public static ArrayList<Card> fourOfAKind(ArrayList<ArrayList<Card>> karte) {
        ArrayList<Card> four = new ArrayList<Card>();
        if (!karte.get(0).isEmpty()) {
            for (int i = 0; i < 4; i++) {
                four.add(karte.get(0).get(i));
            }
            System.out.println("Four of a Kind");
            fourOfKind = true;
            if (!karte.get(1).isEmpty()) {
                four.add(karte.get(1).get(0));
            } else if (!karte.get(2).isEmpty()) {
                four.add(karte.get(2).get(0));
            } else {
                four.add(karte.get(3).get(0));
            }
        }
        return four;
    }

    public static ArrayList<Card> fullHouse(ArrayList<ArrayList<Card>> karte) {
        ArrayList<Card> full = new ArrayList<Card>();
        if (karte.get(0).isEmpty() && !karte.get(1).isEmpty() && !karte.get(2).isEmpty()) {
            full.add(karte.get(2).get(0));
            full.add(karte.get(2).get(1));
            full.add(karte.get(1).get(0));
            full.add(karte.get(1).get(1));
            full.add(karte.get(1).get(2));
            System.out.println("FULL HOUSE");
            fullHouse = true;
        }
        return full;
    }

    public static ArrayList<Card> treeOfAKindAndLess(ArrayList<ArrayList<Card>> karte) {
        ArrayList<Card> three = new ArrayList<Card>();
        if (karte.get(0).isEmpty() && !karte.get(1).isEmpty() && karte.get(2).isEmpty()) {
            three.add(karte.get(1).get(0));
            three.add(karte.get(1).get(1));
            three.add(karte.get(1).get(2));
            three.add(karte.get(3).get(0));
            three.add(karte.get(3).get(1));
            System.out.println("Three of a Kind");
        } else if (karte.get(0).isEmpty() && karte.get(1).isEmpty() && !karte.get(2).isEmpty() && karte.get(2).size() == 4) {
            System.out.println("Two Pair");
            for (int i = 0; i <= 3; i++) {
                three.add(karte.get(2).get(i));
            }
            three.add(karte.get(3).get(0));
        } else if (karte.get(2).size() == 2) { // Bei einem Paar, das Paar + die
            // drei Höchsten Einlinge in
            // "three" schreiben
            three.add(karte.get(2).get(0));
            three.add(karte.get(2).get(1));
            System.out.println("One Pair");
            for (int i = 0; i < 3; i++) {
                three.add(karte.get(3).get(i));
            }
        } else if (karte.get(2).size() == 4) { // Bei 2 Paaren + Kicker, oder
            // bei einem Paar + die drei
            // Höchsten karten wird in
            // "three" geschrieben
            three.add(karte.get(2).get(0));
            three.add(karte.get(2).get(1));
            three.add(karte.get(2).get(2));
            three.add(karte.get(2).get(3));
            three.add(karte.get(3).get(0));
        } else if (karte.get(2).size() == 6) { // Bei 3 Paaren ggf. den Einer
            // bevorzugen und in "three"
            // schreiben
            three.add(karte.get(2).get(0));
            three.add(karte.get(2).get(1));
            three.add(karte.get(2).get(2));
            three.add(karte.get(2).get(3));
            System.out.println("Two Pair");
            if (karte.get(2).get(4).getRank().value() < karte.get(3).get(0).getRank().value()) {
                three.add(karte.get(3).get(0));
            } else {
                three.add(karte.get(2).get(4));
            }
        } else {
            for (int i = 0; i < 5; i++) {
                three.add(karte.get(3).get(i));
            }
            System.out.println("High Card");
        }
        return three;
    }

    public static ArrayList<Card> suite(Card[] karte, Suit tmp) { // Farben
        // sortieren
        // und
        // ausgeben
        int flushCounter = 0;
        ArrayList<Card> flush = new ArrayList<Card>();
        for (int i = 0; i < karte.length; i++) {
            if (karte[i].getSuit() == tmp && !straight) {
                flushCounter++;
                flush.add(karte[i]);
            }
        }
        if (flushCounter >= 5) {
            checkFlush = true;
        }
        return flush.size() >= 5 ? flush : null;
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
            if ((i < karte.length - 3 && karte[i].getRank().value() == karte[i + 1].getRank().value())
                    && (karte[i + 1].getRank().value() == karte[i + 2].getRank().value()) && (karte[i + 2].getRank().value() == karte[i + 3].getRank().value())) {
                vier.add(karte[i]);
                vier.add(karte[i + 1]);
                vier.add(karte[i + 2]);
                vier.add(karte[i + 3]);
                i += 4;
            } else if ((i < karte.length - 2 && karte[i].getRank().value() == karte[i + 1].getRank().value())
                    && (karte[i + 1].getRank().value() == karte[i + 2].getRank().value())) {
                drei.add(karte[i]);
                drei.add(karte[i + 1]);
                drei.add(karte[i + 2]);
                i += 3;
            } else if ((i < karte.length - 1 && karte[i].getRank().value() == karte[i + 1].getRank().value())) {
                zwei.add(karte[i]);
                zwei.add(karte[i + 1]);
                i += 2;
            } else {
                ein.add(karte[i]);
                i++;
            }
        }
        g.add(vier);
        g.add(drei);
        g.add(zwei);
        g.add(ein);
        return g;
    }
}
