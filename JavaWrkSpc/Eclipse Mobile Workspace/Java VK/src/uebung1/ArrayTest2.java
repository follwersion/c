package uebung1;

public class ArrayTest2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int erg = 0;
		int array[] = new int[10];

		array[0] = 2;
		array[1] = 8;
		array[2] = 4;
		array[3] = 6;
		array[4] = 9;
		array[5] = -36;
		array[6] = 34;
		array[7] = 85;
		array[8] = 24;
		array[9] = -9;

		for (int counter = 0; counter < 10; counter++) {

			erg = erg + array[counter];
		}

		System.out.println("Summe aller speicher = " + erg);

	}

}
