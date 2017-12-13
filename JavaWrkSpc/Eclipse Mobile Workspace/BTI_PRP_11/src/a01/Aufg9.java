package a01;
/*
 * Team name:SingleMalt 	PR01 	Datum:26.03.09
 * Autoren: Konstantin Dolberg, Lukas Lukowski
 */
public class Aufg9 {
	
	public static void main(String[] args) {
		
		System.out.println("n\t|Fn\t\t|Time");

		for(int n = 0; n<47; n++){
			long ergebnis = 0;
			
			long time = System.nanoTime();
			ergebnis = Fibonacci.fibonacci(n);
			long nanosec = System.nanoTime() - (time);

			System.out.println(n + "\t" + "|" + ergebnis 
					+ "\t\t|" + nanosec + "ns");
		}

		System.out.println("Die Zahl darf nicht größer sein als 46");

	}
}
