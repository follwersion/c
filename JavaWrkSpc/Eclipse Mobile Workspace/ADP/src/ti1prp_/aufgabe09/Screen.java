package ti1prp_.aufgabe09;

/*
 * Praktikum: P1P
 * Semester:  WS07
 * Team:      S1T7
 * Author:    Bruns, Felix     #1907766
 *            Schulz, Thomas   #1899432
 * Aufgabe:   A9 - Computer Shop
 */

public class Screen extends Component {
	String descrip; /* Bildschirmtyp und Auflösung */
	
	public Screen(String name, int price, String descrip){
		super(name, price);
		
		this.descrip = descrip;
	}
	
    public String toString(){
        return String.format("%s\t[Description: %15s]",
        		             super.toString(), this.descrip);
    }
}
