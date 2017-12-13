/*
 * Praktikum: P1P
 * Semester:  WS07
 * Team:      S1T7
 * Author:    Bruns, Felix       #1907766
 *            Schulz, Thomas     #1899432
 * Aufgabe:   A7 - Fuhrpark
 */

package ti1prp_.aufgabe07;

public class Bicycle extends Velo {

    public Bicycle(String name, Color color) {
        super(name, color);
        this.costs = 1;
        this.subtype = VehicleSubType.Fahrrad;
    }

    public String toString() {
        return String.format("%s\tKosten pro Tag: %.2f Euro", super.toString(), this.costs);
    }
}
