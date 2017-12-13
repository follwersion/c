package a12;

import java.io.Serializable;


public class Artikel implements Serializable{

	/**
	 * @Teamname SingleMalt
	 * 
	 */
	private static final long serialVersionUID = -552462437550749354L;
	private String bezeichnung;
	private	float preis;
	private int menge;
	
	public Artikel(String bezeichnung, float preis,int menge) {
		this.bezeichnung = bezeichnung;
		this.preis = preis;
		this.menge = menge ;
	
		
		
	
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public float getPreis() {
		return preis;
	}

	public void setPreis(float preis) {
		this.preis = preis;
	}
	public int getMenge() {
		return menge;
	}

	public void setMenge(int menge) {
		this.menge = menge;
	}
	
	
}
	
	

