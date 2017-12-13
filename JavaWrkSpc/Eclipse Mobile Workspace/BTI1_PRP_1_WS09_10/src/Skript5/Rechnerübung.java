package Skript5;

public class Rechnerübung {

    /**
     * @param args
     */
    public static void main(String[] args) {

        // x^4 berechnen
        
        int xx = 2;
        int x2 = 2;
        
        // per Math.pow()
        xx = (int) Math.pow(xx, 4);
        System.out.println(xx);
        
        // per schleife
        for (int i = 0; i < 3; i++) {
            x2*=2;            
        }
        System.out.println(xx);
        
        
        int z = 1;
        int y = 2;
        int x = 3;
        
//        int a = ++x;
//        System.out.println(a);
//        
//        int b = y++;
//        System.out.println(b);
                
        z = ++x + y++;
        System.out.println(z);
        
        
    }

}
