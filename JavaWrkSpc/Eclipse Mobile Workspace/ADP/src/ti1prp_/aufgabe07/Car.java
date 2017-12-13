/*
 * Praktikum: P1P
 * Semester:  WS07
 * Team:      S1T7
 * Author:    Bruns, Felix       #1907766
 *            Schulz, Thomas     #1899432
 * Aufgabe:   A7 - Fuhrpark
 */

package ti1prp_.aufgabe07;

public class Car extends Kfz{
	protected int speed;
	protected int seats;
	
    public Car(String name, Color color, Fuel fuel, int speed, int seats) {
        super(name, color, fuel);
        this.speed = speed;
        this.seats = seats;
        this.costs = costs();
        this.subtype = VehicleSubType.PKW;
    }
    
    private int costs(){
        if (speed < 100)return 10+(this.seats*2);
        else if (speed < 150 )return 15+(this.seats*2);
        else if (speed < 100 )return 25+(this.seats*2);
        else return 50+(this.seats*2);
    }
    
    public String toString(){
        return String.format("%s\tSitzplätze: %d\tMax Geschwindigkeit: %d", super.toString(), this.seats, this.speed);
    }
}
