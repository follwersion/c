package a06;



public class DVD extends Medium {

	/**
	 * @author Lukas Lukowski Konstantin Dolberg
	 * Datum 04.05.09
	 * Aufgabe 6
	 */
	
	
	String regisseur ;
	
	public DVD(String regisseur, String realase, String title) {
		super(title, realase);
		this.regisseur = regisseur ;
		
}
	
	public String toString() {
	      return super.toString() +"Regie: " + this.regisseur;
	   } 
}
