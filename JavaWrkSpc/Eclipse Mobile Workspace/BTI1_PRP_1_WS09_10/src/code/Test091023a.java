package inDerVorlesung.day091023;

public class Test091023a {

    static int a = -13;
    static int b = -17;
    
    
    
    public static void swap( int a, int b ){
        int tmp;
        tmp = a;
        a = b;
        b = tmp;
        System.out.printf( "a=%d ,  b=%d     <-  @swap\n",  a, b );
    }//swap
        
        

    public static void main( String[] argv  ){
        int a = 11;
        int b = 12;
        System.out.printf( "a=%d ,  b=%d\n",  a, b );
        
        // Werte von a und b tauschen
        // 1.Versuch
        int tmp;
        tmp = a;
        a = b;
        b = tmp;
        System.out.printf( "a=%d ,  b=%d\n\n",  a, b );
        // es wurden die Arrays selbst getauscht und NICHT(!) die Inhalte 
        
        
        
        a = 21;
        b = 22;
        System.out.printf( "a=%d ,  b=%d\n",  a, b );
        
        // 2.Versuch
        swap( a, b );
        System.out.printf( "a=%d ,  b=%d\n",  a, b );
        // Tausch hat nicht geklappt

    }//main
    
}//Test091023a
