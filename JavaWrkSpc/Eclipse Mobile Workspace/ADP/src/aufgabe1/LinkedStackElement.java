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

public class LinkedStackElement<T> {
	private LinkedStackElement<T> previous;
	private T item;
	
	public LinkedStackElement(T item, LinkedStackElement<T> previous){
		this.previous = previous;
		this.item     = item;
	}
	
	public T item(){
		return this.item;
	}
	
	protected LinkedStackElement<T> previous(){
		return this.previous;
	}
}
