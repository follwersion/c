package dolberg_konstantin.part2;


public class TestFrame2 {

	public static void main(String[] args) throws NonExistingPropertyException2 {

	    Bestand2 bestand = new Bestand2();
	    
	    //leere liste
	    bestand.printAll();
	    //leere liste toString
	    System.out.println(bestand.toString());
	    //add
	    bestand.add(new ImmoAgrar2(new Adresse2("Sumpftorf", "Teichweg", 12), "Bauer, Bernd", 100001, 900, 20000));
	    bestand.add(new ImmoAgrar2(new Adresse2("Hattorf", "Zur saftigen Weide", 7), "Kuhhirte, Kuno", 100010, 500, 10000));
        bestand.add(new ImmoGewerbe2(new Adresse2("Smogschwer", "Stinkweg", 73), "Blei, Berta", 100100, 250, 5));
        bestand.add(new ImmoGewerbe2(new AdresseWE2("Schafferstadt", "Schufteturm", 1, 54, 22), "Knete, Karla", 100020, 220, 1));
        bestand.add(new ImmoPrivat2(new Adresse2("Sonnenstadt", "Ahornallee", 5), "Graf Glueck, Gustav", 100120, 290, 20));
        bestand.add(new ImmoPrivat2(new AdresseWE2("Unterstadt", "Kleinweg", 5, 7, 3), "Maier, Moritz", 100000, 100, 2));
        //liste print
        bestand.printAll();
        //liste size
        System.out.println("\n" + bestand.size());
        //liste clear
        bestand.clear();
        //leere liste
        bestand.printAll();
        //add
        bestand.add(new ImmoAgrar2(new Adresse2("Sumpftorf", "Teichweg", 12), "Bauer, Bernd", 100001, 900, 20000));
        bestand.add(new ImmoAgrar2(new Adresse2("Hattorf", "Zur saftigen Weide", 7), "Kuhhirte, Kuno", 100010, 500, 10000));
        bestand.add(new ImmoGewerbe2(new Adresse2("Smogschwer", "Stinkweg", 73), "Blei, Berta", 100100, 250, 5));
        bestand.add(new ImmoGewerbe2(new AdresseWE2("Schafferstadt", "Schufteturm", 1, 54, 22), "Knete, Karla", 100020, 220, 1));
        bestand.add(new ImmoPrivat2(new Adresse2("Sonnenstadt", "Ahornallee", 5), "Graf Glueck, Gustav", 100120, 290, 20));
        bestand.add(new ImmoPrivat2(new AdresseWE2("Unterstadt", "Kleinweg", 5, 7, 3), "Maier, Moritz", 100000, 100, 2));
        //toString
        System.out.println(bestand);
        //searchLoc
        System.out.println(bestand.searchLoc("Sonnenstadt"));
        //remove
        bestand.remove(new ImmoPrivat2(new AdresseWE2("Unterstadt", "Kleinweg", 5, 7, 3), "Maier, Moritz", 100000, 100, 2));
        System.out.println(bestand);
        //searchLoc "nich da"
        bestand.searchLoc("Unterstadt");

	}
}