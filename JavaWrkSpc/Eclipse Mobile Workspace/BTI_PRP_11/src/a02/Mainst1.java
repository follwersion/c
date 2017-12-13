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

public class Mainst1 {

	
	public static void Main(String[] args) {
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(
				System.in));
		while (true) {

			System.out
					.println("\nGeben Sie bitte eine ganze Zahl f�r den Exponent (2^k) ein: ");

			int k = Integer.parseInt(input.readLine());
			System.out.println("0 => bedeutet keinen Ergebnis");

			Struktur1 Variante_1 = new Struktur1(k);
			System.out.println("\nLinker Nachfolger");
			System.out.println("=======================================");
			for (int i = 1; i < Variante_1.array.length; i++) {

				System.out.println("Der Linke Nachfolger von " + i + " ist: "
						+ Variante_1.getLinkenNachfolger(i));
			}
			System.out.println("\nRechter Nachfolger");
			System.out.println("=======================================");
			for (int i = 1; i < Variante_1.array.length; i++) {
				System.out.println("Der Rechte Nachfolger von " + i + " ist: "
						+ Variante_1.getRechtenNachfolger(i));
			}
			System.out.println("\nVorgaenger");
			System.out.println("=======================================");
			for (int i = 1; i < Variante_1.array.length; i++) {

				System.out.println("Der Vorgaenger von " + i + " ist: "
						+ Variante_1.getVorgaenger(i));
			}
			System.out.println("\nNachbar");
			System.out.println("=======================================");
			for (int i = 1; i < Variante_1.array.length; i++) {
				System.out.println("Der Nachbar von " + i + " ist: "
						+ Variante_1.getNachbar(i));

			}
			System.out.print("\ninorder");

			Variante_1.inorder((int) 1);

			System.out.print("\npreorder");

			Variante_1.preorder((int) 1);

			System.out.print("\npostorder");

			Variante_1.postorder((int) 1);

		}
	}
}
