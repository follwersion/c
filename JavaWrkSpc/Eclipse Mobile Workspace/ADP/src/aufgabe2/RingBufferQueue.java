package aufgabe2;

import java.util.Arrays;

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

public class RingBufferQueue<T> implements Queue<T> {
	private T[] queue;
	private int head;
	private int tail;
	private int size;
	
	public RingBufferQueue(){
		this(10);
	}
	
	public RingBufferQueue(int size){
		if(size < 1){
			throw new IllegalArgumentException();
		}
		
		this.queue = (T[])new Object[size];
		this.head  = 0;
		this.tail  = 0;
		this.size  = 0;
	}
	
	public T front(){
		if(this.isEmpty()){
			return null;
		}
		
		return this.queue[this.head];
	}
	
	public boolean enqueue(T data){
		if(this.size >= this.queue.length){
			return false;
		}
		
		if(this.isEmpty()){
			this.head = this.tail = 0;
		}
		else if(++this.tail >= this.queue.length){
			this.tail = 0;
		}
		
		this.size++;
		
		this.queue[this.tail] = data;
		
		return true;
	}
	
	public boolean dequeue(){
		if(this.isEmpty()){
			return false;
		}
		
		this.size--;
		
		if(this.isEmpty()){
			this.head = this.tail = 0;
		}
		else if(++this.head >= this.queue.length){
			this.head = 0;
		}
		
		return true;
	}
	
	public boolean isEmpty(){
		return (this.size == 0);
	}
}
