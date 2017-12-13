package a06;



public class CD extends Medium {
	
	/**
	 * @author Lukas Lukowski Konstantin Dolberg
	 * Datum 04.05.09
	 * Aufgabe 6
	 */

	 
	 String[]interpret =new String[5];
	
	public CD(String interpret, String realase, String title) {
		super(title, realase);
		this.interpret[1]=interpret;
		
	}


	   public String toString() {
	      return super.toString() +"Interpret: " + this.interpret[1];
	   } 
	
	

	
	
	
}
