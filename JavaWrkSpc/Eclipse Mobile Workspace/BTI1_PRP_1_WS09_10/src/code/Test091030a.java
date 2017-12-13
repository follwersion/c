package inDerVorlesung.day091030;


import cards.*;
import static cards.Card.*;
import static cards.Card.Constant.*;


public class Test091030a {

    public static void main(String[] args) {
        
        Deck  d;
        Card[] ca;
        
        
        d = new Deck();
        ca = new Card[5];
        
        
        for ( int i=0; i<ca.length; i++ ){
            ca[i] = d.deal();
        }//for
        
        
        for ( Card c : ca ){
            System.out.print( c );
        }//for
        System.out.println();
        printCardArray( ca );
        
        
        for ( int i=0;  i<ca.length-1;  i++ ){
            for (int j = i+1;  j<ca.length;  j++ ){
                if ( ca[i].getRank().value() < ca[j].getRank().value() ){
                    Card tmp = ca[j];
                    ca[j] = ca[i];
                    ca[i] = tmp;
                }//if
            }//for
        }//for
        printCardArray( ca );
        
        System.out.printf( "###############################################################################\n" );
        
        
        
        for ( int i=0; i<ca.length; i++ ){
            ca[i] = d.deal();
        }//for
        printCardArray( ca );
        
        
        for ( int i=ca.length-1;  i>0;  i-- ){
            for ( int j=0;  j<i;  j++ ){
                if ( ca[j].getRank().value() < ca[j+1].getRank().value() ){
                    Card tmp = ca[j];
                    ca[j] = ca[j+1];
                    ca[j+1] = tmp;
                }//if
            }//for
        }//for
        printCardArray( ca );
        
    }//main
    
    // Siehe auch: https://pub.informatik.haw-hamburg.de/home/pub/prof/schafers/S07W_P1/JavaCode/DemoSort071031.java

}//Test091030a