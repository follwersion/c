package a09xx;

/**
 * @Autor: Christopher Schmidt
 * 		   Martin Hua
 * Quelle: http://openbook.galileocomputing.de/javainsel8/javainsel_12_008.htm#mjd9d99744f8039b5fb45ed9d8a6510d6c 
 */

public class SuchenUndErsetzen {
	
	public boolean searchWord(String wort, String text){
		boolean found = false;
		
		if (text.contains(wort)){
			found = true;
		}
	return found;	
	}
	
		
	public String searchAndReplace(String suchwort, String ersetzungswort, String textcopy){
		
		textcopy = textcopy.replaceAll("  ", " ");
		textcopy = textcopy.replaceAll(suchwort, ersetzungswort);		
		return textcopy;	
	}	
}
