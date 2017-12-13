package a08;

import java.io.IOException;

import java.util.Scanner;

public class Main {

	/**
	 * @author Lukas Lukowski Konstantin Dolberg Datum 18.05.09 Aufgabe 8
	 */

	public static void main(String[] args) {

		

		Create obj2 = new Create();
		List obj5 = new List();
		Gui obj4 = new Gui();
		ListRoot obj6 = new ListRoot();
		Scanner input = new Scanner(System.in);

		System.out
				.println("===================================================================================================================");
		System.out.println("Wählen Sie zwischen den Operationen 0 - 3 :");
		System.out.println("1. Ermitteln von Roots(mkdir , mkfile)");
		System.out.println("2. Alle Verzechnise und Dateien");
		System.out.println("3. JFileChooser (GUI)");
		System.out.println("0. Exit");

		int wahl = input.nextInt();
		if (wahl == 0) {
			System.exit(0);
		}
		switch (wahl) {
		case 1:
			obj6.showroots();
//			test.freespace();
//			test.totalspace();
//			test.usedspace();
//			test.output();
			obj2.createFolder();
			try {
				obj2.createFile();
			} catch (IOException e) {
				System.out.println("Datei kann nicht angelegt werden...");
				e.printStackTrace();
			}

			break;

		case 2:
			obj5.showall();
			break;

		case 3:
			obj4.startJFileChooser();
			obj4.outputfile();
			break;

		}

	}

}
