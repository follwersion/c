package a04;

import java.util.Scanner;

public class Main3 {

	/**
	 * @param args
	 */

	public static void main(String[] args) {

		Scanner scanOption = new Scanner(System.in);
		Scanner scan = new Scanner(System.in);

		for (int x = 0;; x++) {

			System.out.println("W�hlen Sie zwischen den Operationen 0 - 5 :");
			System.out.println("0. Exit");
			System.out.println("1. Temperaturumrechnung");
			System.out.println("2. Distanzumrechnung");
			System.out.println("3. Volumenumrechnung");
			System.out.println("4. Massenumrechnung");
			System.out.println("5. Zeitumrechnung");

			int choice = scanOption.nextInt();
			
			if (choice == 0) {
				System.exit(0);
			}
			
			switch (choice) {
			
			case 1:
				
				while (true) {

					Quantity finish = new Quantity();
					
					System.out.println("");

					System.out.println("Bitte geben Sie die Ausgangs- Temperatureinheit ein: \n(k f�r Kelvin,\n c f�r Celsius,\n f f�r Fahrenheit oder\n r f�r Reaumur)");
					String initial = scan.next();

					System.out.println("\nBitte geben Sie den Umzurechnenden Temperaturwert als rationale Zahl ein: ");
					double value = scan.nextDouble();

					System.out.println("\nBitte geben Sie die zu berechnende Zieleinheit ein: \n(k f�r Kelvin,\n c f�r Celsius,\n f f�r Fahrenheit oder\n r f�r Reaumur)");
					String target = scan.next();

					System.out.println("\n= " + finish.degree(initial, target, value) + "\n\n");
				}

			case 2:
				
				while (true) {

					Quantity finish = new Quantity();
					
					System.out.println("");

					System.out.println("Bitte geben Sie die Ausgangs- Distanzeinheit ein: \n(km f�r Kilometer,\n m f�r Meter,\n cm f�r Zentimeter oder\n mm f�r Millimeter)");
					String initial = scan.next();

					System.out.println("\nBitte geben Sie die Umzurechnende Distanz als rationale Zahl ein: ");
					double value = scan.nextDouble();

					System.out.println("\nBitte geben Sie die zu berechnende Zieleinheit ein: \n(km f�r Kilometer,\n m f�r Meter,\n cm f�r Zentimeter oder\n mm f�r Millimeter)");
					String target = scan.next();

					System.out.println("\n= " + finish.distance(initial, target, value) + "\n\n");
				}
				
			case 3:

				while (true) {

					Quantity finish = new Quantity();
					
					System.out.println("");

					System.out.println("Bitte geben Sie die Ausgangs- Volumeneinheit ein: \n(kl f�r Kiloliter,\n l f�r Liter,\n cl f�r Zentiliter oder\n ml f�r Milliliter)");
					String initial = scan.next();

					System.out.println("\nBitte geben Sie den Umzurechnenden Volumenwert als rationale Zahl ein: ");
					double value = scan.nextDouble();

					System.out.println("\nBitte geben Sie die zu berechnende Zieleinheit ein: \n(kl f�r Kiloliter,\n l f�r Liter,\n cl f�r Zentiliter oder\n ml f�r Milliliter)");
					String target = scan.next();

					System.out.println("\n= " + finish.volume(initial, target, value) + "\n\n");
				}
				
			case 4:

				while (true) {

					Quantity finish = new Quantity();
					
					System.out.println("");

					System.out.println("Bitte geben Sie die Ausgangs- Masseneinheit ein: \n(kg f�r Kilogramm,\n g f�r Gramm,\n cg f�r Zentigramm oder\n mg f�r Milligramm)");
					String initial = scan.next();

					System.out.println("\nBitte geben Sie den Umzurechnenden Massenwert als rationale Zahl ein: ");
					double value = scan.nextDouble();

					System.out.println("\nBitte geben Sie die zu berechnende Zieleinheit ein: \n(kg f�r Kilogramm,\n g f�r Gramm,\n cg f�r Zentigramm oder\n mg f�r Milligramm)");
					String target = scan.next();

					System.out.println("\n= " + finish.mass(initial, target, value) + "\n\n");
				}
				
			case 5:
				
				while (true) {

					Quantity finish = new Quantity();
					
					System.out.println("");

					System.out.println("Bitte geben Sie die Ausgangs- Zeiteinheit ein: \n(t f�r Tage,\n std f�r Stunden,\n min f�r Minuten oder\n sek f�r Sekunden)");
					String initial = scan.next();

					System.out.println("\nBitte geben Sie den Umzurechnenden Zeitwert als rationale Zahl ein: ");
					double value = scan.nextDouble();

					System.out.println("\nBitte geben Sie die zu berechnende Zieleinheit ein: \n(t f�r Tage,\n std f�r Stunden,\n min f�r Minuten oder\n sek f�r Sekunden)");
					String target = scan.next();

					System.out.println("\n= " + finish.time(initial, target, value) + "\n\n");
				}

			}

		}
		
	}

}
