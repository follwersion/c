package uebung1;

public class ThomasAufg3bbisg {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Aufgabe 3b)

		int a = 12;
		int b = 7;
		int c = 89;
		int d = 16;

		// Aufgabe 3c)

		if (a == d) {

			System.out.println("A ist gleich D!");

		} else {

			System.out.println("A ist ungleich D!");

		}

		// Aufgabe 3d)

		int str = a;

		// Aufgabe 3e)

		int erg;

		erg = c - str;

		System.out.println(erg);

		// Aufgabe 3f)

		int erg2;
		int erg3;

		erg2 = 12 * 8;

		erg3 = c + d;

		if (erg2 == erg3) {

			System.out.println("C+D = 12 * 8");

		} else if (erg2 > erg3) {

			System.out.println("12 * 8 = " + erg2 + " ist größer als C + D!");

		} else
			System.out.println("C + D = " + erg3 + " ist größer als 12 * 8!");

		// Aufgabe 3g)

		int erg4;

		erg4 = a + b + d;

		if (c < erg4) {

			System.out.println("C (" + c + ") ist kleiner als A + B + D ("
					+ erg4 + ")!");

		} else {

			System.out.println("A + B + D (" + erg4 + ") ist kleiner als C ("
					+ c + ")!");

		}

	}
}
