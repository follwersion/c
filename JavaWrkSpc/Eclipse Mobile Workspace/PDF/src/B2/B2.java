/*
 * Praktikum:           P1P 
 * Semester:            WS09
 * Team-Name:           S3T4
 * Namen:               Dolberg, Konstantin     #1959949
 *                      Eisenbraun, Alexander   #1965085
 * Aufgaben-Nr.:        B2
 * Kontrolleur:         Behnke
 * Datum der Abnahme:   14.01.2010
 * Quellen:             URL: https://pub.informatik.haw-hamburg.de/home/pub/prof/schafers/S09W_P1/Aufgabenzettel_Nr6_v05.pdf
 */
package b2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class B2 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        HashMap<String, Integer> wordMap = new HashMap<String, Integer>();        
        int count = 0;
        try {
            WordGrabber wg = new WordGrabber("Z:\\input.txt");
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
            System.out.println(e + "\n- Datei wurde nicht gefunden, bitte Pfadangabe überprüfen! -");
        } catch (NullPointerException e) {
            System.out.println(e + "\n- Datei enthält keine lesbaren Daten! -");
        }
        StringBuilder sb = new StringBuilder();      
        ArrayList<String> erg = new ArrayList<String>(); // String ArrayList zur Ausgabe erstellen               
        erg.addAll(wordMap.keySet());
        Collections.sort(erg);
       
        for(String a:erg) {
            sb.append("\n").append("[").append(a).append(" : ").append(wordMap.get(a)).append("]").toString();
        }
        System.out.println(sb);  
        System.out.println("Wörter: " + count);
    }
}