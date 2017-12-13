package inDerVorlesung.day091022;


import cards.*;
import static cards.Card.*;
import static cards.Card.Constant.*;


public class Test091022d {

    public static void main(String[] args) {
        
        Deck d = new Deck();
        Card c;
        
        
        // Solange Karten vom Stapel nehmen bis die Karte eine Pik7 ist
        int i=1;
        do {
            c = d.deal();
            System.out.printf( "%d -> %s\n", i, c );
            i++;
        }while( ! c.equals( S7 ) );
        System.out.printf( "###############################################################################\n\n" );
        
        
        
        // Anzahl Buben in 8 Karten vom Stapel bestimmen
        d = new Deck();
        Card[] a;
        
        // 8 Karten vom Stapel nehmen
        a = new Card[8];
        for (int indx=0; indx<8; indx++){
            a[indx] = d.deal();
            System.out.printf( "%d -> %s", indx, a[indx] );
        }//for
        
        // Anzahl Buben in diesen 8 Karten bestimmen
        int cntJack = 0;
        for (int indx=0; indx<a.length; indx++){
            if ( a[indx].getRank().equals( JACK ) ){
                cntJack++;
            }//if
        }//for
        System.out.printf( "\nNumber of Jacks is %d\n", cntJack );
        
        System.out.printf( "\n###############################################################################\n\n" );
        
    }//main

}//Test091022d
