package a09;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;



public class Gui {
	boolean ok ;
	File file ;
	JFileChooser chooser = new JFileChooser();
	FileNameExtensionFilter filter=new FileNameExtensionFilter("TextDokumente","txt","tex","html","xml");
	 
	
	public File jFileChooser(){
	
		
		chooser.setAcceptAllFileFilterUsed(false);   
		chooser.addChoosableFileFilter(filter);
		chooser.showOpenDialog(null);
		
		file = chooser.getSelectedFile();
	
			
		return file ;
	
	}

}
