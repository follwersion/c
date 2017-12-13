package uebung1;

public class ThomasAufg2i {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int zahl1 = 27681;
		int zahl2 = 27632;
		int zahl3 = 27698;

		if (zahl1 < zahl2 && zahl1 < zahl3) {

			System.out.println("...Zahl1 ist die kleinste!");

		} else if (zahl2 < zahl1 && zahl2 < zahl3) {

			System.out.println("...Zahl2 ist die kleinste!");

		} else if (zahl3 < zahl1 && zahl3 < zahl2) {

			System.out.println("...Zahl3 ist die kleinste!");

		}

	}

}
