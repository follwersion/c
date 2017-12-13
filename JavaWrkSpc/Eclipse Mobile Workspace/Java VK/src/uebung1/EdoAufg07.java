package uebung1;

import java.util.*;

public class EdoAufg07 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int eingabe = 1;
		
		while (eingabe > 0 || eingabe < 0) {
			System.out.println("Zahl eingeben: ");
			eingabe = sc.nextInt();					// sc.nextInt Tastaturabfrage nach Zahlen
		}
		
		System.out.println("und tschüß");

	}

}
