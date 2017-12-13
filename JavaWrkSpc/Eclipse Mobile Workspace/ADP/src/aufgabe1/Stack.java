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

public interface Stack<T> {
	public T push(T item);

	public T peek() throws EmptyStackException;

	public T pop() throws EmptyStackException;

	public boolean empty();
}
