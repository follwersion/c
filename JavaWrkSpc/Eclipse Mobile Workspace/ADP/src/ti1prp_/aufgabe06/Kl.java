package ti1prp_.aufgabe06;

public class Kl implements Template {
String cla;
    
    public Kl(){
        cla = "Kl";
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
    
}//Kl