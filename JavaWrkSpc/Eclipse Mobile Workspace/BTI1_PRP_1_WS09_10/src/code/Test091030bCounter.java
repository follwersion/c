package inDerVorlesung.day091030;

public class Test091030bCounter {
    
    //
    //
    // DECLARATIONs-------------------------------------------------------------

    int cnt;
    
    
    
    //
    //
    // CONSTRUCTORs-------------------------------------------------------------
    
    Test091030bCounter( int cnt){
        this.cnt = cnt;
    }//Counter
    
    Test091030bCounter(){
        this( 0 );
    }//Counter
    
    
    
    //
    //
    // METHODs------------------------------------------------------------------
    
    void inc(){
        this.cnt++;
    }//inc
    
    void dec(){
        this.cnt--;
    }//dec
    
    public String toString(){ return String.format( "%s", cnt ); }

}//Counter
