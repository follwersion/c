/*
 * Praktikum: P1P
 * Semester:  WS07
 * Team:      S1T7
 * Author:    Bruns, Felix       #1907766
 *            Schulz, Thomas     #1899432
 * Aufgabe:   A8 - Universal-Liste
 */

package ti1prp_.aufgabe08;

public class MagicList<T> {
    private int size;
    private Element<T> first;
    private Element<T> last;
    
    public MagicList(){
    	this.size  = 0;
    	this.first = null;
    	this.last  = null;
    }
    
    public void clear(){
    	while(this.size > 0){
            this.getF();
        }
    }
    
    public void putF(T data){
        Element<T> first, temp;
        
        first = new Element<T>(data);
        temp = this.first;
        
        this.first = first;
        this.first.setNext(temp);
        
        if(++this.size == 1) this.last = first;
    }
    
    public void putL(T data){
        Element<T> last, temp;
        
        last = new Element<T>(data);
        temp = this.last;
        
        this.last = last;
        
        if (temp != null) temp.setNext(this.last);
        
        if(++this.size == 1) this.first = last;
    }
    
    public boolean isEmpty(){
        return(this.size == 0)? true : false;
    }
    
    public void printF2L(){
        Element<T> temp = this.first;
        
        while(temp != null){
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }
    
    public void printL2F(){
        Element<T> temp;
        
        for(int i = this.size; i > 0; i--){
            temp = this.first;  
            for(int j = 0; j < i - 1; j++){
                temp = temp.getNext();
            }
            System.out.println(temp.getData());    
        }
    }
    
    public T peekNo(int index){
        Element<T> temp = this.first;
        int i = 0;
        
        while(temp != null && i < index){
            temp = temp.getNext();
            i++;
        }
        
        return (temp != null)? temp.getData() : null;
    }
    
    public T peekF(){
        return (this.first != null)? this.first.getData() : null;
    }
    
    public T peekL(){
        return (this.last != null)? this.last.getData() : null;
    }
    
    public boolean remove(T input){
        Element<T> temp1 = this.first;
        Element<T> temp2 = this.first;
        
        for (int i = 0; i < size; i++) {
            if (temp1.getData().equals(input)){
                temp1 = this.first;
                
                for (int j = 0; j < i - 1; j++)
                    temp1 = temp1.getNext();
                for (int j = 0; j < i + 1; j++)
                    temp2 = temp2.getNext();
                
                temp1.setNext(temp2);
                
                if (i == --this.size)
                    this.last = temp1;
                if (i == 0)
                    this.first = temp2;
                
                return true;
            }
            temp1 = temp1.getNext();
        }
        
        return false;
    }
    
    public T getL(){
        Element<T> temp = this.last;
        
        this.remove(last.getData());
        
        return temp.getData();
    }
    
    public T getF(){
        Element<T> temp = this.first;
        
        this.remove(this.first.getData());
        
        return temp.getData();
    }
    
    public T getNo(int index){
        T temp = peekNo(index);
        
        if(temp != null)
            remove(temp);
        
        return peekNo(index);
    }
    

    public MagicList<T> subList(T data) { 
        boolean check = false;
        MagicList<T> list = new MagicList<T>();
        Element<T> temp = this.first;
        
        for (int i = 0; i < this.size; i++) {
            if (temp.getData().equals(data)) check = true;
            if (check) list.putL(temp.getData());
            temp = temp.getNext();
        }
        
        return list;
    }
    
    public MagicList<T> subList(T data, T data2) { 
        boolean check = false;
        MagicList<T> list = new MagicList<T>();
        Element<T> temp = this.first;
        
        for (int i = 0; i < this.size; i++) {
            if (temp.getData().equals(data)) check = true;
            if (temp.getData().equals(data2)) check = false;
            if (check) list.putL(temp.getData());
            temp = temp.getNext();
        }
        
        return list;
    }
}
