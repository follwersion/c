package Test.ack;

public class ackack {
    
    static int a = -13;
    static int b = -17;
    
    static boolean ack;

    public static void swap( int a, int b ) {
        int tmp;
        tmp = a;
        a = b;
        b = tmp;
        
    }
    
    public static void main(String[] args) {
        
        int bla1 = 6; // 1000
//        int bla2 = 1; // 0001
        
        System.out.println(bla1 >>> 1);
        System.out.println();
        
        
//        int i = 2345;
        int j = 0x11;
//        int k = 0123;
//        long l = 0xC0B0L;
//        
//        int x = 1;
        
        System.out.println(j);
        
        short s = (short) -65536;
        System.out.println(s);
        
        System.out.println(Short.MIN_VALUE + "  " + Short.MAX_VALUE);
        
        System.out.println(ack);
        
        int a;
        int b;
        //...
        a=1;
        b=2;
        
        System.out.println(a + "  " + b);
        //werte von a und b tauschen
        int tmp;
        tmp = a;
        a = b;
        b = tmp;
        
        System.out.println(a + "  " + b);
        
    
    
    //2. versuch
    swap(a,b);
    System.out.println(a + "  " + b);       
    //wichtige berechnung ( a )
    //wichtige berechnung ( b )
    }
    
 

}
