/*
 * Praktikum: P1P
 * Semester:  WS07
 * Team:      S1T7
 * Author:    Bruns, Felix       #1907766
 *            Schulz, Thomas     #1899432
 * Aufgabe:   A7 - Fuhrpark
 */

package ti1prp_.aufgabe07;

public class Kfz extends Vehicle {
	protected Fuel fuel;
    
    public Kfz(String name, Color color, Fuel fuel) {
        super(name, color);
        this.fuel = fuel;
        this.type = VehicleType.KFZ;
    }
    
    public String toString(){
        return String.format("%s\tTreibstoff: %s", super.toString(), this.fuel);
    }
}
