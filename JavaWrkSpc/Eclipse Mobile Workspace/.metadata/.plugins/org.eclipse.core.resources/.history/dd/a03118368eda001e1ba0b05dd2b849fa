package aufgabenzettel4_A9.test;

public class ResultOfGame {
    
    private static final int   NUM_OF_PLAYERS = 5;
    private static final int[] magic = { 1, 2, 3, 5, 7, 11 };
    
    private ResultOfPlayer[] rop;
    private long             wert;
    
    
    
    public ResultOfGame( ResultOfPlayer[] rop ){
        int i, j, maxIndx;
        ResultOfPlayer max;
        ResultOfPlayer tmp;
        
        
        //init
        this.rop = new ResultOfPlayer[ NUM_OF_PLAYERS ];
        for ( i=0; i<NUM_OF_PLAYERS; ){
            this.rop[i] = new ResultOfPlayer( rop[i].position, rop[i].handRank, rop[i].card  );
            this.rop[i].playerNo = ++i;
        }//for
        
        
        //order players
        for ( i=NUM_OF_PLAYERS-1; i>0; i-- ){
            //init
            max = this.rop[i];
            maxIndx = i;
            //look for max
            for ( j=i-1; j>=0; j-- ){
                if ( max.position < this.rop[j].position ){
                    max = this.rop[j];
                    maxIndx = j;
                }//if
            }//for
            //position max
            if ( maxIndx != i ){
                tmp               = this.rop[i];
                this.rop[i]       = max;
                this.rop[maxIndx] = tmp;
            }//if
        }//for
        
        
        // compute wert
        this.wert = 0;
        j = 1;
        long help = magic[ this.rop[0].playerNo ] * tenE(j);
        for ( i=1; i<NUM_OF_PLAYERS; i++ ){
            j++;
            if ( this.rop[i].position == this.rop[i-1].position ){
                help *= magic[ this.rop[i].playerNo ];
            }else{
                this.wert += help;
                help = magic[ this.rop[i].playerNo ] * tenE(j);
            }//if
        }//for
        this.wert += help;
        
    }//ResultOfGame
    
    
    
    private long tenE( int e ){
        switch ( e ){ // 111122223334455 
            case 1 : return 100000000000L;  // +4
            case 2 : return     10000000L;  // +3
            case 3 : return        10000L;  // +2
            case 4 : return          100L;  // +2
            case 5 : return            1L;  //  0
            default: return           -1L;
        }//switch
    }//tenE
    
    
    
    long getWert(){ return this.wert; }
    
    
    
    public void printROG(){
        int i;
        
        System.out.printf( "---------------\n" );
        System.out.printf( "[%d", this.rop[0].playerNo );
        for ( i=1; i<NUM_OF_PLAYERS; i++ ){
            if ( rop[i-1].position == rop[i].position ){
                System.out.printf( "=%d", this.rop[i].playerNo);
            }else{
                System.out.printf( "] [%d", this.rop[i].playerNo );
            }//if
        }//for
        System.out.printf( "]\n" );
        
        for ( i=0; i<NUM_OF_PLAYERS; i++ ){
            System.out.printf( "player#%d plays:  ",  rop[i].playerNo );
            switch ( rop[i].handRank ){
                case STRAIGHT_FLUSH: System.out.printf( "[%s>%s>%s>%s>%s]",  rop[i].card[0], rop[i].card[1], rop[i].card[2], rop[i].card[3], rop[i].card[4] ); break;
                case QUADS:          System.out.printf( "[%s-%s-%s-%s|%s]",  rop[i].card[0], rop[i].card[1], rop[i].card[2], rop[i].card[3], rop[i].card[4] ); break;
                case FULL_HOUSE:     System.out.printf( "[%s-%s-%s|%s-%s]",  rop[i].card[0], rop[i].card[1], rop[i].card[2], rop[i].card[3], rop[i].card[4] ); break;
                case FLUSH:          System.out.printf( "[%s~%s~%s~%s~%s]",  rop[i].card[0], rop[i].card[1], rop[i].card[2], rop[i].card[3], rop[i].card[4] ); break;
                case STRAIGHT:       System.out.printf( "[%s,%s,%s,%s,%s]",  rop[i].card[0], rop[i].card[1], rop[i].card[2], rop[i].card[3], rop[i].card[4] ); break;
                case TRIPS:          System.out.printf( "[%s-%s-%s|%s|%s]",  rop[i].card[0], rop[i].card[1], rop[i].card[2], rop[i].card[3], rop[i].card[4] ); break;
                case TWO_PAIR:       System.out.printf( "[%s-%s|%s-%s|%s]",  rop[i].card[0], rop[i].card[1], rop[i].card[2], rop[i].card[3], rop[i].card[4] ); break;
                case ONE_PAIR:       System.out.printf( "[%s-%s|%s|%s|%s]",  rop[i].card[0], rop[i].card[1], rop[i].card[2], rop[i].card[3], rop[i].card[4] ); break;
                case HIGH_CARD:      System.out.printf( "[%s|%s|%s|%s|%s]",  rop[i].card[0], rop[i].card[1], rop[i].card[2], rop[i].card[3], rop[i].card[4] ); break;
            }//switch
            System.out.printf( "  %s\n",  rop[i].handRank );
        }//for
        
    }//printROG

}//ResultOfGa