package b2;
/**
* Praktikum P1P
* Semester WS08/09
* Team S4BOS
* Aufgabe B2
* Kontrolleur Norbert Kasperczyk 16.01.2009
* @author Böschen, Falk; 1940016
*/
public class Testframe 
{
  public static void main(String[] args) 
  {
      double time = System.nanoTime();

      String text = "Z:\\input.txt";
      WordCounter c = new WordCounter(text);
      System.out.print(c);
      
      double time2 = System.nanoTime() - time;
      System.out.println();        
      System.out.println(time2/1000000000 + " sec");     
  }
}
