package a01;
/*
 * Team name:SingleMalt 	PR01 	Datum:26.03.09
 * Autoren: Konstantin Dolberg, Lukas Lukowski
 */
public class Fibonacci {

	public static int fibonacci(int n) {
		if (n <= 1) {
			return n;

		} else {

			int Zahl1 = 0;
			int Zahl2 = 1;
			int fn = 0;

			for (int x = 2; x <= n; x++) {

				fn = Zahl1 + Zahl2;
				Zahl1 = Zahl2;
				Zahl2 = fn;
			}
			return fn;
		}
	}
}
