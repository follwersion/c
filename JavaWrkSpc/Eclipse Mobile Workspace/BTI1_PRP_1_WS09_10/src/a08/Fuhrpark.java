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

import java.util.ArrayList;
import java.util.List;

import Skript5.String;

public class Fuhrpark {
    private  int verfügbarCounter=0; 
    List<Vehikel> fuhrpark = new ArrayList<Vehikel>();
    public void getKosten(){
        double einnahmen = 0;
        for (Vehikel element : fuhrpark) {
            if(!element.verfügbarkeit()){
                einnahmen += element.getKosten();
            }            
        }
        System.out.println("Einnahmen: " + einnahmen/100 + " Euro");
    }    
    public void warten(){
            for (Vehikel element : fuhrpark) {
                if(element.verfügbarkeit()){
                element.warten();
            } else {
                System.out.println(element.getId() + " ist nicht verfügbar, Wartung nicht möglich!");
            }
        }
    }
    public void warten(int id){
        for (Vehikel element : fuhrpark) {
            if(element.verfügbarkeit()){
                if (element instanceof Bus) {
                    Bus k =  (Bus) element;
                    if(k.getId() == id){
                        k.warten();
                    }
                }
                if (element instanceof Lkw) {
                    Lkw k = (Lkw) element;
                    if(k.getId() == id){
                        k.warten();
                    }
                }
                if (element instanceof Pkw) {
                    Pkw k = (Pkw) element;
                    if(k.getId() == id){
                        k.warten();
                    }
                }
                if (element instanceof Velo) {
                    Velo k = (Velo) element;
                    if(k.getId()==id){
                        k.warten();
                    }
                }
                if (element instanceof Mopped) {
                    Mopped k = (Mopped) element;
                    if(k.getId()==id){
                        k.warten();
                    }
                }
            } else {
                System.out.println(element.getId() + " ist nicht verfügbar, Wartung nicht möglich!");
            }
        }
    }        
    public void verfügbar() {
        for (Vehikel element : fuhrpark) {
            if (element.verfügbarkeit()) {
                verfügbarCounter++;
                System.out.println("\n " + element);
            }
        }
    }
    public void verfügbar(String s) {
        for (Vehikel element : fuhrpark) {
            if (element.getvName().equals(s) && element.verfügbarkeit()
                    ||element.getvTyp().equals(s) && element.verfügbarkeit()) {
                verfügbarCounter++;
                System.out.println("\n " + element);
            }
        }
    }
    public void verfügbar(String temp, String s) {
        if (temp == "KFZ" || temp == "*") {
            for (Vehikel element : fuhrpark) {
                if (element instanceof Kfz) {
                    Kfz k = (Kfz) element;
                    if ((k.getKraftstoff().equals(s) && k.verfügbarkeit())) {
                        verfügbarCounter++;
                        System.out.println("\n" + k);
                    }
                }
            }
        }
        if (temp == "Bus" || temp == "*") {
            for (Vehikel element : fuhrpark) {
                if (element instanceof Bus) {
                    Bus b = (Bus) element;
                    if (b.getBusTyp().equals(s) && b.verfügbarkeit() ) {
                        verfügbarCounter++;
                        System.out.println("\n" + b);
                    }
                }
            }
        }
        if ((temp == "LKW" || temp == "*")) {
            for (Vehikel element : fuhrpark) {
                if (element instanceof Lkw) {
                    Lkw l = (Lkw) element;
                    try {
                        int i = Integer.parseInt(s);
                        if (l.getZuladung() >= i && l.verfügbarkeit()) {
                            verfügbarCounter++;
                            System.out.println("\n" + l);
                        }
                    } catch (NumberFormatException nfe) {
                    }
                }
            }
        }
        if ((temp == "Motorrad" || temp == "*")) {
            for (Vehikel element : fuhrpark) {
                if (element instanceof Mopped) {
                    Mopped l = (Mopped) element;
                    try {
                        double i = Double.parseDouble(s);
                        if (l.getHubraum() >= i && l.verfügbarkeit()) {
                            verfügbarCounter++;
                            System.out.println("\n" + l);
                        }
                    } catch (NumberFormatException nfe) {
                    }
                }
            }
        }
        if (temp == "Roller") {
            for (Vehikel element : fuhrpark) {
                if (element instanceof Velo) {
                    Velo l = (Velo) element;
                    if (l.getFarbe().equals(s) && l.verfügbarkeit()||(s=="*" && l.verfügbarkeit())) {
                        verfügbarCounter++;
                        System.out.println("\n" + l);
                    }
                }
            }
        }else{
            for (Vehikel element : fuhrpark) {
                if((element.getvName().equals(temp) && element.getFarbe().equals(s) && element.verfügbarkeit())
                        || (element.getvTyp().equals(temp) && element.getFarbe().equals(s) && element.verfügbarkeit())
                        || (element.getvTyp().equals(temp) && s=="*" && element.verfügbarkeit())
                        || (temp=="*" && s=="*" && element.verfügbarkeit())
                        || (temp=="*" && s.equals(element.getFarbe()) && element.verfügbarkeit())){
                    verfügbarCounter++;
                    System.out.println(element);
                    }
                }
        }
    }
    public void verfügbar(String temp, String speed, String person) {
        if(temp=="PKW"){
            for (Vehikel element : fuhrpark) {
                if (element instanceof Pkw) {
                    Pkw l = (Pkw) element;
                    int i= Integer.parseInt(person);
                    int j = Integer.parseInt(speed);
                    if (l.getMaxSpeed()>= j && l.getPlätze()>=i && l.verfügbarkeit()) {
                        verfügbarCounter++;
                        System.out.println("\n" + l);
                    }
                }
            }
        }
    }
    public int getVerfügbarCounter() {
        return verfügbarCounter;
    }
}