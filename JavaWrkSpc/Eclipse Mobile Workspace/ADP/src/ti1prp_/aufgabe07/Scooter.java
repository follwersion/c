/*
 * Praktikum: P1P
 * Semester:  WS07
 * Team:      S1T7
 * Author:    Bruns, Felix       #1907766
 *            Schulz, Thomas     #1899432
 * Aufgabe:   A7 - Fuhrpark
 */

package ti1prp_.aufgabe07;

public class Scooter extends Velo {
    
    public Scooter(String name, Color color) {
        super(name, color);
        this.costs = costs();
        this.subtype = VehicleSubType.Roller;
    }

    private double costs(){
        if (this.color == Color.red )return 0.11;
        else if (this.color == Color.green )return 0.15;
        else if (this.color == Color.yellow )return 0.99;
        else if (this.color == Color.blue )return 0.17;
        else return 0.1;
    }
    
    public String toString() {
        return super.toString();
    }
}
