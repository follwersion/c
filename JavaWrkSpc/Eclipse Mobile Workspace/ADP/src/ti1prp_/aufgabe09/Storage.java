package ti1prp_.aufgabe09;

/*
 * Praktikum: P1P
 * Semester:  WS07
 * Team:      S1T7
 * Author:    Bruns, Felix     #1907766
 *            Schulz, Thomas   #1899432
 * Aufgabe:   A9 - Computer Shop
 */

public abstract class Storage extends Component {
    String cap; /* Speicherkapazität */
    
    public Storage(String name, int price, String cap){
        super(name, price);
        
        this.cap = cap;
    }
    
	public String toString(){
        return String.format("%s\t[Capacity: %5s]",
                             super.toString(), this.cap);
	}
}
