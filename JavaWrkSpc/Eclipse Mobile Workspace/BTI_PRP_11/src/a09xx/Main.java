package a09xx;

/**
 * @Autor: Christopher Schmidt
 * 		   Martin Hua
 * Quelle: http://openbook.galileocomputing.de/javainsel8/javainsel_12_008.htm#mjd9d99744f8039b5fb45ed9d8a6510d6c 
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;


public class Main {
	
	public static void main(String[] args) {
		int cancel = JFileChooser.APPROVE_OPTION;
		int status = 0;
		float completeWords = 0;
		float completeTokens = 0;
		double laenge = 0;
		boolean found = false;
		JFileChooser chooseFile = new JFileChooser();	
		Scanner scan = new Scanner(System.in);
		String choose = "";
		String searchTokens = "";
		String ersetzungswort = "";
		DateiAuslesen datei = new DateiAuslesen();
		Textanalyse analyse = new Textanalyse();
		File file = null;	
		FileReader fr = null;
		BufferedReader br = null;
		SuchenUndErsetzen newText = new SuchenUndErsetzen();
		String text = "";
		String textWithoutUnderline = "";
		String textcopy = "";
		
		status = chooseFile.showOpenDialog(chooseFile);
		if (status == cancel){
			file = chooseFile.getSelectedFile();
			try{
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				System.out.println("Haeufigkeit der einzelnen Zeichen im Text:\n");
				text = datei.readoutFile(br);
				if (fr.read() == -1){
					fr.close();
				}				
				completeTokens = analyse.numberOfTokens(text);	
				textWithoutUnderline = text;
				textWithoutUnderline = textWithoutUnderline.replace("_", " ");
				completeWords = analyse.numberOfWords(textWithoutUnderline);	
				laenge = analyse.average(completeTokens, completeWords);
				System.out.printf("\nGesamtzeichen: " + (int) completeTokens + 
								  "\nAnzahl der Worte: " + (int) completeWords + 
								  "\nDurchschnittslaenge: " + "%.2f", laenge);
				
				System.out.println("\n\nMoechten Sie ein Zeichen bzw. ein Wort suchen und diese ggf. durch ein anderes Zeichen bzw. Wort ersetzen?\n"
									+ "  Fuer ja: y druecken\n  Fuer nein: beliebige Taste druecken");
				choose = scan.next();
				
				if (choose.equals("y")){
					while (!found){						
						System.out.println("Geben Sie ein Zeichen bzw. Wort ein, das Sie im Text suchen m�chten: ");
						searchTokens = scan.next();
						found = newText.searchWord(searchTokens, textWithoutUnderline);
						
						if (found){
							System.out.println("Ihr gesuchtes Zeichen bzw. Wort wurde gefunden.\n" +
											   "\n\nMoechten Sie dieses Zeichen bzw. dieses Wort im Text durch ein anderes Zeichen bzw. Wort ersetzen?\n"
											 + "  Fuer ja: y druecken\n  Fuer nein: beliebige Taste druecken");
							choose = scan.next();
							if (choose.equals("y")){
								System.out.println("Geben Sie ein Zeichen bzw. ein Wort ein, dass Ihr Gesuchtes ersetzen soll: ");
								ersetzungswort = scan.next();
								textcopy = newText.searchAndReplace(searchTokens, ersetzungswort, textWithoutUnderline);																
								System.out.println("\nAlter Text: " + textWithoutUnderline
												 + "\nNeuer Text: " + textcopy); 								
							}else{
								System.out.println("Ihr gesuchtes Zeichen bzw. Wort ist: " + searchTokens);
							}
						}else{
							System.out.println("Ihr gesuchtes Zeichen bzw. Wort wurde nicht gefunden!\n");
						}
					}
				}else{
					System.out.println("Sie haben das Programm beendet!");
				}				
			}catch(IOException e){
				e.printStackTrace();
			}			
		}
	}		
}
		