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

public class Bus extends Kfz {
    private int sitzpl�tze;
    private String busTyp;
    private static final String vTyp = "Bus";
    
    public Bus( String vName, String farbe, boolean zustand, boolean verf�gbarkeit, String kraftstoff, int sitzpl�tze, String busTyp) {
        super(vTyp, vName, farbe, zustand, verf�gbarkeit, kraftstoff);
        this.sitzpl�tze = sitzpl�tze;
        this.busTyp = busTyp;
        double kosten;
        kosten =busTyp.equals("Normal")? 10000 : 12500;
        setKosten(kosten);
    }
    public void setSitzpl�tze(int sitzpl�tze) {
        this.sitzpl�tze = sitzpl�tze;
    }
    public void setBusTyp(String busTyp) {
        this.busTyp = busTyp;
    }
    public int getSitzpl�tze() {
        return sitzpl�tze;
    }
    public String getBusTyp() {
        return busTyp;
    }
    public void warten() {
        System.out.println("Bus (#" + getId() + ") wurde gewartet");
        setZustand(true);
    }
    public String toString() {
        return super.toString() + String.format("\nBustyp: %s,\nPl�tze: %s\n", getBusTyp(), getSitzpl�tze() + "\n");
    }
    public static String getVtyp() {
        return vTyp;
    }
}