package a06;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Mediathek {

	/**
	 * @author Lukas Lukowski Konstantin Dolberg Datum 04.05.09 Aufgabe 6
	 */

	List<Medium> medien = new LinkedList<Medium>();

	public void addMedium(Medium obj) {
		medien.add(obj);

	}

	public void delobj(Medium obj) {
		medien.remove(obj);

	}

	public void searchobj(Medium obj) {

		medien.contains(obj);
		if (true) {
			System.out.println("FOUND!");

		} else
			System.out.println("NOT FOUND!");
	}

	public void outtest() {

		for (int i = 0; i < medien.size(); i++) {
			System.out.println(medien.get(i));
		}

	}

	public void sort(){
		Collections.sort(medien);
	}

}