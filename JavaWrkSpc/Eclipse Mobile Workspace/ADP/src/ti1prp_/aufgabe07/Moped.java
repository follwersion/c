/*
 * Praktikum: P1P
 * Semester:  WS07
 * Team:      S1T7
 * Author:    Bruns, Felix       #1907766
 *            Schulz, Thomas     #1899432
 * Aufgabe:   A7 - Fuhrpark
 */

package ti1prp_.aufgabe07;

public class Moped extends Kfz {
	protected int ccm;
       
    public Moped(String name, Color color, Fuel fuel, int ccm) {
        super(name, color, fuel);
        this.ccm = ccm;
        this.costs = costs();
        this.subtype = VehicleSubType.Motorrad;
    }
    
    private int costs(){
        if (ccm < 100)return 5;
        else if (ccm < 250 )return 10;
        else if (ccm < 500 )return 30;
        else if (ccm < 1000 )return 60;
        else return 100;
    }
    
    public String toString(){
        return String.format("%s\tHubraum: %d", super.toString(), this.ccm);
    }
}
