/*
 * Praktikum: P1P
 * Semester:  WS07
 * Team:      S1T7
 * Author:    Bruns, Felix       #1907766
 *            Schulz, Thomas     #1899432
 * Aufgabe:   A8 - Universal-Liste
 */

package ti1prp_.aufgabe08;

public class Element<T> {
    private T value;
    private Element<T> next;
    
    public Element(T data) {    
        this.value = data;
    }
    
    public T getData() {         
        return this.value;
    }
    
    public void setNext(Element<T> next) {  
        this.next = next;
    }
    
    public Element<T> getNext(){
        return this.next;
    }
    
    public boolean hasNext(){
        return (this.next != null);
    }
    
    public String toString(){
        return String.format("%s\t%s", this.value, this.next);
    }
}
    
    
