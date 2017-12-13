package dolberg_konstantin.part1;


public class TestFrame1 {

	public static void main(String[] args) {

	    Bestand1 bestand = new Bestand1();
	    
	    //leere liste
	    bestand.printAll();
	    //leere liste toString
	    System.out.println(bestand.toString());
	    //add
	    bestand.add(new ImmoAgrar1(new Adresse1("Sumpftorf", "Teichweg", 12), "Bauer, Bernd", 100001, 900, 20000));
	    bestand.add(new ImmoAgrar1(new Adresse1("Hattorf", "Zur saftigen Weide", 7), "Kuhhirte, Kuno", 100010, 500, 10000));
        bestand.add(new ImmoGewerbe1(new Adresse1("Smogschwer", "Stinkweg", 73), "Blei, Berta", 100100, 250, 5));
        bestand.add(new ImmoGewerbe1(new AdresseWE1("Schafferstadt", "Schufteturm", 1, 54, 22), "Knete, Karla", 100020, 220, 1));
        bestand.add(new ImmoPrivat1(new Adresse1("Sonnenstadt", "Ahornallee", 5), "Graf Glueck, Gustav", 100120, 290, 20));
        bestand.add(new ImmoPrivat1(new AdresseWE1("Unterstadt", "Kleinweg", 5, 7, 3), "Maier, Moritz", 100000, 100, 2));
        //liste print
        bestand.printAll();
        //liste size
        System.out.println("\n" + bestand.size());
        //liste clear
        bestand.clear();
        //leere liste
        bestand.printAll();
        //add
        bestand.add(new ImmoAgrar1(new Adresse1("Sumpftorf", "Teichweg", 12), "Bauer, Bernd", 100001, 900, 20000));
        bestand.add(new ImmoAgrar1(new Adresse1("Hattorf", "Zur saftigen Weide", 7), "Kuhhirte, Kuno", 100010, 500, 10000));
        bestand.add(new ImmoGewerbe1(new Adresse1("Smogschwer", "Stinkweg", 73), "Blei, Berta", 100100, 250, 5));
        bestand.add(new ImmoGewerbe1(new AdresseWE1("Schafferstadt", "Schufteturm", 1, 54, 22), "Knete, Karla", 100020, 220, 1));
        bestand.add(new ImmoPrivat1(new Adresse1("Sonnenstadt", "Ahornallee", 5), "Graf Glueck, Gustav", 100120, 290, 20));
        bestand.add(new ImmoPrivat1(new AdresseWE1("Unterstadt", "Kleinweg", 5, 7, 3), "Maier, Moritz", 100000, 100, 2));
        //toString
        System.out.println(bestand);

	}

}
