package Skript4;

public class casts {

    /**
     * @param args
     */
    public static void main(String[] args) {

        double d = 5.05;
        System.out.println(d);
        
        int i = (int) d;
        System.out.println(i);
        
        int x = 0xFFFF;
        System.out.println(x);
        
        short s = (short) x;
        System.out.println(s);
        
        // modulo
        int xx = 11%-3;
        System.out.println(xx);
        
        // bytes addieren
        byte b1, b2, b3;
        b1 = 3;
        b2 = 4;
        b3 = (byte) (b1 + b2);
        System.out.println(b3);
    }

}
