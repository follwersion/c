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

import Skript5.String;

public class Pkw extends Kfz {
    private int maxSpeed;
    private int plätze;
    private static final String vTyp = "PKW";

    public Pkw( String vName, String farbe, boolean zustand, boolean verfügbarkeit, String kraftstoff, int maxSpeed, int plätze) {
        super(vTyp, vName, farbe, zustand, verfügbarkeit, kraftstoff);
        this.maxSpeed = maxSpeed;
        this.plätze = plätze;
        double kosten ;
        kosten = maxSpeed < 100? 1000f: maxSpeed>=100 && maxSpeed<150? 1500: maxSpeed>=150 && maxSpeed<200? 2500:5000;
        kosten += plätze*2;
        setKosten(kosten);
    }
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
    public void setPlätze(int plätze) {
        this.plätze = plätze;
    }
    public int getMaxSpeed() {
        return maxSpeed;
    }
    public int getPlätze() {
        return plätze;
    }
    public void warten() {
        System.out.println("Pkw (#" + getId()+ ") wurde gewartet");
        setZustand(true);
    }
    public String toString() {
        return super.toString() + String.format("\nMaxSpeed: %s,\nPlätze: %s\n", getMaxSpeed(), getPlätze() + "\n");
    }
    public static String getVtyp() {
        return vTyp;
    }
}