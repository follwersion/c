package ti1prp_.aufgabe06;

public class Kb implements Template {
    String cla; 
    
    public Kb(){
        cla="Kb";
    }
    
    public String tu(){
        return cla+".tu()";
    }
    
    public String xx(){
        return "<"+cla+">";
    }
    
    public String id(){
        return cla;
    }

}
