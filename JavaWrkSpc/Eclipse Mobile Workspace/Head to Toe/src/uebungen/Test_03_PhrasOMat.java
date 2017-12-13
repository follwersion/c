package uebungen;

public class Test_03_PhrasOMat {

	public static void main(String[] args) {

		String[] wortListeEins = { "verl�ssliche",
				"erfolgsorientierte", // Drei Wortgruppen
				"webbasierte", "allumfassende", "clevere", "kundenorientierte",
				"pfadkritische", "dynamische" };
		String[] wortListeZwei = { "gepowerte", "haftende", "Mehrwert-",
				"zentrierte", "geclusterte", "proaktive", "Out-of-the-Box",
				"positionierte", "vernetzte", "fokussierte", "kraftvolle",
				"geordnete", "geteilte", "kooperative", "beschleunigte",
				"Multi-Tier-", "Enterprise", "B2B-", "Frontend-" };
		String[] wortListeDrei = { "Schicht", "Endstufe", "L�sung",
				"Architektur", "Kernkompetenz", "Strategie", "Kooperation",
				"Ausrichtung", "R�umlichkeit", "Vision", "Dimension", "Mission" };

		int einsL�nge = wortListeEins.length; // ermitteln wieviele W�rter sich
												// in der Liste befinden
		int zweiL�nge = wortListeZwei.length;
		int dreiL�nge = wortListeDrei.length;

		int rand1 = (int) (Math.random() * einsL�nge); // drei Zufallszahlen
														// generieren, um w�rter
														// aus den Listen
														// herauszuziehen & "(int)" um die nachkommastellen abzuschneiden
		int rand2 = (int) (Math.random() * zweiL�nge);
		int rand3 = (int) (Math.random() * dreiL�nge);

		String phrase = wortListeEins[rand1] + " " + wortListeZwei[rand2] + " " // Phrase zusammenbauen
				+ wortListeDrei[rand3];
		
		System.out.println("Was wir brauchen, ist eine " + phrase + "!");

	}
}
