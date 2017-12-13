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

import java.util.Arrays;
import java.util.EmptyStackException;


public class ArrayStack<T> implements Stack<T> {
	private T[] st;
	private int sp;
	
	public ArrayStack(){
		this(10);
	}
	
	public ArrayStack(int size){
		/* 
		 * Java erlaubt keine Erstellung von Generics Arrays, da zum
		 * Zeitpunkt der Kompilierung keine Klasseninformationen zur
		 * Verfügung stehen. Deshalb ist an dieser Stelle ein cast
		 * notwendig um einen Generics Stack zu unterstützen. Dieser
		 * cast sollte nie zu einem Fehler führen.
		 */
		this.st  = (T[])new Object[size];
		this.sp  = -1;
	}
	
	public T push(T item){
		if(this.sp >= this.st.length - 1){
			this.grow();
		}
		
		this.st[++sp] = item;
		
		return this.st[sp];
	}
	
	public T peek(){
		if(this.sp < 0){
			throw new EmptyStackException();
		}
		
		return this.st[sp];
	}
	
	public T pop(){
		if(this.sp < 0){
			throw new EmptyStackException();
		}
		
		return this.st[sp--];
	}
	
	public boolean empty(){
		return (this.sp < 0);
	}
	
	private void grow(){
		this.st = Arrays.copyOf(this.st, this.st.length << 1);
	}
}
