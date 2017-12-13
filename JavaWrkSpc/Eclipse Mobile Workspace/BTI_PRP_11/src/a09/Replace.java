package a09;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Replace  {
	
	String newword;
	String search;
	String replace;
	
	
	
	public void replacetest(String word,File file){
		try {
			FileWriter f = new FileWriter(file);
			Scanner eingabe = new Scanner(System.in);
			System.out.println("Geben Sie das Wort ein, das ersetzt werden soll");
			search = eingabe.next();
			System.out.println("Für welches Wort soll "+ search +"ersetzt werden?");
			replace = eingabe.next();
			
		newword =	word.replaceAll(search, replace);
		f.write(newword);
		f.close();
		} catch (IOException e) {
			System.out.println("Fehler Replace");
			e.printStackTrace();
		}
		
		
		
	}

}
