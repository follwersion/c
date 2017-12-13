package b2;
/**
* Praktikum P1P
* Semester WS08/09
* Team S4BOS
* Aufgabe B2
* Kontrolleur Norbert Kasperczyk 16.01.2009
* @author Böschen, Falk; 1940016
*/
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class WordCounter 
{
     private Map<String, Integer> wordmap;

     public WordCounter(String args)
     {
         
         int count = 0;

          WordGrabber grabber;
          wordmap = new HashMap<String, Integer>();
          try
          {
              grabber = new WordGrabber(args);                          // Create new WordGrabber-Object with defined data-path args
              while (grabber.hasNext())                                 // as long as there is a next word
              {
                  
                  count++;

                  String tempword = grabber.getNext().toLowerCase();    // convert next word to lower case and save it to tempword
                  if (wordmap.containsKey(tempword))                    // if tempword is already in the map => counter + 1
                  {
                    wordmap.put(tempword, wordmap.get(tempword) + 1);
                  }//if
                  else                                                  // else add tempword to map and set counter = 1
                  {    
                    wordmap.put(tempword, 1);
                  }//else
              }//while
              
              System.out.println(count);
              
          }// End Try-Block 
          catch (FileNotFoundException e)
          {
              e.printStackTrace();
          }// Catch first Exception of WordGrabber
          catch (IOException e)
          {
              e.printStackTrace();
          }// Catch second Exception of WordGrabber
      }//WordCounter
     
      public String toString()                                                // prints hashmap in alphabetical order
      {
          StringBuilder sb = new StringBuilder();                             // init StringBuilder
          List<String> ausgabeliste = new ArrayList<String>();                // creates new Arraylist<String>
          ausgabeliste.addAll(wordmap.keySet());                              // adds all elements of the hashmap to the arraylist
          Collections.sort(ausgabeliste);                                     // sorts arraylist alphabetical

          for ( String entry : ausgabeliste )                                 // adds elements of hashmap in alphabetical order to a string using the StringBuilder
          {
              sb.append(entry + ":" + wordmap.get(entry) + " \n");
          }//for
          
          return sb.toString();                                                // returns string containing all elements
      }//ausgabe
}
