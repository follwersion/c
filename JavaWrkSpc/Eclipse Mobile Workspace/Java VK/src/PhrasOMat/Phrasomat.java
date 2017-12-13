package PhrasOMat;

public class Phrasomat {

	public static void main(String[] args) {

		// Drei Wortgruppen aus denen ausgewählt werden kann
		String[] wortListeEins = { "verlässliche", "erfolgsorientierte",
				"kundenorientierte", "clever", "webbasierte", "pfadkritische",
				"dynamische", "konkurenzfähige", "zielgerichtete" };
		String[] wortListeZwo = { "gepowerte", "haftende", "Mehrwert-",
				"zentrierte", "geclusterte", "proaktive", "Out-of-the-Box-",
				"positionierte", "vernetzte", "fokussierte", "kraftvolle",
				"geordnete", "geteilte", "kooperative", "beschleunigte",
				"Multi-Tier-", "Enterprise-", "B2B-", "Frontend-" };
		String[] wortListeDrei = { "Lösung", "Architektur", "Kernkompetenz",
				"Strategie", "Kooperation", "Ausrichtung", "Räumlichkeit",
				"Vision", "Dimension", "Mission" };
 
		// Ermitteln, wie viele Wörter sich in jeder Liste befinden
		int einsLaenge = wortListeEins.length;
		int zwoLaenge = wortListeZwo.length;
		int dreiLaenge = wortListeDrei.length;

		// Drei Zufallszahlen generieren, um die Wörter aus den Listen wählen
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