package aufgabe2;

/*
 * ADP - WS2008/9
 * 
 * Aufgabe 2 - Queue
 * 
 * Team: EmptyNameException
 *       - Felix Bruns   / 1907766
 *       - Thomas Schulz / 1899432
 */

public class LinkedQueueElement<T> {
	private LinkedQueueElement<T> next;
	private T data;
	
	public LinkedQueueElement(T data){
		this.next = null;
		this.data = data;
	}
	
	public T data(){
		return this.data;
	}
	
	protected void next(LinkedQueueElement<T> next){
		this.next = next;
	}
	
	protected LinkedQueueElement<T> next(){
		return this.next;
	}
}
