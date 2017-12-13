package PhrasOMat;

public class Phrasomat {

	public static void main(String[] args) {

		// Drei Wortgruppen aus denen ausgew�hlt werden kann
		String[] wortListeEins = { "verl�ssliche", "erfolgsorientierte",
				"kundenorientierte", "clever", "webbasierte", "pfadkritische",
				"dynamische", "konkurenzf�hige", "zielgerichtete" };
		String[] wortListeZwo = { "gepowerte", "haftende", "Mehrwert-",
				"zentrierte", "geclusterte", "proaktive", "Out-of-the-Box-",
				"positionierte", "vernetzte", "fokussierte", "kraftvolle",
				"geordnete", "geteilte", "kooperative", "beschleunigte",
				"Multi-Tier-", "Enterprise-", "B2B-", "Frontend-" };
		String[] wortListeDrei = { "L�sung", "Architektur", "Kernkompetenz",
				"Strategie", "Kooperation", "Ausrichtung", "R�umlichkeit",
				"Vision", "Dimension", "Mission" };
 
		// Ermitteln, wie viele W�rter sich in jeder Liste befinden
		int einsLaenge = wortListeEins.length;
		int zwoLaenge = wortListeZwo.length;
		int dreiLaenge = wortListeDrei.length;

		// Drei Zufallszahlen generieren, um die W�rter aus den Listen w�hlen
		int rand1 = (int) (Math.random() * einsLaenge);
		int rand2 = (int) (Math.random() * zwoLaenge);
		int rand3 = (int) (Math.random() * dreiLaenge);

		// Eine Phrase zusammenbauen
		String phrase = wortListeEins[rand1] + " " + wortListeZwo[rand2] + " "
				+ wortListeDrei[rand3];

		// Ausgabe der Phrase
		System.out.println("Was wir brauchen, ist eine " + phrase);
	}
}