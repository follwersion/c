package a06;



public class Isbn {
	
	/**
	 * @author Lukas Lukowski Konstantin Dolberg
	 * Datum 04.05.09
	 * Aufgabe 6
	 */

	static public void isbn13To10(String isbn13) {

		int[] isbn13array = new int[13];
		for (int i = 0; i < isbn13.length(); i++) {
			isbn13array[i] = Integer
					.parseInt(String.valueOf(isbn13.charAt(i)));
		}
		int prüfungsnummerisbn13 = ((10 - ((isbn13array[1] + isbn13array[3] + isbn13array[5]
				+ isbn13array[7] + isbn13array[9] + isbn13array[11] + 3 * (isbn13array[2]
				+ isbn13array[4] + isbn13array[6] + isbn13array[8] + isbn13array[10] + isbn13array[12])) % 10)) % 10);
		if (prüfungsnummerisbn13 >= 10)
			prüfungsnummerisbn13 = 0;
		isbn13array[12] = prüfungsnummerisbn13;
		int[] isbn10 = new int[10];
		for (int i = 3, j = 0; i != 12; i++, j++) {
			isbn10[j] = isbn13array[i];
		}
		int prüfungsnummern10 = (1 * isbn10[0] + 2 * isbn10[1] + 3 * isbn10[2]
				+ 4 * isbn10[3] + 5 * isbn10[4] + 6 * isbn10[5] + 7 * isbn10[6]
				+ 8 * isbn10[7] + 9 * isbn10[8]) % 11;
		if (prüfungsnummern10 >= 10)
			prüfungsnummern10 = 0;

		System.out.print("isbn 13: ");
		for (int i = 0; i != 12; i++) {
			System.out.print(isbn13array[i]);
		}
		System.out.print(prüfungsnummerisbn13);
		System.out.print("\nisbn 10: ");
		for (int i = 0; i != 9; i++) {
			System.out.print(isbn10[i]);
		}
		System.out.print(prüfungsnummern10);

		String isbndreizehn = "";
		for (int j = 0; j < isbn13array.length; j++)
			isbndreizehn += String.valueOf(isbn13array[j]);
		System.out.println("\n" + isbndreizehn);
	}

	static public void isbn10To13(String isbn10) {

		int[] isbn10array = new int[10];
		for (int i = 0; i < isbn10.length(); i++) {
			isbn10array[i] = Integer.parseInt(String.valueOf(isbn10.charAt(i)));
		}
		int prüfungsnummern10 = (1 * isbn10array[0] + 2 * isbn10array[1] + 3 * isbn10array[2]
				+ 4 * isbn10array[3] + 5 * isbn10array[4] + 6 * isbn10array[5] + 7 * isbn10array[6]
				+ 8 * isbn10array[7] + 9 * isbn10array[8]) % 11;
		if (prüfungsnummern10 >= 10)
			prüfungsnummern10 = 0;
		isbn10array[9] = prüfungsnummern10;
		int[] isbn13 = new int[14];
		isbn13[0] = 9;
		isbn13[1] = 7;
		isbn13[2] = 8;
		for (int i = 0, j = 3; i != 9; i++, j++) {
			isbn13[j] = isbn10array[i];
		}
		int prüfungsnummerisbn13 = ((10 - ((isbn13[0] + isbn13[2] + isbn13[4]
				+ isbn13[6] + isbn13[8] + isbn13[10] + 3 * (isbn13[1]
				+ isbn13[3] + isbn13[5] + isbn13[7] + isbn13[9] + isbn13[11])) % 10)) % 10);
		if (prüfungsnummerisbn13 >= 10)
			prüfungsnummerisbn13 = 0;

		System.out.print("isbn 10: ");
		for (int i = 0; i != 9; i++) {
			System.out.print(isbn10array[i]);
		}
		System.out.print(prüfungsnummern10);
		System.out.print("\nisbn 13: ");
		for (int i = 0; i != 12; i++) {
			System.out.print(isbn13[i]);
		}
		System.out.print(prüfungsnummerisbn13);

		String isbnzehn = "";
		for (int j = 0; j < isbn10array.length; j++)
			isbnzehn += String.valueOf(isbn13[j]);
		System.out.println("\n" + isbnzehn);
	}

}
