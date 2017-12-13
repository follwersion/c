/*
 * Praktikum:           P1P 
 * Semester:            WS09
 * Team-Name:           S3T4
 * Namen:               Dolberg, Konstantin     #1959949
 *                      Eisenbraun, Alexander   #1965085
 * Aufgaben-Nr.:        B2
 * Kontrolleur:     
 * Datum der Abnahme:   14.01.2010
 * Quellen:             URL: https://pub.informatik.haw-hamburg.de/home/pub/prof/schafers/S09W_P1/Aufgabenzettel_Nr6_v08.pdf
 */
package b2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class B2 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        HashMap<String, Integer> wordMap = new HashMap<String, Integer>();

        double time = System.nanoTime();
        int count = 0;
        try {
            WordGrabber wg = new WordGrabber();

            while (wg.hasNext()) {
                count++;
                String tmp = wg.getNext().toUpperCase();
                if (wordMap.containsKey(tmp)) {
                    wordMap.put(tmp, wordMap.get(tmp).intValue() + 1);
                    wg.getNext();
                } else {
                    wordMap.put(tmp, 1);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e + " -Bitte wenden sie sich an den Programmierer Ihres Vertrauens!-");
        }
        System.out.println(wordMap); // Ausgabe der Map (Unsortiert)
        Object[] objArr = wordMap.entrySet().toArray(); // Alle einträge der "wordMap" per "toArray()" in ein Objekt Array schreiben (Unsortiert)
        ArrayList<String> erg = new ArrayList<String>(); // String ArrayList zur ausgabe erstellen               
        for (Object a : objArr) { // per foreach schleife jedes element von objArr durchlaufen
            erg.add(a.toString()); // jedes element von objArr per toString in erg schreiben 
        }
        Collections.sort(erg,new Comparator<String>() { // ArrayList "erg" mit neuem Comparator sortieren 
            public int compare(String s1, String s2) {
                s1 = s1.substring(0, s1.indexOf("=")); // schreibe "s1" & "s2" bis zum "="-Zeichen neu
                s2 = s2.substring(0, s2.indexOf("="));
                return s1.compareTo(s2);
            }
        });

        System.out.println(erg);
        double time2 = System.nanoTime() - time;
        System.out.println();
        System.out.println(time2/1000000000 + " sec / " + "Wörter: " + count);
    }
}