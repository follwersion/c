package ti1prp_.aufgabe06;

public class Kd implements Template {
String cla;
    
    public Kd(){
        cla = "Kd";
   
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
    
}//Kd