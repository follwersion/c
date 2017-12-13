package Test;

import Skript5.String;


public class arrayswap {
    public static void printArray(char c, int [] array ) {
        System.out.print(c +"-> "+c);
        for (int i = 0; i < array.length; i++) {
            System.out.print("\n " + array[i]);
            return; //brauch man nicht...
        }
    }
    public static void main(String[] args) {
        
        int [] a = new int[]{1,2,3};
        int [] b = {4,5,6};
        
        printArray( 'a', a);
        printArray( 'b', b);
        //1.versuch
        
    }

}
