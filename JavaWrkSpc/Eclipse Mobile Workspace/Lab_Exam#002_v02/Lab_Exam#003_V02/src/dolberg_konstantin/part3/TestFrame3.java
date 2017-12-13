package dolberg_konstantin.part3;

import untouchable.Immobilie_I;

public class TestFrame3 {

	public static void main(String[] args) {

	    Bestand3 bestand = new Bestand3();
	    
	    //leere liste
	    bestand.printAll();
	    //leere liste toString
	    System.out.println(bestand.toString());
	    //add
	    bestand.add(new ImmoAgrar3(new Adresse3("Sumpftorf", "Teichweg", 12), "Bauer, Bernd", 100001, 900, 20000));
	    bestand.add(new ImmoAgrar3(new Adresse3("Hattorf", "Zur saftigen Weide", 7), "Kuhhirte, Kuno", 100010, 500, 10000));
        bestand.add(new ImmoGewerbe3(new Adresse3("Smogschwer", "Stinkweg", 73), "Blei, Berta", 100100, 250, 5));
        bestand.add(new ImmoGewerbe3(new AdresseWE3("Schafferstadt", "Schufteturm", 1, 54, 22), "Knete, Karla", 100020, 220, 1));
        bestand.add(new ImmoPrivat3(new Adresse3("Sonnenstadt", "Ahornallee", 5), "Graf Glueck, Gustav", 100120, 290, 20));
        bestand.add(new ImmoPrivat3(new AdresseWE3("Unterstadt", "Kleinweg", 5, 7, 3), "Maier, Moritz", 100000, 100, 2));
        //liste print
        bestand.printAll();
        //liste size
        System.out.println("\n" + bestand.size());
        //liste clear
        bestand.clear();
        //leere liste
        bestand.printAll();
        //add
        bestand.add(new ImmoAgrar3(new Adresse3("Sumpftorf", "Teichweg", 12), "Bauer, Bernd", 100001, 900, 20000));
        bestand.add(new ImmoAgrar3(new Adresse3("Hattorf", "Zur saftigen Weide", 7), "Kuhhirte, Kuno", 100010, 500, 10000));
        bestand.add(new ImmoGewerbe3(new Adresse3("Smogschwer", "Stinkweg", 73), "Blei, Berta", 100100, 250, 5));
        bestand.add(new ImmoGewerbe3(new AdresseWE3("Schafferstadt", "Schufteturm", 1, 54, 22), "Knete, Karla", 100020, 220, 1));
        bestand.add(new ImmoPrivat3(new Adresse3("Sonnenstadt", "Ahornallee", 5), "Graf Glueck, Gustav", 100120, 290, 20));
        bestand.add(new ImmoPrivat3(new AdresseWE3("Unterstadt", "Kleinweg", 5, 7, 3), "Maier, Moritz", 100000, 100, 2));
        //toString
        System.out.println(bestand);
        //searchLoc
        System.out.println(bestand.searchLoc("Sonnenstadt"));
        //remove / exception
        try {
            bestand.remove(new ImmoPrivat3(new AdresseWE3("Unterstadt", "Kleindhfweg", 5, 7, 3), "Maier, Moritz", 100000, 100, 2));
        } catch (NonExistingPropertyException3 e) {
            System.out.println(e);
        }    
        System.out.println(bestand);
        //searchLoc "nich da"
        bestand.searchLoc("Unterstadt");
        //clear
        bestand.clear();
        //add mit status
        bestand.add(new ImmoAgrar3(new Adresse3("Sumpftorf", "Teichweg", 12), "Bauer, Bernd", 100001, 900, 20000, Status3.ANGEBOT));
        bestand.add(new ImmoAgrar3(new Adresse3("Hattorf", "Zur saftigen Weide", 7), "Kuhhirte, Kuno", 100010, 500, 10000));
        bestand.add(new ImmoGewerbe3(new Adresse3("Smogschwer", "Stinkweg", 73), "Blei, Berta", 100100, 250, 5, Status3.ANGEBOT));
        bestand.add(new ImmoGewerbe3(new AdresseWE3("Schafferstadt", "Schufteturm", 1, 54, 22), "Knete, Karla", 100020, 220, 1));
        bestand.add(new ImmoPrivat3(new Adresse3("Sonnenstadt", "Ahornallee", 5), "Graf Glueck, Gustav", 100120, 290, 20, Status3.ANGEBOT));
        bestand.add(new ImmoPrivat3(new AdresseWE3("Unterstadt", "Kleinweg", 5, 7, 3), "Maier, Moritz", 100000, 100, 2));
        //orderByPrice
        bestand.orderByPri();
        //orderByAdress
        bestand.orderByAdr();
        //orderByAdress / 2 gleiche Orte
        bestand.add(new ImmoGewerbe3(new Adresse3("Smogschwer", "Stinkkacke", 73), "Blei, Berta", 1001, 250, 5, Status3.ANGEBOT));
        bestand.orderByAdr();
        //orderByLoc2Price
        bestand.orderByLoc2Pri();
	}
}