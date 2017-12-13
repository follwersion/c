package inDerVorlesung.day091022;


public class Test091022b {
    
    public static void main( String[] args ){
        
        int [][][] a;
        
        a = new int[2][3][4];
        
        int i=0;
        for (int d1=0; d1<a.length; d1++){
            for ( int d2=0;  d2<a[d1].length;  d2++ ){
                for ( int d3=0;  d3<a[d1][d2].length;  d3++ ){
                    a[d1][d2][d3] = i++;
                }//for
            }//for
        }//for
        
        
        int [][][] b;
        b = new int [a.length] [a[0].length] [a[0][0].length];
        for (int d1=0; d1<a.length; d1++){
            for ( int d2=0;  d2<a[d1].length;  d2++ ){
                for ( int d3=0;  d3<a[d1][d2].length;  d3++ ){
                    b[d1][d2][d3] = a[d1][d2][d3];
                }//for
            }//for
        }//for

        
        for (int d1=0; d1<a.length; d1++){
            for ( int d2=0;  d2<a[d1].length;  d2++ ){
                for ( int d3=0;  d3<a[d1][d2].length;  d3++ ){
                    assert a[d1][d2][d3] == b[d1][d2][d3] : "ungleich";
                }//for
            }//for
        }//for
        
        System.out.printf( "################################################\n" );
        
        
        
        a = new int[][][] {  {  { 1,2,3},
                                {4,5},
                                null,
                                {6,7,8,9}
                             },
                             {  { 13 }
                             }
                          };
        System.out.printf( "%d =?= 7, %d =?= 13\n", a[0][3][1], a[1][0][0] );
        
    }//main

}//Test091022b
