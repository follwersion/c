/*
 * Praktikum: P1P
 * Semester:  WS07
 * Team:      S1T7
 * Author:    Bruns, Felix       #1907766
 *            Schulz, Thomas     #1899432
 * Aufgabe:   A8 - Universal-Liste
 */

package ti1prp_.aufgabe08;

public class Disc {
	
	public DiscType type;
	public DiscContent content;
	public String title;
	
    public Disc(DiscType type, DiscContent content, String title) {
        this.type    = type;
        this.content = content;
        this.title   = title;
    }
    
    public String toString() {
        return String.format("%s (%s):\t%s", this.type, this.content, this.title);
    }
    
    public boolean equals(Object o){
        if(o instanceof Disc){
            if(this.type    == ((Disc)o).type &&
               this.content == ((Disc)o).content &&
               this.title   == ((Disc)o).title){
                   return true;
            }
        }
        return false;
    }
    
}
