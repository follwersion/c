package a09;

import java.io.IOException;

public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args)  {
	
		Gui openDialog = new Gui();
		Read xfile = new Read();
		Replace something = new Replace();
	
		
		
		
		try {
			xfile.readFile(openDialog.jFileChooser());
			
			xfile.readFileformap(openDialog.jFileChooser());
			
			xfile.outputmap();
			
			
			xfile.wordcheck();
			xfile.wortdurschnitt();
		
			xfile.output();
			something.replacetest(xfile.word,openDialog.file);
			
			
		} catch (IOException e) {
			System.out.println("File Error");
			e.printStackTrace();
		}
		
		
	}

}
