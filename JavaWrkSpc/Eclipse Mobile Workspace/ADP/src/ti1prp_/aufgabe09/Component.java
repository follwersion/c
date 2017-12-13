package ti1prp_.aufgabe09;

/*
 * Praktikum: P1P
 * Semester:  WS07
 * Team:      S1T7
 * Author:    Bruns, Felix     #1907766
 *            Schulz, Thomas   #1899432
 * Aufgabe:   A9 - Computer Shop
 */

public abstract class Component {
	String name; /* Bezeichnung */
	int price;   /* Preis (in Cent) */
	int cnsNo;   /* fortlaufende Nummer */
	
	static int current = 0;
	
	public Component(String name, int price){
		this.name  = name;
		this.price = price;
        this.cnsNo = current++;
    }
	
	public String toString(){
        return String.format("%s =>\t[Name: %20s]\t[Price: %6d]\t[ID: %5d]",
                             this.getClass().getSimpleName(), this.name, this.price, this.cnsNo);
	}
}
