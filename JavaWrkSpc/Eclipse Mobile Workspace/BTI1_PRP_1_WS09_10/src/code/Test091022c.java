package inDerVorlesung.day091022;


import cards.*;
import static cards.Card.*;
import static cards.Card.Constant.*;


public class Test091022c {

    public static void main(String[] args) {
        
        Deck d = new Deck();
        Card c;

        for (int i = 1; i < 54; i++) {
            if ( i== 52 ) System.out.println();
            c = d.deal();
            System.out.printf( "%d->%s",  i, c );
        }//for
        
    }//main

}//Test091022c
