/*
 * Praktikum: P1P
 * Semester:  WS07
 * Team:      S1T7
 * Author:    Bruns, Felix       #1907766
 *            Schulz, Thomas     #1899432
 * Aufgabe:   A8 - Universal-Liste
 */

package ti1prp_.aufgabe08;

public class DVD extends Disc {

	public DVDFormat format;
	
	public DVD(String title, DVDFormat format, DiscContent content) {
		super(DiscType.DVD, content, title);
		
		this.format  = format;
	}

	public String toString() {
        return String.format("%s - %s", super.toString(), this.format);
    }
    
    public boolean equals(Object o){
        if(super.equals(o) && o instanceof DVD && this.format  == ((DVD)o).format){
            return true;
        }
        return false;
    }
    
}
