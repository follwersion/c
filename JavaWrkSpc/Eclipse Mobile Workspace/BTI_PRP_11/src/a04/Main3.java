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

			System.out.println("Wählen Sie zwischen den Operationen 0 - 5 :");
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

					System.out.println("Bitte geben Sie die Ausgangs- Temperatureinheit ein: \n(k für Kelvin,\n c für Celsius,\n f für Fahrenheit oder\n r für Reaumur)");
					String initial = scan.next();

					System.out.println("\nBitte geben Sie den Umzurechnenden Temperaturwert als rationale Zahl ein: ");
					double value = scan.nextDouble();

					System.out.println("\nBitte geben Sie die zu berechnende Zieleinheit ein: \n(k für Kelvin,\n c für Celsius,\n f für Fahrenheit oder\n r für Reaumur)");
					String target = scan.next();

					System.out.println("\n= " + finish.degree(initial, target, value) + "\n\n");
				}

			case 2:
				
				while (true) {

					Quantity finish = new Quantity();
					
					System.out.println("");

					System.out.println("Bitte geben Sie die Ausgangs- Distanzeinheit ein: \n(km für Kilometer,\n m für Meter,\n cm für Zentimeter oder\n mm für Millimeter)");
					String initial = scan.next();

					System.out.println("\nBitte geben Sie die Umzurechnende Distanz als rationale Zahl ein: ");
					double value = scan.nextDouble();

					System.out.println("\nBitte geben Sie die zu berechnende Zieleinheit ein: \n(km für Kilometer,\n m für Meter,\n cm für Zentimeter oder\n mm für Millimeter)");
					String target = scan.next();

					System.out.println("\n= " + finish.distance(initial, target, value) + "\n\n");
				}
				
			case 3:

				while (true) {

					Quantity finish = new Quantity();
					
					System.out.println("");

					System.out.println("Bitte geben Sie die Ausgangs- Volumeneinheit ein: \n(kl für Kiloliter,\n l für Liter,\n cl für Zentiliter oder\n ml für Milliliter)");
					String initial = scan.next();

					System.out.println("\nBitte geben Sie den Umzurechnenden Volumenwert als rationale Zahl ein: ");
					double value = scan.nextDouble();

					System.out.println("\nBitte geben Sie die zu berechnende Zieleinheit ein: \n(kl für Kiloliter,\n l für Liter,\n cl für Zentiliter oder\n ml für Milliliter)");
					String target = scan.next();

					System.out.println("\n= " + finish.volume(initial, target, value) + "\n\n");
				}
				
			case 4:

				while (true) {

					Quantity finish = new Quantity();
					
					System.out.println("");

					System.out.println("Bitte geben Sie die Ausgangs- Masseneinheit ein: \n(kg für Kilogramm,\n g für Gramm,\n cg für Zentigramm oder\n mg für Milligramm)");
					String initial = scan.next();

					System.out.println("\nBitte geben Sie den Umzurechnenden Massenwert als rationale Zahl ein: ");
					double value = scan.nextDouble();

					System.out.println("\nBitte geben Sie die zu berechnende Zieleinheit ein: \n(kg für Kilogramm,\n g für Gramm,\n cg für Zentigramm oder\n mg für Milligramm)");
					String target = scan.next();

					System.out.println("\n= " + finish.mass(initial, target, value) + "\n\n");
				}
				
			case 5:
				
				while (true) {

					Quantity finish = new Quantity();
					
					System.out.println("");

					System.out.println("Bitte geben Sie die Ausgangs- Zeiteinheit ein: \n(t für Tage,\n std für Stunden,\n min für Minuten oder\n sek für Sekunden)");
					String initial = scan.next();

					System.out.println("\nBitte geben Sie den Umzurechnenden Zeitwert als rationale Zahl ein: ");
					double value = scan.nextDouble();

					System.out.println("\nBitte geben Sie die zu berechnende Zieleinheit ein: \n(t für Tage,\n std für Stunden,\n min für Minuten oder\n sek für Sekunden)");
					String target = scan.next();

					System.out.println("\n= " + finish.time(initial, target, value) + "\n\n");
				}

			}

		}
		
	}

}
