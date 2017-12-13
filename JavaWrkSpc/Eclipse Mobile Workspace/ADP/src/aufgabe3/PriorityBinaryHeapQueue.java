package aufgabe3;

import java.util.Comparator;

import aufgabe2.Queue;

/*
 * ADP - WS2008/9
 * 
 * Aufgabe 3 - Priority Queue
 * 
 * Team: EmptyNameException
 *       - Felix Bruns   / 1907766
 *       - Thomas Schulz / 1899432
 * 
 * Sources:
 *       - Weiss, Mark Allen: PriorityQueue.
 *         URL: http://www.cs.fiu.edu/~weiss/dsj3/code/weiss/util/PriorityQueue.java
 *         File date: March 6, 2005 - Mail: weiss@fiu.edu - Florida International University
 */

/*
 * This priority queue is implemented using a binary max-heap.
 * The biggest element forms the root of the binary tree and
 * all children are less (or equal). The worst-case running time
 * of enqueue and dequeue is O(log n) whereas n equals the number
 * of elements currently in the heap.
 */
public class PriorityBinaryHeapQueue<T> implements Queue<T> {
	private T[] queue;
	private int size;
	private float factor;
	private Comparator<? super T> comparator;
	
	public PriorityBinaryHeapQueue(){
		this(10, 2.0f, null);
	}
	
	public PriorityBinaryHeapQueue(int size, float factor, Comparator<? super T> comparator){
		if(size < 1 || factor < 1.0f || size * factor - size < 1 || comparator == null){
			throw new IllegalArgumentException();
		}
		
		this.queue      = (T[])new Object[size + 1];
		this.size       = 0;
		this.factor     = factor;
		this.comparator = comparator;
	}
	
	private int compare(T a, T b){
		return this.comparator.compare(a, b);
	}
	
	public T front(){
		if(this.isEmpty()){
			return null;
		}
		
		return this.queue[1];
	}
	
	public boolean enqueue(T data){
		if(this.size + 1 >= this.queue.length){
			this.grow();
		}
		
		int hole = ++this.size;
		
		this.queue[0] = data;
		
		for( ; this.compare(data, this.queue[hole / 2]) > 0; hole /= 2){
			this.queue[hole] = this.queue[hole / 2];
		}
		
		this.queue[hole] = data;
		
		return true;
	}
	
	public boolean dequeue(){
		if(this.isEmpty()){
			return false;
		}
		
		this.queue[1] = this.queue[this.size--];
		
		int hole = 1, child;
		
		T tmp = this.queue[hole];
		
		for( ; hole * 2 <= this.size; hole = child){
			child = hole * 2;
			
			if(child != this.size && this.compare(this.queue[child + 1], this.queue[child]) > 0){
				child++;
			}
			
			if(this.compare(this.queue[child], tmp) > 0){
				this.queue[hole] = this.queue[child];
			}
			else{
				break;
			}
		}
		
		this.queue[hole] = tmp;
		
		return true;
	}
	
	public boolean isEmpty(){
		return (this.size == 0);
	}
	
	private void grow(){
		T[] array = (T[])new Object[(int)(this.queue.length * this.factor)];
		
		for(int i = 0; i < this.queue.length; i++){
			array[i] = this.queue[i];
		}
		
		this.queue = array;
	}
}
