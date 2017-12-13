package uebung1;

public class EdoAufg12 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		double fahrenheit;

		for (double i = 0; i < 31; i = i + 1) {					// i++ = i = i + 1

			fahrenheit = (i/10) * 9 / 5 + 32;

			System.out.println((i/10) + "°C = " + fahrenheit + "°F \n");

		}

	}

}
