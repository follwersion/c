package a01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * Team name:SingleMalt 	PR01 	Datum:26.03.09
 * Autoren: Konstantin Dolberg, Lukas Lukowski
 */
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.println("Bitte natürliche Zahl eingeben : ");
			int n = Integer.parseInt(input.readLine());
			
			if (n > 46)
				System.out.println(" -Die Zahl darf nicht größer sein als 46- ");
			
			long time = System.nanoTime();
			System.out.println("Fibonacci von n : " + n + " = "	+ Fibonacci.fibonacci(n) + "  - Zeit der Berechnung in Nanosekunden: " + (System.nanoTime()-time) + "\n");
		}
	}

}
