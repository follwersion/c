package inDerVorlesung.day091106;

public class Test091106aLine {
    
    Test091106aPoint p1;
    Test091106aPoint p2;
    
    
    
    Test091106aLine( int p1x, int p1y, int p2x, int p2y ){
        this.p1 = new Test091106aPoint( p1x, p1y );
        this.p2 = new Test091106aPoint( p2x, p2y );
    }//Line
    
    
    
    double length(){
        return Math.sqrt(   Math.pow( this.p1.x - this.p2.x ,  2 )
                          + Math.pow( this.p1.y - this.p2.y ,  2 ) );
    }//length
    
    
    public String toString(){ return String.format( "(Line): p1=[%s] p2=[%s]",  this.p1, this.p2 ); }
    
}//Line
