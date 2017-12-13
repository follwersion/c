package ti1prp_.aufgabe09;

/*
 * Praktikum: P1P
 * Semester:  WS07
 * Team:      S1T7
 * Author:    Bruns, Felix     #1907766
 *            Schulz, Thomas   #1899432
 * Aufgabe:   A9 - Computer Shop
 */

public class HardDisk extends Storage {
    int heads; /* Anzahl Schreib-Leseköpfe */
    HDI intf;  /* Schnittstelle */
    
    public HardDisk(String name, int price, String cap, HDI intf){
        super(name, price, cap);
        
        this.heads = 1;
        this.intf  = intf;
    }
    
    public String toString(){
        return String.format("%s\t[Heads: %2d]\t[Interface: %4s]",
                             super.toString(), this.heads, this.intf);
    }
}
