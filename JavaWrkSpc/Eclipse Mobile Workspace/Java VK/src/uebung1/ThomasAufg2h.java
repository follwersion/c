package uebung1;

public class ThomasAufg2h {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int zahl1 = 1762817;
		int zahl2 = 27364876;
		int zahl3 = 23487248;
		int zahl4 = 127187;

		if (zahl1 > zahl2 && zahl1 > zahl3 && zahl1 > zahl4) {

			System.out.println("...zahl1 ist die größte");

		} else if (zahl2 > zahl1 && zahl2 > zahl3 && zahl2 > zahl4) {

			System.out.println("...Zahl2 ist die größte!");

		} else if (zahl3 > zahl1 && zahl3 > zahl2 && zahl3 > zahl4) {

			System.out.println("...Zahl3 ist die größte!");

		} else if (zahl4 > zahl1 && zahl4 > zahl2 && zahl4 > zahl3) {

			System.out.println("...Zahl4 ist die größte!");

		}

	}

}
