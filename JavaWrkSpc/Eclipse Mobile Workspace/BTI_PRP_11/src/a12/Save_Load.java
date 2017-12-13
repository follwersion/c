package a12;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Save_Load {

	
	/**
	 * @Teamname SingleMalt
	 * 
	 *@author Lukas Lukowski
	 */
	
	public void save(ArrayList<Kunde> kListe) throws FileNotFoundException,
			IOException {
		ObjectOutputStream Objserial = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream("serial.txt")));

	
		for (int i = 0; i < kListe.size(); i++) {
			Objserial.writeObject(kListe);
		}

		Objserial.close();

	}

	public void load(ArrayList<Kunde> kListe) throws FileNotFoundException,
			IOException, ClassNotFoundException {
		ObjectInputStream Objdeserial = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream("serial.txt")));
		try {
			while (true) {

				Kunde m = (Kunde) Objdeserial.readObject();
				kListe.add(m);
			

			}
		} catch (EOFException e) {
			System.out.println("Ready!");
		} finally {
			Objdeserial.close();
		}

	}

}
