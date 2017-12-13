package ti1prp_.aufgabe06;

public class Ky implements Template {
String cla;
    
    public Ky(){
        cla = "Ky";
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
    
}//Ky