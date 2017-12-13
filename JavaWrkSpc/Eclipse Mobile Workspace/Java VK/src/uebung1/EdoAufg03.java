package uebung1;

public class EdoAufg03 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int alter = 18;
		int grenze_1 = 16, grenze_2 = 18;
		if (alter < grenze_1)
			System.out.println("Für dich nur Wasser! ");
		else if (alter < grenze_2)
			System.out.println("Astra!");
		else
			System.out.println("Alkopops erlaubt!");
	}

}
