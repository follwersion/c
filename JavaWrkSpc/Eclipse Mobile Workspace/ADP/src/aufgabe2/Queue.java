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

public interface Queue<T> {
	public T front();
	public boolean enqueue(T data);
	public boolean dequeue();
	public boolean isEmpty();
}
