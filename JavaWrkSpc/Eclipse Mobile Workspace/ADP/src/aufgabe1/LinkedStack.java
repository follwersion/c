package aufgabe1;

/*
 * ADP - WS2008/9
 * 
 * Aufgabe 1 - Stack
 * 
 * Team: EmptyNameException
 *       - Felix Bruns   / 1907766
 *       - Thomas Schulz / 1899432
 */

import java.util.EmptyStackException;

public class LinkedStack<T> implements Stack<T> {
	private LinkedStackElement<T> head;
	
	public LinkedStack(){
		this.head = null;
	}
	
	public T push(T item){
		if(this.head == null){
			this.head = new LinkedStackElement<T>(item, null);
		}
		else{
			this.head = new LinkedStackElement<T>(item, this.head);
		}		
		
		return this.head.item();
	}
	
	public T peek(){
		if(this.head == null){
			throw new EmptyStackException();
		}
		
		return this.head.item();
	}
	
	public T pop(){
		if(this.head == null){
			throw new EmptyStackException();
		}
		
		T item = this.head.item();
		
		this.head = this.head.previous();
		
		return item;
	}
	
	public boolean empty(){
		return (this.head == null);
	}
}
