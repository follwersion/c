package a12;

import java.util.ArrayList;

/**
 * @Teamname SingleMalt
 * 
 */

public class ObjectCreater {
	
	ArrayList<Kunde> kundeliste = new ArrayList<Kunde>();

	
	public ArrayList<Kunde> returnKundelist(){
		
		return kundeliste;
	}
	public void createKunde(ArrayList<Auftrag> auftragliste ){
		
			Kunde kunde1 = new Kunde("Lukas", "Lukowski", "LukSoft", "Hamburg", "21031",
				"Bockhorsterhöhe", 200, "Postbank", 200000, 1420000, 1,
				auftragliste);
			
			Kunde kunde2 = new Kunde("Peter", "Mustermann", "MusterSoft", "Musterstatd", "21031",
					"Musterstraße", 200, "Postbank", 200000, 1420000, 1,
					auftragliste);
			
			
			for(int i=0;i<kundeliste.size();i++){
			if (this.kundeliste.get(i).auftragliste.isEmpty()){
				auftragliste.add(new Auftrag("defaul","default","default",0,null,0));
			}}
			kundeliste.add(kunde1);
			kundeliste.add(kunde2);
		
	}
	public void calc (){
	float summe;
		int menge = kundeliste.get(0).auftragliste.get(0).artikelListe.get(0).getMenge();
			float preis =	kundeliste.get(0).auftragliste.get(0).artikelListe.get(0).getPreis();
			summe = menge*preis;
			menge = kundeliste.get(0).auftragliste.get(0).artikelListe.get(1).getMenge();
			preis =	kundeliste.get(0).auftragliste.get(0).artikelListe.get(1).getPreis();
			float summe2 =menge*preis;
			float sum=summe + summe2;
				kundeliste.get(0).auftragliste.get(0).setSumme(sum);
				
		}
	
	public ArrayList<Auftrag> createAuftrag(ArrayList<Artikel> artikelliste){
		
		ArrayList<Auftrag> auftragliste = new ArrayList<Auftrag>();
		Auftrag auftrag1 = new Auftrag("18.June.2009", "18.June.2009",
				"18.June.2009", 1, artikelliste, 0);
		Auftrag auftrag2 = new Auftrag("18.September.2009", "18.September.2009",
				"18.September.2009", 1, artikelliste, 0);
		
		
		
		
		if (artikelliste.isEmpty())
		{
			artikelliste.add((new Artikel("default",0,0)));
		}
		auftragliste.add(auftrag1);
		auftragliste.add(auftrag2);
		return auftragliste;
	}
	
	public ArrayList<Artikel> createArtikel(){
		ArrayList<Artikel> artikelliste = new ArrayList<Artikel>();
		Artikel artikel1 = new Artikel("Playstation3", 399, 1);
		Artikel artikel2 = new Artikel("PES2010", 50, 1);
		artikelliste.add(artikel1);
		artikelliste.add(artikel2);
		
		return artikelliste;
	}
	

}
	