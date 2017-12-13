package inDerVorlesung.day091030;

public class Test091030b {
    
    static Test091030bCounter cnt1;
    
    public static void main( String[] args ){
        
        Test091030bCounter cnt2;
        
        cnt1 = new Test091030bCounter();
        cnt2 = new Test091030bCounter(2);
        System.out.printf( "cnt1 -> %d\n", cnt1.cnt );
        System.out.printf( "cnt2 -> %d\n", cnt2.cnt );
        cnt1.inc();
        System.out.printf( "cnt1 -> %s\n", cnt1 );        // toString() wird für Ausgabe genutzt
        System.out.printf( "cnt2 -> %s\n", cnt2 );        // toString() wird für Ausgabe genutzt
    }//main
    
}//Test091030b
