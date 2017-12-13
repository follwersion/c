package uebungen;

public class Test_02_Bier {

	public static void main(String[] args) {

		int bierAnzahl = 99;
		String wort = "Flaschen";

		while (bierAnzahl > 0) {

			if (bierAnzahl == 1) {
				wort = "Flasche"; // Singular von "Flaschen"
			}

			System.out
					.println(bierAnzahl + " " + wort + " Bier im Kühlschrank");
			System.out.println(bierAnzahl + " " + wort + " Bier");
			System.out.println("Hol eine raus.");
			System.out.println("Und lass sie rumgehen.");
			System.out.println();
			bierAnzahl = bierAnzahl - 1;
		}

		if (bierAnzahl > 0) {
			System.out
					.println(bierAnzahl + " " + wort + " Bier im Kühlschrank");
		} else {
			System.out.println("Kein Bier mehr im Kühlschrank");

		}

	}

}
