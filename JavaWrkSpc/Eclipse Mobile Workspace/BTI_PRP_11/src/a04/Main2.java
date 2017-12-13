package a04;

import java.util.Scanner;

public class Main2 {

	/**
	 * @author bla
	 */
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Conversion convert = new Conversion();

		System.out.println("Bitte den Startwert eingeben!");
		double start = scan.nextDouble();

		if (start < 0) {
			System.out.println("Eingabe darf nicht kleiner 0 sein!\n");
			start = 0;
		}

		System.out.println("Bitte den Endwert eingeben!");
		double end = scan.nextDouble();

		if (end > 273.16 || end <= 0) {
			System.out
					.println("Eingabe darf nicht größer 273.16, und nicht kleiner gleich 0 sein!\n");
			end = 273.16;
		}

		System.out.println("Bitte die Schrittgröße eingeben!");
		double step = scan.nextDouble();

		if (step <= 0) {
			System.out.println("Eingabe darf nicht kleiner gleich 0 sein!\n");
			step = 1;
		}

		if (start == 0 && end == 273.16 && step == 1) {
			System.out
					.println("Standardwerte wurden gesetzt: \n Startwert\t=\t0 \n Endwert\t=\t273.16 \n Schrittweite\t=\t1 \n");
		}

		System.out.printf("%8s \t%8s \t%8s \t%8s\n", "Kelvin", "Celsius",
				"Reaumur", "Fahrenheit");
		System.out
				.printf("==========================================================\n");

		for (double kelvin = start; kelvin <= end; kelvin += step) {

			System.out.printf("%8.2f \t", kelvin);
			System.out.printf("%8.2f \t", convert.kelvin2Celsius(kelvin));
			System.out.printf("%8.2f \t", convert.celsius2Fahrenheit(convert.kelvin2Celsius(kelvin)));
			System.out.printf("%8.2f \t\n", convert.fahrenheit2Reaumur(convert.celsius2Fahrenheit(convert.kelvin2Celsius(kelvin))));

		}
	}

}
