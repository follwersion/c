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
 *                      URL: http://java.sun.com/javase/6/docs/api/java/lang/Exception.html
 */
package a08;

import Skript5.String;

public class Velo extends Vehikel {

    public Velo(String vTyp, String vName, String farbe, boolean zustand, boolean verfügbarkeit) throws Exception {
        super(vTyp, vName, farbe, zustand, verfügbarkeit);
        
        if (vTyp == "Fahrrad") {
            setKosten(100);
            setvTyp("Fahrrad");
        } else if (vTyp == "Roller") {
            if (farbe == "Rot") {
                setKosten(11);
            } else if (farbe == "Grün") {
                setKosten(15);
            } else if (farbe == "Gelb") {
                setKosten(99);
            } else if (farbe == "Blau") {
                setKosten(17);
            } else {
                setKosten(1);
            }
            setvTyp("Roller");
        } else if (vTyp == "Dreirad") {
            setKosten(13);
            setvTyp("Dreirad");
        }
        if(vTyp != "Fahrrad" && vTyp != "Roller" && vTyp != "Dreirad"){
           throw new Exception("Typ wird nicht als Velo akzeptiert");
        }        
    }
    public void warten() {
     System.out.println("Velo warten.. Id:"+getId());
     setZustand(true);
    }  
    public String toString() {
            return super.toString()+"\n" + "\n";
    }
}