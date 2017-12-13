/*
 * Praktikum:           P1P 
 * Semester:            WS09
 * Team-Name:           S3T4
 * Namen:               Dolberg, Konstantin     #1959949
 *                      Eisenbraun, Alexander   #1965085
 * Aufgaben-Nr.:        A08
 * Kontrolleur:     
 * Datum der Abnahme:   03.12.2009
 * Quellen:             URL: https://pub.informatik.haw-hamburg.de/home/pub/prof/schafers/S09W_P1/Aufgabenzettel_Nr4_v08.pdf
 */
package a08;

public abstract class Vehikel {
    static int vCount =0;
    
    private String vTyp;
    private String vName;
    private String farbe;
    private int id;
    private double kosten;
    private boolean zustand;
    private boolean verfügbarkeit;
    
    public Vehikel(String vTyp, String vName, String farbe,  boolean zustand, boolean verfügbarkeit) {
     this.vTyp = vTyp;
     this.vName = vName;
     this.farbe = farbe;
     vCount++;
     this.id = vCount;
     this.zustand = zustand;
     this.verfügbarkeit = verfügbarkeit;
    }    
    public void setvTyp(String vTyp) {
        this.vTyp = vTyp;
    }
    public void setvName(String vName) {
        this.vName = vName;
    }
    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setKosten(double kosten) {
        this.kosten = kosten;
    }
    public void setZustand(boolean zustand) {
        this.zustand = zustand;
    }
    public void setVerfügbarkeit(boolean verfügbarkeit) {
        this.verfügbarkeit = verfügbarkeit;
    }
//-----------------------------------------------------------------
    public String getvTyp() {
        return vTyp;
    }
    public String getvName() {
        return vName;
    }
    public String getFarbe() {
        return farbe;
    }
    public int getId() {
        return id;
    }
    public double getKosten() {
        return kosten;
    }
    public boolean verfügbarkeit() {
        return verfügbarkeit;
    }
    public boolean zustand() {
        return zustand;
    }
    public void warten(){
    }    
    public String toString() {
        return String.format("Vehikel: \nFarbe: %s, \nId: %s, \nKosten: %s, \nName: %s, \nTyp: %s, \nVerfügbarkeit: %s, \nZustand: %s", getFarbe(),
                getId(), getKosten(), getvName(), getvTyp(), verfügbarkeit(), zustand());
    }
}