package ti1prp_.aufgabe06;

public class Kp implements Template {
String cla;
    
    public Kp(){
        cla = "Kp";
        tu();
        xx();
        id();
        return;
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
    
}//Kp