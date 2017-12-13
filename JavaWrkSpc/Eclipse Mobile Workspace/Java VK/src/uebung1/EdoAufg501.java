package uebung1;

public class EdoAufg501 {

	/**
	 * Vergleicht zwei Werte miteinander
	 * 
	 * @param wert1
	 * @param wert2
	 * @return true, wenn Werte gleich sind, sonst false
	 */
	static boolean compare(double wert1, double wert2) {

		boolean result = false; // Ergebnisse können nur 2 zustände annehmen
		// (Boolean wird vordefiniert)

		if (wert1 == wert2) {

			result = true;
		}

		return result;

	}

	static double add(double wert1, double wert2) {

		double result;

		result = wert1 + wert2;

		return result;

	}

	static double sub(double wert1, double wert2) {

		double result;

		result = wert1 - wert2;

		return result;

	}

	static double mult(double wert1, double wert2) {

		double result;

		result = wert1 * wert2;

		return result;

	}

	static double div(double wert1, double wert2) {

		double result;

		result = wert1 / wert2;

		return result;

	}
	
	static double quad(double wert1, double wert2) {

		double result;

		result = Math.pow(wert1,wert2);

		return result;

	}
	
	
	public static void main(String[] args) {

		double a = 2.35; // Daten für die Rechenoperation
		double b = 2.35;
		double c = 5;
		double d = 8;

		System.out.println("Vergleiche " + a + " mit " + b + ": "
				+ compare(a, b));
		System.out.println("Vergleiche " + c + " mit " + d + ": "
				+ compare(c, d) + " \n");

		System.out.println("Addiere " + a + " mit " + b + ": " + add(a, b));
		System.out.println("Addiere " + c + " mit " + d + ": " + add(c, d)
				+ "\n");

		System.out.println("Subtrahiere " + a + " mit " + b + ": " + sub(a, b));
		System.out.println("Subtrahiere " + c + " mit " + d + ": " + sub(c, d)
				+ "\n");

		System.out.println("Multipliziere " + a + " mit " + b + ": " + mult(a, b));
		System.out.println("Multipliziere " + c + " mit " + d + ": " + mult(c, d)
				+ "\n");
		
		System.out.println("Dividiere " + a + " mit " + b + ": " + div(a, b));
		System.out.println("Dividiere " + c + " mit " + d + ": " + div(c, d)
				+ "\n");
		
		System.out.println("Quadriere " + a + " mit " + b + ": " + quad(a, b));
		System.out.println("Quadriere " + c + " mit " + d + ": " + quad(c, d)
				+ "\n");
		
	}
}
