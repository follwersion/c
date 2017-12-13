/*
 * Praktikum: P1P
 * Semester:  WS07
 * Team:      S1T7
 * Author:    Bruns, Felix       #1907766
 *            Schulz, Thomas     #1899432
 * Aufgabe:   A8 - Universal-Liste
 */

package ti1prp_.aufgabe08;

public class DiscManagement {
	
	public static MagicList<Disc> discs;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		discs = new MagicList<Disc>();
		
		discs.putL(new CD("Heino", "Sing mit Heino", DiscContent.Audio));
		discs.putL(new CD("Led Zeppelin", "IV", DiscContent.Audio));
		
        discs.putF(new DVD("Augsburger Puppenkiste: Urmel aus dem Eis - Gold Edition", DVDFormat.PAL, DiscContent.Movie));
        discs.putF(new DVD("Sin City - Uncut", DVDFormat.NTSC, DiscContent.Movie));
        discs.putF(new DVD("Gone with the Wind", DVDFormat.PAL, DiscContent.Movie));
        discs.putF(new DVD("David Bowie: Best of Bowie", DVDFormat.PAL, DiscContent.Video));
        
        discs.putL(new CD("Red Hot Chili Peppers", "Stadium Arcadium - Jupiter", DiscContent.Audio));
        discs.putL(new CD("Red Hot Chili Peppers", "Stadium Arcadium - Mars", DiscContent.Audio));
        discs.putL(new CD("The Pidgeon Detectives", "Wait For Me", DiscContent.Audio));
        discs.putL(new CD("The Kooks", "Inside In, Inside Out", DiscContent.Audio));
        discs.putL(new CD("The Subways", "Young For Eternity", DiscContent.Audio));
        discs.putL(new CD("VA", "The Disco Boys Vol. 8", DiscContent.Audio));
        
        discs.putF(new DVD("300", DVDFormat.NTSC, DiscContent.Movie));
        discs.putF(new DVD("The Lord of the Rings - The Return of the King", DVDFormat.PAL, DiscContent.Movie));
        discs.putF(new DVD("Ski-Urlaub 2007", DVDFormat.PAL, DiscContent.Video));
        discs.putF(new DVD("Sicherungskopie 20.12.2007", DVDFormat.Data, DiscContent.Data));
        
        discs.printF2L();
        
        /*System.out.println();
        discs.remove(discs.peekNo(8));
        discs.printF2L();*/
        
        System.out.println();
        //discs.clear();
        System.out.print(discs.isEmpty());
        
        System.out.println();
        System.out.println();
        
        discs.subList(discs.getNo(5), discs.getNo(10)).printF2L();
    }

}
