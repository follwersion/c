/*
 * Praktikum: P1P
 * Semester:  WS07
 * Team:      S1T7
 * Author:    Bruns, Felix       #1907766
 *            Schulz, Thomas     #1899432
 * Aufgabe:   A7 - Fuhrpark
 */

package ti1prp_.aufgabe07;

public class Truck extends Kfz {
	protected int load;
    
    public Truck(String name, Color color, Fuel fuel, int load){
        super(name, color, fuel);
        this.load = load;
        this.costs = this.costs();
        this.subtype = VehicleSubType.LKW;
    }

    private int costs(){
        if (load < 10)return 80;
        else if (load < 20 )return 90;
        else if (load < 30 )return 100;
        else if (load < 40 )return 125;
        else return 200;
    }
    
    public String toString() {
        return String.format("%s\tMax Zuladung: %d", super.toString(), this.load);
    }
}
