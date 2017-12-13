/*
 * Praktikum: P1P
 * Semester:  WS07
 * Team:      S1T7
 * Author:    Bruns, Felix       #1907766
 *            Schulz, Thomas     #1899432
 * Aufgabe:   A7 - Fuhrpark
 */

package ti1prp_.aufgabe07;

public class Tricycle extends Velo {
    
    public Tricycle(String name, Color color) {
        super(name, color);
        this.costs = 0.13;
        this.subtype = VehicleSubType.Dreirad;
    }

    public String toString() {
        return super.toString();
    }
}
