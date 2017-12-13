package a12;

import java.io.Serializable;
import java.util.ArrayList;



public class Kunde implements Serializable {

	/**
	 * @Teamname SingleMalt
	 * @author Lukas Lukowski
	 */
	
	private static final long serialVersionUID = 7691306549076797182L;
	private int kundennummer = 0;
	private String name = null;
	private String nachname = null;
	private String firmenname = null;
	private String ort = null;
	private String plz = null;
	private String street = null;
	private int hausnummer = 0;
	private String bankname = null;
	private int blz = 0;
	private int kontonummer = 0;
	ArrayList<Auftrag> auftragliste ;
	
	

	public Kunde(String name, String nachname, String firmenname, String ort,
			String plz, String street, int hausnummer, String bankname, int blz,
			int kontonummer, int knummer, ArrayList<Auftrag> auftragliste) {
		


		this.name = name;
		this.nachname = nachname;
		this.firmenname = firmenname;
		this.ort = ort;
		this.plz = plz;
		this.street = street;
		this.hausnummer=hausnummer;
		this.bankname = bankname;
		this.blz = blz;
		this.kontonummer = kontonummer;
		this.kundennummer = knummer;
		this.auftragliste = auftragliste;
	}

	public int getKundennummer() {
		return kundennummer;
	}

	public void setKundennummer(int kundennummer) {
		this.kundennummer = kundennummer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getFirmenname() {
		return firmenname;
	}

	public void setFirmenname(String firmenname) {
		this.firmenname = firmenname;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public int getBlz() {
		return blz;
	}

	public void setBlz(int blz) {
		this.blz = blz;
	}

	public int getKontonummer() {
		return kontonummer;
	}

	public void setKontonummer(int kontonummer) {
		this.kontonummer = kontonummer;
	}

	public void setHausnummer(int hausnummer) {
		this.hausnummer = hausnummer;
	}

	public int getHausnummer() {
		return hausnummer;
	}


}
