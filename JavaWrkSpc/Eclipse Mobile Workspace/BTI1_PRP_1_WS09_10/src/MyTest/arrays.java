package MyTest;

public class arrays {

    /**
     * @param args
     */
    public static void main(String[] args) {

        int[] a, b;

        a = new int[10];

        for (int i = a.length - 1; i >= 0; i--) {
            a[i] = a.length - i;

        }
        for (int i = 0; i < a.length; i++) {
            System.out.printf(" a[%d] = %d\n", i, a[i]);

        }
        System.out.printf("###############################\n");

        a = new int[10];

      
        for (int i = 0, j = a.length; i < a.length; i++, j--) {
            a[i] = j;

        }
        
        
        for (int i = 0; i < a.length; i++) {
            System.out.printf(" a[%d] = %d\n", i, a[i]);

        }
        System.out.printf("###############################\n");
    
    
    b= a;
    for (int i = 0, j = a.length; i < a.length; i++, j--) {
        a[i] = j;

    }
    
    b[3]=42;
    for (int i = 0; i < a.length; i++) {
        System.out.printf(" a[%d] = %d,  b[%d] = %d\n", i, a[i], i, b[i]);

    }
    System.out.printf("###############################\n");
}
}