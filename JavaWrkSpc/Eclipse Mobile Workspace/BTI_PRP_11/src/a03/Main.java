package a03;

import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Ostern rechner = new Ostern();
		Scanner sc = new Scanner(System.in);

		rechner.titel();

		for (int x = 0;; x++) {

			System.out.println("===================================================================================================================");
			System.out.println("Wählen Sie zwischen den Operationen 0 - 2 :");
			System.out.println("1. Osterjahr Berechnung");
			System.out.println("2. Oster Datum Daten von 354 bis 2009");
			System.out.println("0. Exit");

			int wahl = sc.nextInt();
			if (wahl == 0) {
				System.exit(0);
			}
			switch (wahl) {
			case 1:
				rechner.Osternberechnen();
				break;

			case 2:
				rechner.Osternschleife();
				break;

			}

		}
	}

}