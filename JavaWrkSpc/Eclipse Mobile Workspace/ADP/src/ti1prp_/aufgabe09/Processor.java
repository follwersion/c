package ti1prp_.aufgabe09;

/*
 * Praktikum: P1P
 * Semester:  WS07
 * Team:      S1T7
 * Author:    Bruns, Felix     #1907766
 *            Schulz, Thomas   #1899432
 * Aufgabe:   A9 - Computer Shop
 */

public class Processor extends Component {
	String freq; /* Taktfrequenz */
	
	public Processor(String name, int price, String freq){
		super(name, price);
		
		this.freq  = freq;
    }
    
    public String toString(){
        return String.format("%s\t[Frequency: %5s]",
        		             super.toString(), this.freq);
    }
}
