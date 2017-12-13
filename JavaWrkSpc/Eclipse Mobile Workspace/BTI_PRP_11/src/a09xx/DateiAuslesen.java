package a09xx;

/**
 * @Autor: Christopher Schmidt
 * 		   Martin Hua
 * Quelle: http://openbook.galileocomputing.de/javainsel8/javainsel_12_008.htm#mjd9d99744f8039b5fb45ed9d8a6510d6c 
 */

import java.io.BufferedReader;
import java.io.IOException;

public class DateiAuslesen {
	
	public String readoutFile(BufferedReader br){
		String line = "";
		String text = "";
		int counterReturn = 0;
		
		try{
			if (br.ready()){
				while ((line = br.readLine()) != null){			
					text = text + line + "_";
					counterReturn++;						
				}			
			}
		}catch (IOException e){
			System.err.println("Fehler beim Lesen der Datei!");
		}
		System.out.println("Zeilenumbruch: " + counterReturn);		
		return text;
	}
}
