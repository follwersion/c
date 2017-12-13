package ti1prp_.aufgabe09;

import java.util.LinkedList;

/*
 * Praktikum: P1P
 * Semester:  WS07
 * Team:      S1T7
 * Author:    Bruns, Felix     #1907766
 *            Schulz, Thomas   #1899432
 * Aufgabe:   A9 - Computer Shop
 */

public class Store {
	LinkedList<Component> componentList;
	
	public Store(){
        componentList = new LinkedList<Component>();
    }
    
    public boolean add(Component c){
        return componentList.add(c);
    }
    
    public void delete(int n) throws NonExistingComponentException {
        for(int i = 0; i < componentList.size(); i++){
            if(componentList.get(i).cnsNo == n){
                componentList.remove(i);
                return;
            }
        }
        throw new NonExistingComponentException("Component doesn't exist.", 10);
    }
    
    public int numOfComponentsInStore(){
        return componentList.size();        
    }
    
    public int computeValue(){
        int total = 0;
        
        for(int i = 0; i < componentList.size(); i++){
            total += componentList.get(i).price;
        }
        
        return total;
    }
    
    public void printAllComponents(){
        for(int i = 0; i < componentList.size(); i++){
            System.out.println(componentList.get(i));
        }
    }
    
    public String toString(){
        String ret = "";
        
        for(int i = 0; i < componentList.size(); i++){
            ret += componentList.get(i) + "\n";
        }
        
        return ret;
    }
}
