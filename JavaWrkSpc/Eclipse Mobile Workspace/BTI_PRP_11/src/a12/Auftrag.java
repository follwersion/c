package a12;

import java.io.Serializable;
import java.util.ArrayList;


public class Auftrag implements Serializable {

	/**
	 * @Teamname SingleMalt
	 * 
	 */
	
	private static final long serialVersionUID = -4908777672929796112L;

private int auftragnummer;
	
	private String erteilungsdatum ;
	private String lieferdatum ;
	private String rechnungsdatum;
	private float summe;
	public float getSumme() {
		return summe;
	}
	public void setSumme(float summe) {
		this.summe = summe;
	}
	ArrayList<Artikel> artikelListe ;
	public Auftrag(String erteilungsdatum, String lieferdatum,
			String rechnungsdatum, int auftragnummer,ArrayList<Artikel>artikelListe,int summe) {
		
//		if (artikelListe.isEmpty()){
//			artikelListe.add(new Artikel("default",0,0));
//		}
		
		
		this.erteilungsdatum = erteilungsdatum;
		this.lieferdatum = lieferdatum;
		this.rechnungsdatum = rechnungsdatum;
		this.auftragnummer = auftragnummer;
		this.artikelListe = artikelListe;
		this.summe = summe;
	}
		

	public String getErteilungsdatum() {
		return erteilungsdatum;
	}
	public void setErteilungsdatum(String erteilungsdatum) {
		this.erteilungsdatum = erteilungsdatum;
	}
	public String getLieferdatum() {
		return lieferdatum;
	}
	public void setLieferdatum(String lieferdatum) {
		this.lieferdatum = lieferdatum;
	}
	public String getRechnungsdatum() {
		return rechnungsdatum;
	}
	public void setRechnungsdatum(String rechnungsdatum) {
		this.rechnungsdatum = rechnungsdatum;
	}
	public void setAuftragnummer(int auftragnummer) {
		this.auftragnummer = auftragnummer;
	}
	public int getAuftragnummer() {
		return auftragnummer;
	}
}
