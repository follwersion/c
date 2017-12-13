package aufgabenzettel4_A9.test;

import cards.*;
import cards.Card.*;
import static cards.Card.Constant.*;

public class Test {
    
    final int numOfPlayers = 5;
    
    private Card[][] playerHoleCards;
    private Card[]   communityCards;
    
    public Test( Card[] cards ){
        if ( cards.length == 15 ){
            
            for ( int i=0; i<14; i++ ){
                for ( int j=i+1; j<15; j++ ){
                    if ( cards[i]==cards[j] ){
                        //Exception
                        System.out.printf( "\n###\n###\n###\n### INTERNAL ERROR : testcase invalid %s %s\n###", cards[i], cards[j] );
                        for ( int k=0; k<14; k++ ){ System.out.printf ( "%s", cards[k] ); }
                        System.out.printf ( "\n###\n\n" );
                    }//if
                }//for
            }//for
            
            
            this.communityCards  = new Card[5];
            this.playerHoleCards = new Card[][]{ new Card[2], new Card[2], new Card[2], new Card[2], new Card[2] };
            
            System.arraycopy( cards,  0,    this.playerHoleCards[0], 0,    2 );
            System.arraycopy( cards,  2,    this.playerHoleCards[1], 0,    2 ); 
            System.arraycopy( cards,  4,    this.playerHoleCards[2], 0,    2 ); 
            System.arraycopy( cards,  6,    this.playerHoleCards[3], 0,    2 ); 
            System.arraycopy( cards,  8,    this.playerHoleCards[4], 0,    2 );
            System.arraycopy( cards, 10,    this.communityCards,     0,    5 );
            
        }else{
            //Exception
            System.out.printf( "\n###\n###\n###\n### INTERNAL ERROR : testcase invalid %d\n###\n\n", cards.length );
        }//if
    }//Test
    
    
    
    public Card[] getPlayerHoleCards( int playerNo ){ return playerHoleCards[playerNo]; }
    public Card[] getCommunityCards(){  return communityCards; }
    
}//Test
