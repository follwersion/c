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

public class A08 {

    public static void main(String[] args) throws Exception {
        
        Fuhrpark f = new Fuhrpark();
        f.fuhrpark.add(new Lkw("MAN","Weiss",false,true,"Benzin",12));
        f.fuhrpark.add(new Lkw("MAN","Rot",true,true,"Diesel",30));
        f.fuhrpark.add(new Lkw("Volvo","Braun",true,false,"Benzin",30));
        f.fuhrpark.add(new Lkw("Iveco","Weiss",true,true,"Diesel",40));
        f.fuhrpark.add(new Lkw("Iveco","Weiss",true,false,"Diesel",20));
        
        f.fuhrpark.add(new Bus("Volvo","Blau",  true, true, "Diesel", 55, "Panorama"));
        f.fuhrpark.add(new Bus("Mercedes","Gr�n",  false, false, "Diesel", 55, "Panorama"));
        f.fuhrpark.add(new Bus("MAN","Weiss",  true, true, "Elektro", 55, "Gelenk"));
        f.fuhrpark.add(new Bus("Volvo","Braun", true, false, "Wasserstoff", 55, "Panorama"));
        f.fuhrpark.add(new Bus("Iveco","Silber", false, true, "Elektro", 55, "Doppeldecker"));
        
        f.fuhrpark.add(new Mopped("Kawasaki","Rot",true,true,"Benzin",25.5));
        f.fuhrpark.add(new Mopped("Honda","Silber",true,false,"Super",300));
        f.fuhrpark.add(new Mopped("BMW","Gr�n",true,true,"Super",300));
        f.fuhrpark.add(new Mopped("Yamaha","Schwarz",false,true,"Super",400));
        f.fuhrpark.add(new Mopped("Yamaha","Silber",true,true,"Super",200));
        
        f.fuhrpark.add(new Pkw("Golf","Silber",true,true,"Diesel",260,5));
        f.fuhrpark.add(new Pkw("Golf","Rot",false,true,"Diesel",160,5));
        f.fuhrpark.add(new Pkw("Opel","Rot",true,true,"Diesel",160,5));
        f.fuhrpark.add(new Pkw("Opel#############################################","Blau",false,false,"Super",240,5));
        f.fuhrpark.add(new Pkw("Ghia","Blau",false,true,"Benzin",150,2));
        f.fuhrpark.add(new Pkw("Z3","Blau",false,true,"Super",250,2));
        f.fuhrpark.add(new Pkw("Volvo","Silber",true,true,"Super",180,5));
        
        f.fuhrpark.add(new Velo("Roller","Speedy","Rot",true,false));
        f.fuhrpark.add(new Velo("Roller","Jumper","Gr�n",false,true));
        f.fuhrpark.add(new Velo("Dreirad","Deluxe","Gr�n",false,true));
        f.fuhrpark.add(new Velo("Fahrrad","Mountain Speed","Gr�n",true,false));
        f.fuhrpark.add(new Velo("Fahrrad","City Cruiser","Silber",true,false));
        

        
//        System.out.println("-------f.verf�gbar()--------------");
//        f.verf�gbar();
        System.out.println("-------f.verf�gbar(PKW)--------------");
        f.verf�gbar("PKW");
        
        System.out.println("--------------------------------------");
          f.warten(); 
          System.out.println("--------------------------------------");
          f.verf�gbar("PKW");
//        System.out.println("-------f.verf�gbar(KFZ,Diesel)--------------");
//        f.verf�gbar("KFZ", "Diesel");
//        System.out.println("-------f.verf�gbar(Bus,Gelenk)--------------");
//        f.verf�gbar("Bus", "Gelenk");
//        System.out.println("-------f.verf�gbar(Motorrad,Hubraum)--------------");
//        f.verf�gbar("Motorrad", "15");
        System.out.println("---------f.verf�gbar(PKW,Speed,Pl�tze)------------");
        f.verf�gbar("PKW", "170", "4");
//        System.out.println("-------f.verf�gbar(Name,Farbe)--------------");
//        f.verf�gbar("Golf", "Silber");
//        System.out.println("-------f.verf�gbar(*,Farbe)--------------");
//        f.verf�gbar("*", "Silber");
//        System.out.println("-------f.verf�gbar(*,*)--------------");
//        f.verf�gbar("*", "*");
//        System.out.println("---------------------");
//        f.warten();
//        System.out.println("---------------------");
        f.getKosten();
    }
}