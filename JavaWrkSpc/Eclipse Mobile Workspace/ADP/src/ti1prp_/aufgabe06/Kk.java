package ti1prp_.aufgabe06;

public class Kk implements Template {
String cla;
    
    public Kk(){
        cla = "Kk";
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
    
}//Kk