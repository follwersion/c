package Test;

import Skript5.String;


public class Arrays2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        int [][][] a;
        
        a= new int [2][3][4];
        
        int i = 0;
        
        for (int d1 = 0; d1 < a.length; d1++) {
            for (int d2 = 0; d2 < a[d1].length; d2++) {
                for (int d3 = 0; d3 < a[d1][d2].length; d3++) {
                    a[d1][d2][d3] = i++;
                    
                }
                
            }
            
        }
        
    }
}
