package a06;



public class Main {
	
	/**
	 * @author Lukas Lukowski Konstantin Dolberg
	 * Datum 04.05.09
	 * Aufgabe 6
	 */

	public static void main(String[] args) {

		Mediathek boberg = new Mediathek();
		
		Buch Beins =new Buch("Vergebung", "3453434064","978-3453434066","Stieg Larsson","09052009");
		Buch Bzwei =new Buch("Vergebung", "3453434064","978-3453434066","Stieg Larsson","10052009");
		Buch Bdrei =new Buch("Vergebung", "3453434064","978-3453434066","Stieg Larsson","11052009");

		CD CDeins =new CD("The Notorious BIG", "04032002","Big Poppa [Remix]");
		CD CDzwei =new CD("The Notorious BIG", "05032002.","Big Poppa [Remix]");
		CD CDdrei =new CD("The Notorious BIG", "06032002","Big Poppa [Remix]");
				
		DVD DVDeins =new DVD("Unbekannt","10102009","RockyI");
		DVD DVDzwei =new DVD("Unbekannt","11112009","RockyII");
		DVD DVDdrei =new DVD("Unbekannt","12122009","RockyIII");
			
		System.out.println("Objekte in der Liste:");
		
		boberg.addMedium(Beins); 
		boberg.addMedium(Bzwei); 
		boberg.addMedium(Bdrei); 

		boberg.addMedium(CDeins);
		boberg.addMedium(CDzwei);
		boberg.addMedium(CDdrei);

		boberg.addMedium(DVDeins);
		boberg.addMedium(DVDzwei);
		boberg.addMedium(DVDdrei);

		boberg.outtest();
		boberg.sort();
		boberg.outtest();
		System.out.println("Gesuchtes Objekt");
		System.out.print("------------------------------------------------");
		System.out.println(""+DVDeins);
		boberg.searchobj(DVDeins);
	
		System.out.println("Objekte in der Liste nach delobj:");
		boberg.delobj(Beins);
		boberg.delobj(CDeins);
		boberg.delobj(DVDeins);
		
		
		boberg.outtest();

	}
}