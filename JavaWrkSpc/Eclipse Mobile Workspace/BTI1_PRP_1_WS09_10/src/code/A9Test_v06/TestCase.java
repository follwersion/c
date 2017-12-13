package aufgabenzettel4_A9.test;

public class TestCase {
    
    private Test          test;
    private ResultOfGame  rog;
    
    
    public TestCase( Test test ){
        this.test = test;
        this.rog  = null;
    }//TestCase
    
    
    public Test getTest(){ return this.test; }
    public void setROG( ResultOfGame rog ){ this.rog = rog; }
    ResultOfGame getROG(){ return this.rog; }
    public long getWert(){ return this.rog.getWert(); }
    
    
    public void prettyPrint( int numOfTest){
        System.out.printf( "---------------vvvvv\n" );
        System.out.printf( "Test #%d:\n", numOfTest );
        System.out.printf( "community cards :" );
        for ( int i=0; i<5; i++ ){
            System.out.printf( " %s", this.test.getCommunityCards()[i] );
        }//for
        System.out.printf( "\n" );

        for (int i=0; i<5; i++ ){ 
            System.out.printf( "player#%d        : %s %s\n", i+1, this.test.getPlayerHoleCards(i)[0], this.test.getPlayerHoleCards(i)[1] );
        }//for
        this.rog.printROG();
        System.out.printf( "---------------^^^^^\n" );
    }//prettyPrint
    
}//TestCase
