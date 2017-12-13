package ti1prp_.aufgabe06;


public class Kc implements Template {
String cla;
    
    public Kc(){
        cla = "Kc";
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
    
}//ka

