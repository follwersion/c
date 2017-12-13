package aufgabenzettel4_A9;


import aufgabenzettel4_A9.test.*;
import static aufgabenzettel4_A9.test.HandRanking.*;
import cards.*;
import static cards.Card.Constant.*;


public class TestFrame {
    
    public static final String TCVERSION = "Version WS08/09 1.2";
    private static TestCase[] test;
    
    public static void main( String arg[] ){
        
        ResultOfGame rog;
        int          testNo;
        
        // init
        final int nort  =  13;              // Number Of Random based Tests
        TestCase[] tmp  =  {                // special self constructed testcases
            //                                  ___1___    ___2___    ___3___    ___4___    ___5___     ________CC________
            new TestCase( new Test( new Card[]{ DJ, HJ,    SA, DA,    DT, HQ,    S7, D8,    C9, C8,     CJ, CT, CK, CA, CQ } ) ),
            new TestCase( new Test( new Card[]{ CA, C2,    DQ, SQ,    DJ, CJ,    ST, HT,    C4, CK,     C5, S5, CQ, D5, H5 } ) ),
            new TestCase( new Test( new Card[]{ DQ, CJ,    ST, CQ,    CT, HJ,    S8, HA,    D9, S9,     DT, H9, DJ, HT, SQ } ) ),
            new TestCase( new Test( new Card[]{ D5, H7,    C7, S5,    D2, H6,    C3, S7,    D6, D3,     D7, SK, C9, D4, H9 } ) ),
            new TestCase( new Test( new Card[]{ C3, S7,    D2, H6,    D5, H7,    C7, S5,    S4, CT,     D7, C2, C9, D4, H9 } ) ),
            new TestCase( new Test( new Card[]{ CA, HA,    S2, S5,    DA, D5,    DJ, CJ,    C6, H5,     S9, S4, SA, S7, S3 } ) ),
            new TestCase( new Test( new Card[]{ H4, C7,    SK, S7,    C6, HK,    H7, CK,    CT, S8,     DJ, C5, S3, HA, CQ } ) ),
            new TestCase( new Test( new Card[]{ HA, HQ,    S4, SQ,    C5, DQ,    CT, CA,    H4, SK,     D3, C4, S3, D5, CQ } ) ),
            new TestCase( new Test( new Card[]{ SK, SA,    S8, S7,    C2, S6,    SQ, ST,    HA, DA,     S2, S4, CA, S3, S5 } ) ),
            new TestCase( new Test( new Card[]{ HK, HA,    SA, SQ,    CA, CK,    DA, D2,    S2, CQ,     C2, S4, D8, H3, C5 } ) ),
            new TestCase( new Test( new Card[]{ H7, H6,    C6, S7,    S5, C8,    DA, D2,    S9, D7,     C2, D4, D8, D3, D5 } ) ),
            new TestCase( new Test( new Card[]{ H2, H6,    S5, D5,    D4, C4,    S6, C3,    C9, DJ,     C8, C7, H8, C6, H7 } ) ),
            new TestCase( new Test( new Card[]{ D2, S5,    D5, H2,    C6, H6,    C2, S4,    H3, H5,     C8, C7, H8, C5, H7 } ) ),
            new TestCase( new Test( new Card[]{ H2, H6,    DJ, CJ,    D5, D2,    D6, S3,    S6, SJ,     C8, C7, H8, C6, H7 } ) ),
            new TestCase( new Test( new Card[]{ C2, C9,    C8, D8,    D2, S2,    D5, S5,    H8, S8,     CQ, S9, DQ, D9, HQ } ) ),
            new TestCase( new Test( new Card[]{ S2, C9,    CJ, DJ,    H9, C2,    DT, ST,    SJ, HJ,     CQ, S9, DQ, D9, HQ } ) ),
            new TestCase( new Test( new Card[]{ H5, H4,    ST, HK,    CT, CQ,    H3, H2,    DQ, HJ,     SQ, HT, HA, DT, HQ } ) ),
            new TestCase( new Test( new Card[]{ HA, SA,    CJ, CK,    D8, S8,    C3, C6,    C2, CA,     CT, C4, CQ, C5, C7 } ) ),
            new TestCase( new Test( new Card[]{ H3, CT,    C8, D4,    ST, H8,    DQ, DJ,    D8, HJ,     H9, H6, H5, C7, HT } ) ),
            new TestCase( new Test( new Card[]{ SA, HA,    CQ, ST,    H2, H3,    DJ, CK,    D8, HJ,     HQ, HT, H9, DT, H4 } ) )
         /*,new TestCase( new Test( new Card[]{ D2, D2,    D2, D2,    D2, D2,    D2, D2,    D2, D2,     D2, D2, D2, D2, D2 } ) )*/
        };
        test = new TestCase[ tmp.length + nort ];
        
        
        
        // setup test cases
        System.arraycopy( tmp, 0,  test, 0,  tmp.length );
        for ( int i=tmp.length; i<tmp.length+nort; i++ ){
            Deck d      = new Deck();
            Card[] card = new Card[15];
            
            for ( int j=0; j<15; j++ ){ card[j] = d.deal(); }
            test[i] = new TestCase( new Test( card ) );
        }//for
        
        
        
        for ( testNo=0; testNo<test.length; testNo++ ){
            Test currentTest = test[testNo].getTest();                          // <<<===
            
            
            
            //##################################################################
            //
            // insert your code here
            // ...
            
            
            // example  how to access cards
            // using:
            //   currentTest.getPlayerHoleCards( playerNo )
            //   currentTest.getCommunityCards()
            //
            Card[][] playerCards = new Card[5][7];  // 5 players access 7 cards each
            Card[][] playerHands = new Card[5][5];  // 5 players play their hand of 5 cards each
            
            for ( int playerNo=0; playerNo<5; playerNo++ ){
                System.arraycopy( currentTest.getPlayerHoleCards(playerNo), 0,   playerCards[playerNo], 0,   2 );  // <<<===
                System.arraycopy( currentTest.getCommunityCards(),          0,   playerCards[playerNo], 2,   5 );  // <<<===
            }//for
            
            
            
            //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
            // do your computation
            // ...
            
            
            
            
            
            
            
            // the following is invalid(!!!) code - just an example how to access the result data structure
            
            ResultOfPlayer[] rop = new ResultOfPlayer[5];                       // <<<===
            
            
            
            // example for cards of palyer1
            int player1HandRank         = 1;                                    // player1 is winner - rank of poker hand played by player1
            HandRanking player1HandName = STRAIGHT_FLUSH;                       // name of hand      - just a hand
            Card[] player1Hand          = new Card[]{ CJ, CT, CK, CA, CQ };     // cards of player 1 - just some cards
            
            rop[0] = new ResultOfPlayer( player1HandRank, player1HandName, player1Hand );   // <<<=== Result Of Player - the "magic" method call
            
            
            
            // example for cards of player2
            int player2HandRank         = 5;                                    // rank of poker hand played by player2
            HandRanking player2HandName = HIGH_CARD;                            // name of hand      - just a hand
          //player2HandName             = HandRanking.valueOf( "HIGH_CARD" );   //   alternative #1
            String nameOfHand           = "High_Card";                          //   alternative #2a
            player2HandName = HandRanking.valueOf( nameOfHand.toUpperCase() );  //   alternative #2b
            Card[] player2Hand          = new Card[]{ D7, H5, S4, H4, C2 };     // cards of player 2 - just some cards
            
            rop[1] = new ResultOfPlayer( player2HandRank, player2HandName, player2Hand );   // <<<=== Result Of Player - the "magic" method call
            
            
            
            // example for cards other players resp. loop
            for ( int pNoIndx=2; pNoIndx<5; pNoIndx++ ){
                int playerHandRank         = 6-pNoIndx;                            // just a rank
                HandRanking playerHandName = QUADS;                                // just a hand
                Card[] playerHand          = new Card[5];                          // just
                System.arraycopy( playerCards[pNoIndx], 1,   playerHand, 0,   5 ); //   some cards
                
                rop[pNoIndx] = new ResultOfPlayer( playerHandRank, playerHandName, playerHand );   // <<<=== Result Of Player - the "magic" method call
            }//for
            
            
            
            
            
            // give reults of current test to Result-Of-Game data structure
            rog = new ResultOfGame( rop );                                      // <<<=== combining the results of each player to result of game
            test[testNo].setROG( rog );                                         // <<<=== Result Of Game - the "magic" method call
            
            
            // ...
            //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
            // end of "your" area - any further modifications forbidden
            //
            //##################################################################
             
        }//for
        
        
        
        
        // do NOT touch the following code
        //
        System.out.printf( "###############################################################################\n" );
        System.out.printf( "###############################################################################\n" );
        System.out.printf( "###\n" );
        System.out.printf( "### %s\n", TCVERSION );
        System.out.printf( "###\n" );
        System.out.printf( "###\n" );
        System.out.printf( "###\n" );
        System.out.printf( "### RESULTs\n" );
        System.out.printf( "### =======\n" );
        System.out.printf( "###\n\n\n" );        
        for ( testNo=0; testNo<test.length; testNo++ ){
            test[testNo].prettyPrint(testNo);
        }//for
        cmp();
        System.out.printf( "###\n" );
        System.out.printf( "###############################################################################\n" );
        System.out.printf( "###############################################################################\n" );
    }//main
    
    
    private static void cmp(){
        final long[] hlp = {
            231000000000000L,
               200111050000L,
               300050110702L,
              4200000005500L,
              3500000021103L,
               307700000000L,
              2100000051102L,
               500030021107L,
               500020070311L,
             21000000000011L,
               700110060005L,
              1102100000000L,
               504620000000L,
               300110700000L,
            231000000000000L,
              3300000071000L,
              5500000030207L,
               700110031000L,
              1100050020307L,
               300020110507L
        };
        long[] cmp = new long[test.length];
        System.arraycopy( hlp, 0,  cmp, 0,  hlp.length );
        for ( int i=hlp.length; i<cmp.length; i++ ) cmp[i] = -1;
        System.out.printf( "--->>> " );
        for ( int i=0; i<cmp.length; i++ )   if ( cmp[i] != test[i].getWert() )   System.out.printf( " %d", i );
        System.out.println();
    }//cmp

}//TestFrame
