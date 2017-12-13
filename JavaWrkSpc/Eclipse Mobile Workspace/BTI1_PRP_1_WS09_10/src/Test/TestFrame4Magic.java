package Test;

import Skript3.Magic;
import Skript5.String;

public class TestFrame4Magic {
    
    public static void main( String[] args ){
        
        System.out.printf( "Gib mir eine Zeile            : " );
        String s1 = Magic.nextLine();
        System.out.printf( "Es wurde folgendes eingegeben : %s\n", s1 );
        System.out.printf( "\n\n" );
        
        
        System.out.printf( "Gib mir eine Zahl             : " );
        int i1 = Magic.nextInt();
        System.out.printf( "Gib mir noch eine Zahl        : " );
        int i2 = Magic.nextInt();
        System.out.printf( "Die beiden Zahlen waren %d und %d.\n", i1, i2 );
        System.out.printf( "\n\n" );
        
        
        System.out.printf( "Nun mit Fenster.\n" );
        
        String s2 = Magic.getString( "Gib mir einen String :" );
        System.out.printf( "Es wurde folgendes eingegeben : %s\n", s2 );
        
        int i3 = Magic.getInt( "Gib mir eine Zahl :" );
        System.out.printf( "Es wurde die Zahl %d eingegeben.", i3 );
        
        System.out.printf( "\n\n" );
        
        
        
        System.out.printf( "Die aktuelle Zeit ist: %s\n", Magic.getTimeStampString() );
        System.out.printf( "THE END\n" );
        
    }//main

}//TestFrame4Magic
