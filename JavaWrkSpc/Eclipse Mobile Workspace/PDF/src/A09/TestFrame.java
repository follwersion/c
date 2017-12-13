package a09;


import test.*;
import static test.HandRanking.*;
import cards.*;
import cards.Card.*;
import static cards.Card.Constant.*;
import a06_for_a09.*;
//>>>
import java.util.*;
//>>>

public class TestFrame {
    
    public static final String TCVERSION = "Version: 2.6  ( WS09/10 )";
    private static TestCase[] test;
    
    
    public static void main( String arg[] ){
        
        ResultOfGame rog;
        int          testNo;
        
        // init
        final int NORT  =  13;              // Number Of Random based Tests
        TestCase[] tmp  =  {                // special self constructed testcases
            //                                  ___1___    ___2___    ___3___    ___4___    ___5___     ________CC________
            new TestCase( new Test( new Card[]{ HT, ST,    DJ, CJ,    H3, S2,    S3, D2,    D3, H2,     CT, C9, C8, C7, D5 } ) ),
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
            new TestCase( new Test( new Card[]{ SA, HA,    CQ, ST,    H2, H3,    DJ, CK,    D8, HJ,     HQ, HT, H9, DT, H4 } ) ),
            new TestCase( new Test( new Card[]{ C9, D2,    H5, H6,    C7, H8,    S7, C3,    C4, S9,     CQ, HK, DJ, S6, HA } ) ),
            new TestCase( new Test( new Card[]{ DJ, DT,    C3, HT,    C7, S5,    D2, D3,    S3, DA,     D9, H2, C9, S6, H9 } ) ),
            new TestCase( new Test( new Card[]{ ST, S2,    HK, HT,    CK, S4,    C5, D9,    CA, CT,     DJ, S5, HQ, DT, D2 } ) ),
            new TestCase( new Test( new Card[]{ CT, CJ,    C7, C9,    HT, ST,    DJ, HJ,    SJ, SQ,     D7, D6, DT, D8, D9 } ) ),
            new TestCase( new Test( new Card[]{ D5, SK,    D6, H6,    HT, ST,    C6, C5,    CA, SQ,     S3, H5, S2, S4, S5 } ) ),
            new TestCase( new Test( new Card[]{ D7, S8,    C5, D5,    D2, SA,    HA, S2,    CA, SQ,     S3, H5, S6, S4, S5 } ) ),
            new TestCase( new Test( new Card[]{ D7, S7,    C7, C5,    C6, CT,    S9, H3,    H9, D6,     H6, S6, D9, C9, DT } ) ),
            new TestCase( new Test( new Card[]{ H6, D6,    SJ, S7,    HT, CT,    H9, C9,    CA, SA,     C6, S9, ST, D9, S6 } ) ),
            new TestCase( new Test( new Card[]{ CQ, D6,    D5, H3,    CA, SA,    D4, S4,    DA, HA,     C3, H4, C5, C2, C4 } ) ),
            new TestCase( new Test( new Card[]{ DQ, C6,    C5, S5,    CA, SA,    H5, C4,    DA, HA,     D3, S4, D5, D2, D4 } ) ),
            new TestCase( new Test( new Card[]{ S5, CA,    HA, H5,    HQ, HK,    S3, C3,    S2, C2,     H3, H4, D3, H2, S4 } ) ),
            new TestCase( new Test( new Card[]{ HQ, HA,    DJ, DQ,    CT, SA,    CA, C3,    DA, C2,     CK, SJ, CJ, CQ, HJ } ) ),
            new TestCase( new Test( new Card[]{ D4, S3,    S6, S4,    C6, DJ,    H7, D7,    H4, S8,     CT, S9, C8, H6, D5 } ) ),
            new TestCase( new Test( new Card[]{ S9, C5,    S4, H9,    CT, C9,    H8, S8,    S6, H6,     D6, D8, D9, C6, D5 } ) ),
            new TestCase( new Test( new Card[]{ H6, D6,    S7, C5,    D7, S6,    H7, HT,    S5, H5,     C9, H9, D8, S8, C7 } ) ),
            new TestCase( new Test( new Card[]{ CQ, DQ,    SA, C5,    DA, S6,    HA, SQ,    S5, CA,     ST, HQ, DT, HT, CT } ) ),
            new TestCase( new Test( new Card[]{ S8, D8,    CT, DT,    HQ, SQ,    D9, S9,    CJ, HJ,     C8, H9, ST, DJ, CQ } ) ),
            new TestCase( new Test( new Card[]{ HK, CK,    H8, HT,    HQ, C8,    D9, S9,    CJ, HJ,     H9, ST, S8, DJ, CQ } ) ),
            new TestCase( new Test( new Card[]{ HK, CK,    SA, C2,    CA, C8,    C6, C5,    DK, C4,     C9, CT, CJ, S8, CQ } ) )
        };
        test = new TestCase[ tmp.length + NORT ];
        
        
        
        // setup test cases
        System.arraycopy( tmp, 0,  test, 0,  tmp.length );
        for ( int i=tmp.length;  i<tmp.length+NORT;  i++ ){
            Deck d      = new Deck();
            Card[] card = new Card[15];
            
            for ( int j=0;  j<15;  j++ ){ card[j] = d.deal(); }
            test[i] = new TestCase( new Test( card ) );
        }//for
        
        
        
        // examine the test cases
        for ( testNo=0;  testNo<test.length;  testNo++ ){
            Test currentTest = test[testNo].getTest();                          // <<<===
            
            
            
            //##################################################################
            //###
            //### insert your code here
            //### ...
            
            Card[][] playerCards = new Card[5][7];  // 5 players access 7 cards each ( 2 private and 5 common cards )
            Card[][] playerHands = new Card[5][5];  // 5 players play their hand of 5 cards each
            
            for ( int playerNo=0;  playerNo<5;  playerNo++ ){
                System.arraycopy( currentTest.getPlayerHoleCards(playerNo), 0,   playerCards[playerNo], 0,   2 );  // <<<===
                System.arraycopy( currentTest.getCommunityCards(),          0,   playerCards[playerNo], 2,   5 );  // <<<===
            }//for
            
            
            
            //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
            //
            // do your computation here
            // ...
            
            
            //2d Array mit den Spielkarten aller Spieler 
            Card[][] temp = new Card[5][7];
            for (int playerNo = 0; playerNo < 5; playerNo++) {
                for (int cardNo = 0; cardNo < 7; cardNo++) {
                    temp[playerNo][cardNo] = playerCards[playerNo][cardNo];
                }// for
            }

            long[] l = new long[5];
            String gespielteHand;            
            ControlPoker check1 = new ControlPoker();
            ArrayList<Card> sorted = new ArrayList<Card>();
            HandRanking[] playerHandName = new HandRanking[5];
            for (int i = 0; i < 5; i++) {
                //Sortiert die Karten schreib sie in die ArrayList
                sorted = check1.sortArray(temp[i]);
                //Übergibt die ArrayList an den Konstruktor aus Aufgabe 6
                ControlPoker check2 = new ControlPoker(sorted);
                //Schreib die Karten der ErgebnissHand in die ArrayLIst
                sorted = check2.resuHand(sorted);
                //Speichert ArrayList in das temp. ErgebnissArray
                Card[] resuArray = new Card[5];
                resuArray = sorted.toArray(resuArray);
                //ErgebnissKarten aller in playerHands
                playerHands[i] = resuArray; // array 1
                gespielteHand = check2.bestHand();
                //Bilden der eindeutigen Longs für die gespielten Karten 
                int counter = 2;
                playerHandName[i] = HandRanking.valueOf(gespielteHand); // array 2
                for (int j = 4; j >= 0; j--) {
                    l[i] += sorted.get(j).getRank().value() * (long) Math.pow(10, counter);
                    counter += 2;
                }
                l[i] += HandRanking.valueOf(gespielteHand).ordinal() * (long) Math.pow(10, 12);
            }
            
            //bilden eines arrays zur speicherung der Positionen
            long temp2;
            int playerSpeicher[] = { 0, 1, 2, 3, 4 };
            int temp1;

            //sortieren der Longs nach größe
            for (int i = 0; i < l.length; i++) {
                for (int j = 0; j < l.length; j++) {
                    if (l[i] < l[j]) {
                        temp1 = playerSpeicher[j];
                        temp2 = l[j];
                        playerSpeicher[j] = playerSpeicher[i];
                        l[j] = l[i];
                        playerSpeicher[i] = temp1;
                        l[i] = temp2;
                    }
                }
            }
           
            //Zuweisung der Plätze
            int counter = 1;
            int platz[] = new int[5];           
            for (int i = l.length - 1; i >= 0; i--) {
                platz[i] = counter;              
                if (i >= 1 && l[i] == l[i - 1]) {
                } else {
                    counter++;
                }
            }
            
            // data structure for results of the players
            
            ResultOfPlayer[] rop = new ResultOfPlayer[5];//5 players are playing                                                          
            
            for (int i = 0; i < playerSpeicher.length; i++) {
                rop[playerSpeicher[i]] = new ResultOfPlayer(platz[i], playerHandName[playerSpeicher[i]], playerHands[playerSpeicher[i]]);
            }           
            
            // give results of current test to Result-Of-Game data structure
            rog = new ResultOfGame( rop );                                      // <<<=== combining the results of each player to result of game
            test[testNo].setROG( rog );                                         // <<<=== Result Of Game - the "magic" method call
            //### ...
            //###^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
            //### end of "your" area - any further modifications are forbidden !
            //###
            //##################################################################
             
        }//for
        
        
        
        
        // do NOT touch the following code
        //
        System.out.printf( "\n\n\n" );
        System.out.printf( "###############################################################################\n" );
        System.out.printf( "###############################################################################\n" );
        System.out.printf( "###############################################################################\n" );
        System.out.printf( "###\n" );
        System.out.printf( "###\n" );
        System.out.printf( "### %s\n", TCVERSION );
        System.out.printf( "###\n" );
        System.out.printf( "###\n" );
        System.out.printf( "###\n" );
        System.out.printf( "### RESULTs\n" );
        System.out.printf( "### =======\n" );
        System.out.printf( "###\n\n\n" );        
        for ( testNo=0;  testNo<test.length-NORT;  testNo++ ){ test[testNo].prettyPrint(testNo); }
        System.out.printf( "\n\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n\n\n" );
        for ( testNo=test.length-NORT;  testNo<test.length;  testNo++ ){ test[testNo].prettyPrint(testNo); }
        System.out.printf( "\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n\n" );
        System.out.printf( "%d tests done   ( #%d, .., #%d )\n",  test.length, 0, test.length-1 );
        cmp();
        System.out.printf( "###\n" );
        System.out.printf( "###############################################################################\n" );
        System.out.printf( "###############################################################################\n" );
    }//main
    
    
    
    // just some cryptic magic - you are NOT required to understand this
    private static void cmp(){
        final long[] hlp = {
               300023850000L,  231000000000000L,     200111050000L,     300050110702L,
              4200000005500L,    3500000021103L,     307700000000L,    2100000051102L,
               500030021107L,     500020070311L,   21000000000011L,     700110060005L,
              1102100000000L,     504620000000L,     300110700000L,  231000000000000L,
              3300000071000L,    5500000030207L,     700110031000L,    1100050020307L,
               300020110507L,     300220000507L,     700110020305L,     200110030705L,
               703300000000L,     200110052100L,     700030051102L,    7700000050203L,
               700020050311L,     500070021103L,    1100030070205L,     300070110502L,
               300020070511L,     700110050302L,    1100070050600L,     703300000000L,
            115500000000002L,  231000000000000L,     211550000000L,     200050071103L
        };
        long[] cmp = new long[test.length];
        System.arraycopy( hlp, 0,  cmp, 0,  hlp.length );
        for ( int i=hlp.length;  i<cmp.length;  i++ ) cmp[i] = -1;
        System.out.print( "--->>> " );
        boolean maybeOk = true;
        for ( int i=0; i<hlp.length; i++ ){ if ( cmp[i]!=test[i].getWert() ){ System.out.printf( " %d", i ); maybeOk = false; } }
        if ( maybeOk ) System.out.print( " maybe OK" );
        System.out.print( "  <-]|[-> " );
        for ( int i=hlp.length;  i<cmp.length;  i++ ) if ( cmp[i]!=test[i].getWert() ) System.out.printf( " %d", i ); else System.out.print( " ." );
        System.out.println();
    }//cmp
    
}//TestFrame