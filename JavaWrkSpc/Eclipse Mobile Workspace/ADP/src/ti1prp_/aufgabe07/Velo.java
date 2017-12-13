/*
 * Praktikum: P1P
 * Semester:  WS07
 * Team:      S1T7
 * Author:    Bruns, Felix       #1907766
 *            Schulz, Thomas     #1899432
 * Aufgabe:   A7 - Fuhrpark
 */

package ti1prp_.aufgabe07;

public class Velo extends Vehicle {
	
    public Velo(String name, Color color){
        super(name, color);
        this.type = VehicleType.Velo;
    }

    public String toString() {
        return super.toString();
    }
}
