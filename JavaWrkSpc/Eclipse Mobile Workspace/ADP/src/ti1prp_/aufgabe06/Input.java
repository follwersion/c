/*
 * Praktikum: P1P
 * Semester:  WS07
 * Team:      S1T7
 * Author:    Bruns, Felix       #1907766
 *            Schulz, Thomas     #1899432
 * Aufgabe:   A6 - Decorator Pattern
 */

package ti1prp_.aufgabe06;

public class Input {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Kg test = new Kg();
        System.out.println(test.tu());
        System.out.println(test.xx());
        System.out.println(test.id());
        System.out.println("---------------------------------------------------------");        
        D2 test_d2 = new D2(test);
        System.out.println(test_d2.tu());
        System.out.println(test_d2.xx());
        System.out.println(test_d2.id());
        System.out.println("---------------------------------------------------------");        
        D3 test_d3 = new D3(test);
        System.out.println(test_d3.tu());
        System.out.println(test_d3.xx());
        System.out.println(test_d3.id());
        System.out.println("---------------------------------------------------------");        
        D5 test_d5 = new D5(test);
        System.out.println(test_d5.tu());
        System.out.println(test_d5.xx());
        System.out.println(test_d5.id());
        System.out.println("---------------------------------------------------------"); 
        D2 t = new D2(new D3(new D5(new Kv())));
        System.out.println(t.tu());
        System.out.println(t.xx());
        System.out.println(t.id());
        
    }//class main

}//public class input
