package a05;

import cards.*;
import static cards.Card.*;

public class A05PRE {

    public static void main(String[] args) {
        Deck stapel = new Deck();
        Card[] karte = new Card[7];
        for (int i = 0; i < karte.length; i++) {
            karte[i] = stapel.deal();
        }
        printCardArray(karte);

        for (int i = 0; i < karte.length - 1; i++) {
            for (int j = i + 1; j < karte.length; j++) {
                if (karte[i].getRank().value() < karte[j].getRank().value()) {
                    Card tmp = karte[j];
                    karte[j] = karte[i];
                    karte[i] = tmp;
                }
            }
        }
        printCardArray(karte);
        
        String club = "C";
        String spades = "S";
        String heart = "H";
        String diamond = "D";
        suite(karte, club);
        suite(karte, spades);
        suite(karte, heart);
        suite(karte, diamond);
    }

    public static void suite(Card[] karte, String tmp) {
        String tmp1 = tmp;
        for (int i = 0; i < karte.length; i++) {
            if (karte[i].getSuit().toString() == tmp1) {
                System.out.println(karte[i]);
            }
        }
    }
}
