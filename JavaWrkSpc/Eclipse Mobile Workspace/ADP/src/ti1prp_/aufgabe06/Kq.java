package ti1prp_.aufgabe06;

public class Kq implements Template {
String cla;
    
    public Kq(){
        cla = "Kq";
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
    
}//Kq