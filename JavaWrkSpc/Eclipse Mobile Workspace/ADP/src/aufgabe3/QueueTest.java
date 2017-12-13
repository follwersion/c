package aufgabe3;

/*
 * ADP - WS2008/9
 * 
 * Aufgabe 2 - Queue
 * 
 * Team: EmptyNameException
 *       - Felix Bruns   / 1907766
 *       - Thomas Schulz / 1899432
 */

import java.util.Comparator;

import aufgabe2.Queue;

import junit.framework.Assert;

public class QueueTest{
	public static void main(String[] args){
		/* Tests */
		QueueTest.test(new PriorityBinaryHeapQueue<Integer>(10, 2, new Comparator<Integer>(){
			public int compare(Integer a, Integer b){
				return a.compareTo(b);
			}
		}));
	}
	
	public static void test(Queue<Integer> queue){
		/* Print info */
		System.out.printf("Testing class '%s'...\n", queue.getClass().getCanonicalName());
		
		/* Test */
		Assert.assertTrue(queue.enqueue(new Integer(0)));
		Assert.assertTrue(queue.enqueue(new Integer(1)));
		Assert.assertFalse(queue.isEmpty());
		Assert.assertEquals(new Integer(1), queue.front());
		Assert.assertTrue(queue.dequeue());
		Assert.assertEquals(new Integer(0), queue.front());
		Assert.assertTrue(queue.dequeue());
		Assert.assertTrue(queue.isEmpty());
		
		Assert.assertTrue(queue.enqueue(new Integer(4)));
		Assert.assertTrue(queue.enqueue(new Integer(9)));
		Assert.assertTrue(queue.enqueue(new Integer(2)));
		Assert.assertTrue(queue.enqueue(new Integer(10)));
		Assert.assertTrue(queue.enqueue(new Integer(7)));
		Assert.assertTrue(queue.enqueue(new Integer(6)));
		Assert.assertTrue(queue.enqueue(new Integer(1)));
		Assert.assertTrue(queue.enqueue(new Integer(8)));
		Assert.assertTrue(queue.enqueue(new Integer(3)));
		Assert.assertTrue(queue.enqueue(new Integer(5)));
		
		for(int i = 10; i > 0; i--){
			Assert.assertEquals(new Integer(i), queue.front());
			Assert.assertTrue(queue.dequeue());
		}
		
		Assert.assertNull(queue.front());
		Assert.assertFalse(queue.dequeue());
		
		System.out.println("All tests passed!\n");
	}
}
