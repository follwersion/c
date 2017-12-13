/*
 * Praktikum: P1P
 * Semester:  WS07
 * Team:      S1T7
 * Author:    Bruns, Felix       #1907766
 *            Schulz, Thomas     #1899432
 * Aufgabe:   A8 - Universal-Liste
 */

package ti1prp_.aufgabe08;

public class CD extends Disc {
	
	public String artist;
	
	public CD(String artist, String title, DiscContent content) {
		super(DiscType.CD, content, title);
		
		this.artist  = artist;
	}

	public String toString() {
		return String.format("%s - %s", super.toString(), this.artist);
	}
    
    public boolean equals(Object o){
        if(super.equals(o) && o instanceof CD && this.artist  == ((CD)o).artist){
            return true;
        }
        return false;
    }
    
}
