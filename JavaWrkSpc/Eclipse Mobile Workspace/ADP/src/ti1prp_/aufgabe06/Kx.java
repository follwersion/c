package ti1prp_.aufgabe06;

public class Kx implements Template {
String cla;
    
    public Kx(){
        cla = "Kx";
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
    
}//Kx