package aufgabe2;

import aufgabe2.Queue;

/*
 * ADP - WS2008/9
 * 
 * Aufgabe 2 - Queue
 * 
 * Team: EmptyNameException
 *       - Felix Bruns   / 1907766
 *       - Thomas Schulz / 1899432
 */

public class LinkedQueue<T> implements Queue<T> {
	private LinkedQueueElement<T> head;
	private LinkedQueueElement<T> tail;
	
	public LinkedQueue(){
		this.head = null;
		this.tail = null;
	}
	
	public T front(){
		if(this.head == null){
			return null;
		}
		
		return this.head.data();
	}
	
	public boolean enqueue(T data){
		if(this.head == null){
			this.head = this.tail = new LinkedQueueElement<T>(data);
		}
		else{
			LinkedQueueElement<T> element = new LinkedQueueElement<T>(data);
			
			this.tail.next(element);
			
			this.tail = element;
		}
		
		return true;
	}
	
	public boolean dequeue(){
		if(this.head == null){
			return false;
		}
		
		this.head = this.head.next();
		
		return true;	
	}
	
	public boolean isEmpty(){
		return (this.head == null);
	}
}
