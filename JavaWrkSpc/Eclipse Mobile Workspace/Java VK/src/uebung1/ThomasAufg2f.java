package uebung1;

public class ThomasAufg2f {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int zahl1 = 27313;
		int zahl2 = 27362;
		int zahl3 = 12376;

		if (zahl1 > zahl2 && zahl1 > zahl3) {

			System.out.println("...Zahl1 ist die Allergrößte!");

		} else if (zahl2 > zahl1 && zahl1 > zahl3) {

			System.out.println("...Zahl2 ist die Allergrößte!");

		} else if (zahl3 > zahl1 && zahl3 > zahl2) {

			System.out.println("...Zahl3 ist die Allergrößte!");

		}

	}

}
