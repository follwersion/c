package a12;

import java.io.FileNotFoundException;
import java.io.IOException;




public class Main {

	/**
	 * @Teamname SingleMalt
	 * @author Lukas Lukowski
	 */

	
	public static void main(String[] args) {
	
		ObjectCreater creater = new ObjectCreater();
	
		Save_Load store = new Save_Load();
		Gui start = new Gui();
		
		
		creater.createKunde(creater.createAuftrag(creater.createArtikel()));
		creater.calc();
		try {
			store.save(creater.returnKundelist());
		} catch (FileNotFoundException e) {
			System.out.println("File not Found");
			e.printStackTrace();
		} catch (IOException e) {
	System.out.println("File not Found");
			e.printStackTrace();
		}
		
		
		start.guistart(creater.returnKundelist());
	

	}
	

}
