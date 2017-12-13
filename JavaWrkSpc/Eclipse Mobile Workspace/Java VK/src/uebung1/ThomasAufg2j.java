package uebung1;

public class ThomasAufg2j {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int zahl1 = 987398;
		int zahl2 = 1827298;
		int zahl3 = 10002830;

		if (zahl1 < zahl2 && zahl1 < zahl3) {

			System.out.println("...Zahl1 ist die kleinste!");

		} else if (zahl2 < zahl1 && zahl2 < zahl3) {

			System.out.println("...Zahl2 ist die kleinste!");

		} else if (zahl3 < zahl1 && zahl3 < zahl2) {

			System.out.println("...Zahl3 ist die kleinste!");

		}

	}

}
