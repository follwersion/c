package ti1prp_.aufgabe10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*
 * Praktikum: P1P
 * Semester:  WS07
 * Team:      S1T7
 * Author:    Bruns, Felix     #1907766
 *            Schulz, Thomas   #1899432
 * Aufgabe:   A10 - Wörter im Text zählen
 */

public class WordCounter {

    public static void main(String[] args) {
        Map<String,Integer> map;
        Iterator<String> it;
        List<String> keys;
        WordGrabber wg;
        String str;
        
        try{
            wg  = new WordGrabber("C:\\Documents and Settings\\bruns_f\\Desktop\\pmars13.txt");
            map = new HashMap<String,Integer>();
            
            while(wg.hasNext()){
                str = wg.getNext().toLowerCase();
                
                if(map.get(str) != null){
                    map.put(str, map.get(str).intValue() + 1);                    
                }
                else{
                    map.put(str, 1);
                }
            }
            
            keys = new ArrayList<String>(map.keySet());
            Collections.sort(keys);
            
            it = keys.iterator();
            while(it.hasNext()){
                str = it.next();
                System.out.printf("[ %s ] : %d\n", str, map.get(str));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

}
