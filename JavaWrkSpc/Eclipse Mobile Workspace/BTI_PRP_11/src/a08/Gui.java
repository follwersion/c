package a08;

import java.io.File;
import java.util.Date;

import javax.swing.JFileChooser;

public class Gui {
	

	/**
	 * @author Lukas Lukowski Konstantin Dolberg
	 * Datum 18.05.09
	 * Aufgabe 8
	 */

	File f = null;
	double size;
	String filename;
	Date date;
	JFileChooser chooser;
	public Gui(){
		chooser = new JFileChooser();
	}

	public void startJFileChooser() {
		chooser.showOpenDialog(null);
	}

	public void outputfile() {
		f = chooser.getSelectedFile();
		filename = f.getName();
		size = f.length();
		date = (new Date(f.lastModified()));
		System.out.println("Filename: " + filename + "\nPath: " + f
				+ "\nSize: " + size + "byte" + "\nDate: " + date);

	}

}
