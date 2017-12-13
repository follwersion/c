package inDerVorlesung.day091023;

public class Test091023b {
    
    public static void printArray( char c, int[] array ){
        System.out.printf( "%c -> ", c );
        for ( int i=0; i<array.length; i++ ) System.out.printf( "%3d",  array[i] );
        System.out.println();
    }//printArray
    
    
    public static void swapNotArray( int[] x, int[] y ){
        int[] tmp;
        tmp = x;
        x = y;
        y = tmp;
    }//swapNotArray
    
    
    public static void swapArray ( int[] x, int[] y ){
        assert x.length == y.length : "manual lesen";
        for ( int i=0; i<x.length; i++ ){
            int tmp;
            tmp = x[i];
            x[i] = y[i];
            y[i] = tmp;
        }//for
    }//swapArray
    
    
    public static void main( String[] args ){
        
        int[] a = new int[]{ 11, 12, 13 };
        int[] b = { 14, 15, 16 };
        
        
        //1.Versuch
        
        printArray( 'a', a );
        printArray( 'b', b );
        
        int[] tmp;
        tmp = a;
        a = b;
        b = tmp;

        printArray( 'a', a );
        printArray( 'b', b );
        // es wurden die Arrays selbst getrauscht und NICHT(!) deren Inhalte
        System.out.printf( "###################\n" );
        
        
        
        //2.Versuch
        a = new int[]{ 21, 22, 23 };
        b = new int[]{ 24, 25, 26 };
        printArray( 'a', a );
        printArray( 'b', b );
        
        swapNotArray( a, b );
        printArray( 'a', a );
        printArray( 'b', b );
        // es wurde nichts getauscht
        System.out.printf( "###################\n" );
        
        
        
        //3.Versuch
        a = new int[]{ 31, 32, 33 };
        b = new int[]{ 34, 35, 36 };
        printArray( 'a', a );
        printArray( 'b', b );
        
        swapArray( a, b );
        printArray( 'a', a );
        printArray( 'b', b );
        // es wurden die Inhalte der Arrays getauscht

    }//main

}//Test091023b
