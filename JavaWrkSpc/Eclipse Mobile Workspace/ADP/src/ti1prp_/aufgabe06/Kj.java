package ti1prp_.aufgabe06;

public class Kj implements Template {
String cla;
    
    public Kj(){
        cla = "Kj";
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
    
}//Kj