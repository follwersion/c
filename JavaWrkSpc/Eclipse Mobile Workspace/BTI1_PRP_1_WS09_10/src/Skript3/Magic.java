package Skript3;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Magic {
    
    public static String nextLine(){
        Scanner in = new Scanner( System.in );
        return in.nextLine();
    }//nextLine
    
    public static int nextInt(){
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }//nextLine
    
    
    public static String getString( String inputDialog ){
        return JOptionPane.showInputDialog( inputDialog );
    }//nextLine

    public static int getInt( String inputDialog ){
        Scanner in = new Scanner( JOptionPane.showInputDialog( inputDialog ) );
        return in.nextInt();
    }//nextLine
    
    
    public static String getTimeStampString(){
        return new SimpleDateFormat( "yyyy/MM/dd HH:mm:ss.SSS", new Locale("de","DE") ).format( new Date().getTime() );
    }//requestTimeString 
    
    public static long getTimeStamp(){
        return new Date().getTime();
    }//getTimeTicks
    
}//Magic
