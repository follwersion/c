package inDerVorlesung.day091022;

public class Test091022a {
    
    public static void main( String[] args ){
        
        int[] a,b;
        
        a= new int[10];
        for ( int i=a.length-1; i>=0; i-- ){
            a[i] =  a.length-i;
        }//for
        
        for (int i=0; i<a.length; i++ ){
            System.out.printf( " a[%d] = %d\n",  i, a[i] );
        }//for
        System.out.printf( "###############################################################################\n" );
        
        
        
        a= new int[10];
        for ( int i=0, j=a.length;  i<a.length;  i++,j-- ){
            a[i] =  j;
        }//for
        
        for (int i =0; i<a.length; i++ ){
            System.out.printf( " a[%d] = %d\n",  i, a[i] );
        }//for
        System.out.printf( "###############################################################################\n" );
        
        
        
        b = a;
        for (int i =0; i<a.length; i++ ){
            System.out.printf( " a[%d] = %d ,  b[%d] = %d\n",  i, a[i],  i, b[i] );
        }//for
        System.out.printf( "###############################################################################\n" );
        
        
        
        b[3] = 42;  // Änderung in a und b 
        for (int i =0; i<a.length; i++ ){
            System.out.printf( " a[%d] = %d ,  b[%d] = %d\n",  i, a[i],  i, b[i] );
        }//for
        System.out.printf( "###############################################################################\n" );
        
        
        
        int[] c;
        c = new int[a.length];
        for (int i =0; i<a.length; i++ ){
            c[i] = a[i];
        }//for
        
        for (int i =0; i<a.length; i++ ){
            System.out.printf( " a[%d] = %d ,  b[%d] = %d ,  c[%d] = %d\n",  i, a[i],  i, b[i],  i, c[i] );
        }//for
        System.out.printf( "###############################################################################\n" );
        
        
        
        c[8] = 077;
        for (int i =0; i<a.length; i++ ){
            System.out.printf( " a[%d] = %d ,  b[%d] = %d ,  c[%d] = %d\n",  i, a[i],  i, b[i],  i, c[i] );
        }//for
        
    }//main

}//Test091022a
