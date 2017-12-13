package uebungen;

public class Bleistift_S_60 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Bleistift_S_60_Hund[] haustiere;

		haustiere = new Bleistift_S_60_Hund[7];

		haustiere[0] = new Bleistift_S_60_Hund();
		haustiere[1] = new Bleistift_S_60_Hund();

		System.out.println(haustiere[2]);

		haustiere[3] = haustiere[0];

		System.out.println(haustiere[0]);
		System.out.println(haustiere[3]);
		
		System.out.println(haustiere[6]);
	}

}
