package uebungen;

public class Test_03_PhrasOMat {

	public static void main(String[] args) {

		String[] wortListeEins = { "verlässliche",
				"erfolgsorientierte", // Drei Wortgruppen
				"webbasierte", "allumfassende", "clevere", "kundenorientierte",
				"pfadkritische", "dynamische" };
		String[] wortListeZwei = { "gepowerte", "haftende", "Mehrwert-",
				"zentrierte", "geclusterte", "proaktive", "Out-of-the-Box",
				"positionierte", "vernetzte", "fokussierte", "kraftvolle",
				"geordnete", "geteilte", "kooperative", "beschleunigte",
				"Multi-Tier-", "Enterprise", "B2B-", "Frontend-" };
		String[] wortListeDrei = { "Schicht", "Endstufe", "Lösung",
				"Architektur", "Kernkompetenz", "Strategie", "Kooperation",
				"Ausrichtung", "Räumlichkeit", "Vision", "Dimension", "Mission" };

		int einsLänge = wortListeEins.length; // ermitteln wieviele Wörter sich
												// in der Liste befinden
		int zweiLänge = wortListeZwei.length;
		int dreiLänge = wortListeDrei.length;

		int rand1 = (int) (Math.random() * einsLänge); // drei Zufallszahlen
														// generieren, um wörter
														// aus den Listen
														// herauszuziehen & "(int)" um die nachkommastellen abzuschneiden
		int rand2 = (int) (Math.random() * zweiLänge);
		int rand3 = (int) (Math.random() * dreiLänge);

		String phrase = wortListeEins[rand1] + " " + wortListeZwei[rand2] + " " // Phrase zusammenbauen
				+ wortListeDrei[rand3];
		
		System.out.println("Was wir brauchen, ist eine " + phrase + "!");

	}
}
