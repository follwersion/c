package a02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 06.04.09
 * Teamname: SingleMalt
 * @author Konstantin Dolberg
 * @author Lukas Lukowski
 */

public class Main {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(
				System.in));
		while (true) {

			System.out
					.println("\nGeben Sie bitte eine ganze Zahl f�r den Exponent (2^k) ein: ");

			int k = Integer.parseInt(input.readLine());

			Struktur2 Variante_2 = new Struktur2(k);

			System.out.println("0 => bedeutet keinen Ergebnis");

			System.out.println("\nLinke Nachfolger");
			System.out.println("=======================================");
			for (int i = 1; i < Variante_2.array.length; i++) {

				System.out.println("Der Linke Nachfolger von " + i + " ist: "
						+ Variante_2.getLinkenNachfolger(i));
			}

			System.out.println("\nRechte Nachfolger");
			System.out.println("=======================================");
			for (int i = 1; i < Variante_2.array.length; i++) {

				System.out.println("Der Rechte Nachfolger von " + i + " ist: "
						+ Variante_2.getRechtenNachfolger(i));
			}

			System.out.println("\nVorgaenger");
			System.out.println("=======================================-");
			for (int i = 1; i < Variante_2.array.length; i++) {

				System.out.println("Der Vorgnger von " + i + " ist: "
						+ Variante_2.getVorgaenger(i));
			}

			System.out.println("\nNachbar");
			System.out.println("=======================================");
			for (int i = 1; i < Variante_2.array.length; i++) {
				System.out.println("Der Nachbar von " + i + " ist: "
						+ Variante_2.getNachbar(i));

			}
			System.out.print("\ninorder");

			Variante_2.inorder((int) Math.pow(2, k - 1));

			System.out.print("\npreorder");

			Variante_2.preorder((int) Math.pow(2, k - 1));

			System.out.print("\npostorder");

			Variante_2.postorder((int) Math.pow(2, k - 1));

		}
	}
}
