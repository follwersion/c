package inDerVorlesung.day091016;

public class Test091016a {

    public static void main( String[] args ) {
        
        byte start;   // START-wert
        byte stopp;   // STOPP-wert
        byte sw;      // SchrittWeite
        byte i;       // laufIndex f�r die schleifen
        
        
        start =  1;   // irgendein willk�rlich gew�hlter STARTwert
        stopp = 37;   // irgendein willk�rlich gew�hlter STOPPwert
        sw    =  3;   // irgendeine willk�rlich gew�hlte SchrittWeite
        
        
        
        
        System.out.printf( "%9s : ", "for" );
        for ( i = start; i <= stopp; i+=sw ){
            System.out.printf( "%4d", i );
        }//for
        System.out.printf( "\n" );
        
        
        System.out.printf( "%9s : ", "while" );
        i = start;
        while ( i <= stopp ){
            System.out.printf( "%4d", i );
            i+=sw;
        }//while
        System.out.printf( "\n" );
        
        
        System.out.printf( "%9s : ", "do..while" );
        i = start;
        if (i <= stopp) {
            do {
                System.out.printf("%4d", i);
                i += sw;
            } while (i <= stopp);
        }//if
        System.out.printf( "\n" );
        
    }// main

}// Test091016a
