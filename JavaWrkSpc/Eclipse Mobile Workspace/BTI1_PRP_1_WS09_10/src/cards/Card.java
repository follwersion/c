package cards;


// Karten
public class Card implements Comparable<Card> {
    
    //
    //
    // TYPEs--------------------------------------------------------------------
    
    // Farbwerte
    public enum Suit {
        
        CLUB,     // Kreuz
        DIAMOND,  // Karo
        HEART,    // Herz
        SPADES;   // Pik
       
        
        public String toString(){
            String resu;
            
            switch ( this ) {
                case CLUB    : resu = "C"; break;  // \u2663
                case DIAMOND : resu = "D"; break;  // \u2666
                case HEART   : resu = "H"; break;  // \u2665
                case SPADES  : resu = "S"; break;  // \u2660
                default      : resu = "?";
            }//switch
            
            return resu;
        }//toString

    }//enum Suit
    
    
    
    // Kartenwerte
    public enum Rank {
        
        TWO,    //  2
        THREE,  //  3
        FOUR,   //  4
        FIVE,   //  5
        SIX,    //  6
        SEVEN,  //  7
        EIGHT,  //  8
        NINE,   //  9
        TEN,    //  T bzw. 10
        JACK,   //  J bzw. Bube
        QUEEN,  //  Q bzw. Dame
        KING,   //  K bzw. König
        ACE;    //  A bzw. Ass
        
        
        public int value(){
           return this.ordinal() + 2;
        }//value
        
        
        public Rank incremented(){
            assert !this.equals( ACE ) : "ERROR: Ace is already highest value and can NOT be incremented!";
            return Rank.values()[ this.ordinal() +1 ];
        }//incremented
        
        public Rank decremented(){
            assert !this.equals( TWO ) : "ERROR: Two is already lowest value and can NOT be decremented!";
            return Rank.values()[ this.ordinal() -1 ];
        }//decremented
        
        
        public String toString(){
            String resu;
            
            switch ( this ) {
                case TEN   : resu = "T"; break;
                case JACK  : resu = "J"; break;
                case QUEEN : resu = "Q"; break;
                case KING  : resu = "K"; break;
                case ACE   : resu = "A"; break;
                default    : resu = "" + this.value();
            }//switch
            
            return resu;
        }//toString

    }//enum Rank

    

    //
    //
    // CONSTANTs----------------------------------------------------------------

    public static class Constant {
        
        public static final Card C2 = new Card (  Card.Suit.CLUB,    Card.Rank.TWO    );
        public static final Card C3 = new Card (  Card.Suit.CLUB,    Card.Rank.THREE  );
        public static final Card C4 = new Card (  Card.Suit.CLUB,    Card.Rank.FOUR   );
        public static final Card C5 = new Card (  Card.Suit.CLUB,    Card.Rank.FIVE   );
        public static final Card C6 = new Card (  Card.Suit.CLUB,    Card.Rank.SIX    );
        public static final Card C7 = new Card (  Card.Suit.CLUB,    Card.Rank.SEVEN  );
        public static final Card C8 = new Card (  Card.Suit.CLUB,    Card.Rank.EIGHT  );
        public static final Card C9 = new Card (  Card.Suit.CLUB,    Card.Rank.NINE   );
        public static final Card CT = new Card (  Card.Suit.CLUB,    Card.Rank.TEN    );
        public static final Card CJ = new Card (  Card.Suit.CLUB,    Card.Rank.JACK   );
        public static final Card CQ = new Card (  Card.Suit.CLUB,    Card.Rank.QUEEN  );
        public static final Card CK = new Card (  Card.Suit.CLUB,    Card.Rank.KING   );
        public static final Card CA = new Card (  Card.Suit.CLUB,    Card.Rank.ACE    );

        public static final Card D2 = new Card (  Card.Suit.DIAMOND, Card.Rank.TWO    );
        public static final Card D3 = new Card (  Card.Suit.DIAMOND, Card.Rank.THREE  );
        public static final Card D4 = new Card (  Card.Suit.DIAMOND, Card.Rank.FOUR   );
        public static final Card D5 = new Card (  Card.Suit.DIAMOND, Card.Rank.FIVE   );
        public static final Card D6 = new Card (  Card.Suit.DIAMOND, Card.Rank.SIX    );
        public static final Card D7 = new Card (  Card.Suit.DIAMOND, Card.Rank.SEVEN  );
        public static final Card D8 = new Card (  Card.Suit.DIAMOND, Card.Rank.EIGHT  );
        public static final Card D9 = new Card (  Card.Suit.DIAMOND, Card.Rank.NINE   );
        public static final Card DT = new Card (  Card.Suit.DIAMOND, Card.Rank.TEN    );
        public static final Card DJ = new Card (  Card.Suit.DIAMOND, Card.Rank.JACK   );
        public static final Card DQ = new Card (  Card.Suit.DIAMOND, Card.Rank.QUEEN  );
        public static final Card DK = new Card (  Card.Suit.DIAMOND, Card.Rank.KING   );
        public static final Card DA = new Card (  Card.Suit.DIAMOND, Card.Rank.ACE    );
        
        public static final Card H2 = new Card (  Card.Suit.HEART,   Card.Rank.TWO    );
        public static final Card H3 = new Card (  Card.Suit.HEART,   Card.Rank.THREE  );
        public static final Card H4 = new Card (  Card.Suit.HEART,   Card.Rank.FOUR   );
        public static final Card H5 = new Card (  Card.Suit.HEART,   Card.Rank.FIVE   );
        public static final Card H6 = new Card (  Card.Suit.HEART,   Card.Rank.SIX    );
        public static final Card H7 = new Card (  Card.Suit.HEART,   Card.Rank.SEVEN  );
        public static final Card H8 = new Card (  Card.Suit.HEART,   Card.Rank.EIGHT  );
        public static final Card H9 = new Card (  Card.Suit.HEART,   Card.Rank.NINE   );
        public static final Card HT = new Card (  Card.Suit.HEART,   Card.Rank.TEN    );
        public static final Card HJ = new Card (  Card.Suit.HEART,   Card.Rank.JACK   );
        public static final Card HQ = new Card (  Card.Suit.HEART,   Card.Rank.QUEEN  );
        public static final Card HK = new Card (  Card.Suit.HEART,   Card.Rank.KING   );
        public static final Card HA = new Card (  Card.Suit.HEART,   Card.Rank.ACE    );
        
        public static final Card S2 = new Card (  Card.Suit.SPADES,  Card.Rank.TWO    );
        public static final Card S3 = new Card (  Card.Suit.SPADES,  Card.Rank.THREE  );
        public static final Card S4 = new Card (  Card.Suit.SPADES,  Card.Rank.FOUR   );
        public static final Card S5 = new Card (  Card.Suit.SPADES,  Card.Rank.FIVE   );
        public static final Card S6 = new Card (  Card.Suit.SPADES,  Card.Rank.SIX    );
        public static final Card S7 = new Card (  Card.Suit.SPADES,  Card.Rank.SEVEN  );
        public static final Card S8 = new Card (  Card.Suit.SPADES,  Card.Rank.EIGHT  );
        public static final Card S9 = new Card (  Card.Suit.SPADES,  Card.Rank.NINE   );
        public static final Card ST = new Card (  Card.Suit.SPADES,  Card.Rank.TEN    );
        public static final Card SJ = new Card (  Card.Suit.SPADES,  Card.Rank.JACK   );
        public static final Card SQ = new Card (  Card.Suit.SPADES,  Card.Rank.QUEEN  );
        public static final Card SK = new Card (  Card.Suit.SPADES,  Card.Rank.KING   );
        public static final Card SA = new Card (  Card.Suit.SPADES,  Card.Rank.ACE    );
        
        
        
        public static final Suit CLUB    = Suit.CLUB;
        public static final Suit DIAMOND = Suit.DIAMOND;
        public static final Suit HEART   = Suit.HEART;
        public static final Suit SPADES  = Suit.SPADES;
        
        public static final Rank TWO     = Rank.TWO;
        public static final Rank THREE   = Rank.THREE;
        public static final Rank FOUR    = Rank.FOUR;
        public static final Rank FIVE    = Rank.FIVE;
        public static final Rank SIX     = Rank.SIX;
        public static final Rank SEVEN   = Rank.SEVEN;
        public static final Rank EIGHT   = Rank.EIGHT;
        public static final Rank NINE    = Rank.NINE;
        public static final Rank TEN     = Rank.TEN;
        public static final Rank JACK    = Rank.JACK;
        public static final Rank QUEEN   = Rank.QUEEN;
        public static final Rank KING    = Rank.KING;
        public static final Rank ACE     = Rank.ACE;
        
    }//class Constant
    
    
    
    //
    //
    // ATTRIBUTE DATA-----------------------------------------------------------

    private final Suit suit;
    private final Rank rank;

    
    
    //
    //
    // CONSTRUCTORs-------------------------------------------------------------

    public Card( Suit s, Rank r ) {
        this.suit = s;
        this.rank = r;
    }//Card

    
    
    //
    //
    // METHODs------------------------------------------------------------------
    
    // the code of the printCardArray method was designed by Mark-André Kloesters in 2009
    // only negligible modifications were done afterwards
    public static void printCardArray( Card[] c ){
        
        for( int i=0;  i < c.length;  i++ ){
            if( c[i] != null ){
                System.out.printf( "%15s", " ________ " );
            }else{
                System.out.printf( "%15s", " ..NULL.. " );
            }//if
        }//for
        System.out.println();
        
        for( int i=0;  i < c.length;  i++ ){
            if( c[i] != null ){
                switch(c[i].getSuit()){
                    case HEART   : System.out.printf( "%15s", String.format( "|%s _  _  |", c[i].getRank())); break;
                    case DIAMOND : System.out.printf( "%15s", String.format( "|%s       |", c[i].getRank())); break;
                    case CLUB    : System.out.printf( "%15s", String.format( "|%s  __   |", c[i].getRank())); break;
                    case SPADES  : System.out.printf( "%15s", String.format( "|%s  __   |", c[i].getRank())); break;
                }//switch
            }else{
                System.out.printf( "%15s", String.format( "00      00" ));
            }//if
        }//for
        System.out.println();
        
        for( int i=0;  i < c.length;  i++ ){
            if( c[i] != null ){
                switch(c[i].getSuit()){
                    case HEART   : System.out.printf( "%15s", String.format( "| / \\/ \\ |" )); break;
                    case DIAMOND : System.out.printf( "%15s", String.format( "|   /\\   |"  )); break;
                    case CLUB    : System.out.printf( "%15s", String.format( "| _|  |_ |"   )); break;
                    case SPADES  : System.out.printf( "%15s", String.format( "|  /  \\  |"  )); break;
                }//switch
            }else{
                System.out.printf( "%15s", String.format( ". 00  00 ." ));
            }//if
        }//for
        System.out.println();
        
        for( int i=0;  i < c.length;  i++ ){
            if( c[i] != null ){
                switch(c[i].getSuit()){
                case HEART   : System.out.printf( "%15s", String.format( "| \\    / |" )); break;
                case DIAMOND : System.out.printf( "%15s", String.format( "|  /  \\  |" )); break;
                case CLUB    : System.out.printf( "%15s", String.format( "||      ||"  )); break;
                case SPADES  : System.out.printf( "%15s", String.format( "| /    \\ |" )); break;
                }//switch
            }else{
                System.out.printf( "%15s", String.format( ".   00   ." ));
            }//if
        }//for
        System.out.println();
        
        for( int i=0;  i < c.length;  i++ ){
            if( c[i] != null ){
                switch(c[i].getSuit()){
                case HEART   : System.out.printf( "%15s", String.format( "|  \\  /  |" )); break;
                case DIAMOND : System.out.printf( "%15s", String.format( "|  \\  /  |" )); break;
                case CLUB    : System.out.printf( "%15s", String.format( "||__  __||"  )); break;
                case SPADES  : System.out.printf( "%15s", String.format( "|/      \\|" )); break;
                }//switch
            }else{
                System.out.printf( "%15s", String.format( ". 00  00 ." ));
            }//if
        }//for
        System.out.println();
        
        for( int i=0;  i < c.length;  i++ ){
            if( c[i] != null ){
                switch( c[i].getSuit() ){
                    case HEART   : System.out.printf( "%15s", String.format( "|   \\/   |"  )); break;
                    case DIAMOND : System.out.printf( "%15s", String.format( "|   \\/   |"  )); break;
                    case CLUB    : System.out.printf( "%15s", String.format( "|  /__\\  |"  )); break;
                    case SPADES  : System.out.printf( "%15s", String.format( "|\\_/||\\_/|" )); break;
                }//switch
            }else{
                System.out.printf( "%15s", String.format( "00      00" ));
            }//if
        }//for
        System.out.println();
        
        for( int i=0;  i < c.length;  i++ ){
            if( c[i] != null ){
                System.out.printf( "%15s", "|________|" );
            }else{
                System.out.printf( "%15s", String.format( "'''NULL'''" ));
            }//if
        }//for
        System.out.println();
        
    }//printCardArray
    
    
    
    public Rank getRank() {
        return rank;     
    }//getRank
    
    
    public Suit getSuit() {
        return suit;
    }//getSuit
    
    
    public boolean equals( Card oc ){
        return (( this.suit == oc.getSuit() ) && ( this.rank == oc.getRank() ));    
    }//equals
    
    
    public int compareTo( Card oc ){
        return this.rank.compareTo( oc.rank );
    }//compareTo
    
    
    public String toString(){
        return " [" + this.suit + this.rank + "] ";
    }//toString
    
}//class Card
