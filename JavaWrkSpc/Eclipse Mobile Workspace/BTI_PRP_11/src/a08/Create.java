package a08;

import java.io.File;
import java.io.IOException;

public class Create extends Space {
	

	/**
	 * @author Lukas Lukowski Konstantin Dolberg
	 * Datum 18.05.09
	 * Aufgabe 8
	 */

	public void createFolder() {
		try {

			new File("/PRPa07").mkdir();
			file.exists();
			if (true) {
				System.err.println("Directory or File already exists");
			}
		} catch (Exception e) {
			System.err.print("Fehler aufgetreten!");

		}

	}

	public void createFile() throws IOException {

		try {
			new File("PRPa07/PRPa07.txt").createNewFile();
			file.exists();
			if (true) {
				System.err.println("Directory or File already exists");
			}
		} catch (Exception e) {
			System.err.println("Fehler Aufgetreten");
		}
	}

}
