/*
 * Praktikum: P1P
 * Semester:  WS07
 * Team:      S1T7
 * Author:    Bruns, Felix       #1907766
 *            Schulz, Thomas     #1899432
 * Aufgabe:   A7 - Fuhrpark
 */

package ti1prp_.aufgabe07;

public class Bus extends Kfz {
	protected int seats;
	protected BusType bustype;
	
    public Bus(String name, Color lack, Fuel fuel, int seats, BusType bustype) {
        super(name, lack, fuel);
        this.seats = seats;
        this.bustype = bustype;
        this.costs = (this.bustype == BusType.Normal)?100:125;
        this.subtype = VehicleSubType.Bus;
    }

    public String toString() {
        return String.format("%s\tSitzplätze: %d\tArt des Busses: %s", super.toString(), this.seats, this.bustype);
    }
}
