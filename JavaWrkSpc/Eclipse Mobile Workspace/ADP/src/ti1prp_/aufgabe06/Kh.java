package ti1prp_.aufgabe06;

public class Kh implements Template {
String cla;
    
    public Kh(){
        cla = "Kh";
          }
    
    public String tu(){
        // wilde Berechnung
        return cla+"."+"tu()";
    }//tu
    
    public String xx(){
        // wilde Berechnung
        return "<"+cla+">";
    }//xx
    
    public String id(){
        return cla;
    }//id
    
}//Kh