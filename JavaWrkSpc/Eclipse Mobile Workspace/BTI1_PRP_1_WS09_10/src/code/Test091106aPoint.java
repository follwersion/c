package inDerVorlesung.day091106;

public class Test091106aPoint {
    
    int x;
    int y;
    
    
    
    Test091106aPoint( int x, int y ){
        this.x = x;
        this.y = y;
    }//Point
    
    Test091106aPoint(){
        this( 0, 0 );
    }//Point
    
    
    
    public String toString(){ return String.format( "(Point): x=%d y=%d",  this.x, this.y ); }

}//Point
