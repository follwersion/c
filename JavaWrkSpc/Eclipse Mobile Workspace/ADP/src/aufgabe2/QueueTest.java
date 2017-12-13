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

import junit.framework.Assert;

public class QueueTest{
	public static void main(String[] args){
		/* Tests */
		QueueTest.test(new LinkedQueue<Object>());
		QueueTest.test(new RingBufferQueue<Object>(10), 10);
		
		/* Benchmarks */
		QueueTest.benchmark(new LinkedQueue<Object>());
		QueueTest.benchmark(new RingBufferQueue<Object>(1000000));
	}
	
	public static void test(Queue<Object> queue){
		QueueTest.test(queue, 0);
	}
	
	public static void test(Queue<Object> queue, int maxElements){
		/* Print info */
		System.out.printf("Testing class '%s'...\n", queue.getClass().getCanonicalName());
		
		/* Test */
		Assert.assertTrue(queue.enqueue("a"));
		Assert.assertTrue(queue.enqueue("b"));
		Assert.assertFalse(queue.isEmpty());
		Assert.assertEquals("a", queue.front());
		Assert.assertTrue(queue.dequeue());
		Assert.assertEquals("b", queue.front());
		Assert.assertTrue(queue.dequeue());
		Assert.assertTrue(queue.isEmpty());
		
		if(maxElements > 0){
			for(int i = 0; i < maxElements; i++){
				Assert.assertTrue(queue.enqueue(i));
			}
			for(int i = maxElements; i < maxElements + 20; i++){
				Assert.assertFalse(queue.enqueue(i));
			}
			for(int i = 0; i < maxElements; i++){
				Assert.assertEquals(i, queue.front());
				Assert.assertTrue(queue.dequeue());
			}			
			for(int i = maxElements; i < maxElements + 20; i++){
				Assert.assertNull(queue.front());
				Assert.assertFalse(queue.dequeue());
			}
		}
		else{
			for(int i = 0; i < 20; i++){
				Assert.assertTrue(queue.enqueue(i));
			}
			for(int i = 0; i < 20; i++){
				Assert.assertEquals(i, queue.front());
				Assert.assertTrue(queue.dequeue());
			}
		}
		
		Assert.assertNull(queue.front());
		Assert.assertFalse(queue.dequeue());
		
		System.out.println("All tests passed!\n");
	}
	
	public static void benchmark(Queue<Object> queue){
		/* Run-time and memory usage */
		long time, totalTime = 0;
		long memory, totalMemory = 0;
		
		/* Print info */
		System.out.printf("Benchmarking class '%s'...\n", queue.getClass().getCanonicalName());
		
		/* Enqueue */
		QueueTest.collectGarbage();
		memory = QueueTest.currentMemoryUsage();
		time = System.nanoTime();
		for(int i = 0; i < 1000000; i++){
			queue.enqueue(null);
		}
		time = (System.nanoTime() - time);
		totalTime += time;
		memory = QueueTest.currentMemoryUsage() - memory;
		totalMemory += memory;
		System.out.format(
			"1 million enqueue operations in %8.2f milliseconds (memory used: %d bytes)\n",
			time / 1000000.0, memory
		);
		
		/* Front */
		QueueTest.collectGarbage();
		memory = QueueTest.currentMemoryUsage();
		time  = System.nanoTime();
		for(int i = 0; i < 1000000; i++){
			queue.front();
		}
		time = (System.nanoTime() - time);
		totalTime += time;
		memory = QueueTest.currentMemoryUsage() - memory;
		totalMemory += memory;
		System.out.format(
			"1 million front   operations in %8.2f milliseconds (memory used: %d bytes)\n",
			time / 1000000.0, memory
		);
		
		/* Dequeue */
		QueueTest.collectGarbage();
		memory = QueueTest.currentMemoryUsage();
		time  = System.nanoTime();
		for(int i = 0; i < 1000000; i++){
			queue.dequeue();
		}
		time = (System.nanoTime() - time);
		totalTime += time;
		memory = QueueTest.currentMemoryUsage() - memory;
		totalMemory += memory;
		System.out.format(
			"1 million dequeue operations in %8.2f milliseconds (memory used: %d bytes)\n",
			time / 1000000.0, memory
		);
		
		/* Print total values */
		System.out.format("Total: %8.2f milliseconds (memory used: %d bytes)\n", totalTime / 1000000.0, totalMemory);
		
		/* Newline */
		System.out.println();
	}
	
	public static void collectGarbage(){
		try{
			/* Collect garbage */
			System.gc();
			
			/* Sleep, so the garbage collector can do it's work. */
			Thread.sleep(1000);
			
			/* Run finalize methods of dropped objects */
			System.runFinalization();
			
			/* Sleep, so the finalization can be done. */
			Thread.sleep(1000);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public static long currentMemoryUsage(){
		return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
	}
}
