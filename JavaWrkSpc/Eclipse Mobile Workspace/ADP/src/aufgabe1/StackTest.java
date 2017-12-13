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

import junit.framework.Assert;

public class StackTest{
	public static void main(String[] args){
		/* Tests */
		StackTest.test(new ArrayStack<Object>());
		StackTest.test(new LinkedStack<Object>());
		StackTest.test(new java.util.Stack<Object>());
		
		/* Benchmarks */
		StackTest.benchmark(new ArrayStack<Object>());
		StackTest.benchmark(new LinkedStack<Object>());
		StackTest.benchmark(new java.util.Stack<Object>());
	}
	
	public static void test(Stack<Object> stack){
		/* Print info */
		System.out.printf("Testing class '%s'...\n", stack.getClass().getCanonicalName());
		
		/* Test */
		Assert.assertEquals("a", stack.push("a"));
		Assert.assertEquals("b", stack.push("b"));
		Assert.assertEquals(false, stack.empty());
		Assert.assertEquals("b", stack.peek());
		Assert.assertEquals("b", stack.pop());
		Assert.assertEquals("a", stack.pop());
		Assert.assertEquals(true, stack.empty());
		
		for(int i = 0; i < 20; i++){
			Assert.assertEquals("c", stack.push("c"));
		}
		for(int i = 0; i < 20; i++){
			Assert.assertEquals("c", stack.pop());
		}
		
		try{
			stack.pop();
			
			Assert.fail("No EmptyStackException thrown!");
		}
		catch(EmptyStackException e){
			/* An EmptyStackException is expected. */
		}
		
		System.out.println("All tests passed!\n");
	}
	
	public static void test(java.util.Stack<Object> stack){
		/* Print info */
		System.out.printf("Testing class '%s'...\n", stack.getClass().getCanonicalName());
		
		/* Test */
		Assert.assertEquals("a", stack.push("a"));
		Assert.assertEquals("b", stack.push("b"));
		Assert.assertEquals(false, stack.empty());
		Assert.assertEquals("b", stack.peek());
		Assert.assertEquals("b", stack.pop());
		Assert.assertEquals("a", stack.pop());
		Assert.assertEquals(true, stack.empty());
		
		for(int i = 0; i < 20; i++){
			Assert.assertEquals("c", stack.push("c"));
		}
		for(int i = 0; i < 20; i++){
			Assert.assertEquals("c", stack.pop());
		}
		
		try{
			stack.pop();
			
			Assert.fail("No EmptyStackException thrown!");
		}
		catch(EmptyStackException e){
			/* An EmptyStackException is expected. */
		}
		
		System.out.println("All tests passed!\n");
	}
	
	public static void benchmark(Stack<Object> stack){
		/* Run-time and memory usage */
		long time, totalTime = 0;
		long memory, totalMemory = 0;
		
		/* Print info */
		System.out.printf("Benchmarking class '%s'...\n", stack.getClass().getCanonicalName());
		
		/* Push on growing array */
		StackTest.collectGarbage();
		memory = StackTest.currentMemoryUsage();
		time = System.nanoTime();
		for(int i = 0; i < 1000000; i++){
			stack.push(null);
		}
		time = (System.nanoTime() - time);
		totalTime += time;
		memory = StackTest.currentMemoryUsage() - memory;
		totalMemory += memory;
		System.out.format(
			"1 million push operations in %8.2f milliseconds (memory used: %d bytes)\n",
			time / 1000000.0, memory
		);
		
		/* Peek */
		StackTest.collectGarbage();
		memory = StackTest.currentMemoryUsage();
		time  = System.nanoTime();
		for(int i = 0; i < 1000000; i++){
			stack.peek();
		}
		time = (System.nanoTime() - time);
		totalTime += time;
		memory = StackTest.currentMemoryUsage() - memory;
		totalMemory += memory;
		System.out.format(
			"1 million peek operations in %8.2f milliseconds (memory used: %d bytes)\n",
			time / 1000000.0, memory
		);
		
		/* Pop */
		StackTest.collectGarbage();
		memory = StackTest.currentMemoryUsage();
		time  = System.nanoTime();
		for(int i = 0; i < 1000000; i++){
			stack.pop();
		}
		time = (System.nanoTime() - time);
		totalTime += time;
		memory = StackTest.currentMemoryUsage() - memory;
		totalMemory += memory;
		System.out.format(
			"1 million pop  operations in %8.2f milliseconds (memory used: %d bytes)\n",
			time / 1000000.0, memory
		);
		
		/* Push on preconstructed array */
		StackTest.collectGarbage();
		memory = StackTest.currentMemoryUsage();
		time  = System.nanoTime();
		for(int i = 0; i < 1000000; i++){
			stack.push(null);
		}
		time = (System.nanoTime() - time);
		totalTime += time;
		memory = StackTest.currentMemoryUsage() - memory;
		totalMemory += memory;
		System.out.format(
			"1 million push operations in %8.2f milliseconds (memory used: %d bytes)\n",
			time / 1000000.0, memory
		);
		
		/* Print total values */
		System.out.format("Total: %8.2f milliseconds (memory used: %d bytes)\n", totalTime / 1000000.0, totalMemory);
		
		/* Newline */
		System.out.println();
	}
	
	public static void benchmark(java.util.Stack<Object> stack){
		/* Run-time and memory usage */
		long time, totalTime = 0;
		long memory, totalMemory = 0;
		
		/* Print info */
		System.out.printf("Benchmarking class '%s'...\n", stack.getClass().getCanonicalName());
		
		/* Push on growing array */
		StackTest.collectGarbage();
		memory = StackTest.currentMemoryUsage();
		time = System.nanoTime();
		for(int i = 0; i < 1000000; i++){
			stack.push(null);
		}
		time = (System.nanoTime() - time);
		totalTime += time;
		memory = StackTest.currentMemoryUsage() - memory;
		totalMemory += memory;
		System.out.format(
			"1 million push operations in %8.2f milliseconds (memory used: %d bytes)\n",
			time / 1000000.0, memory
		);
		
		/* Peek */
		StackTest.collectGarbage();
		memory = StackTest.currentMemoryUsage();
		time  = System.nanoTime();
		for(int i = 0; i < 1000000; i++){
			stack.peek();
		}
		time = (System.nanoTime() - time);
		totalTime += time;
		memory = StackTest.currentMemoryUsage() - memory;
		totalMemory += memory;
		System.out.format(
			"1 million peek operations in %8.2f milliseconds (memory used: %d bytes)\n",
			time / 1000000.0, memory
		);
		
		/* Pop */
		StackTest.collectGarbage();
		memory = StackTest.currentMemoryUsage();
		time  = System.nanoTime();
		for(int i = 0; i < 1000000; i++){
			stack.pop();
		}
		time = (System.nanoTime() - time);
		totalTime += time;
		memory = StackTest.currentMemoryUsage() - memory;
		totalMemory += memory;
		System.out.format(
			"1 million pop  operations in %8.2f milliseconds (memory used: %d bytes)\n",
			time / 1000000.0, memory
		);
		
		/* Push on preconstructed array */
		StackTest.collectGarbage();
		memory = StackTest.currentMemoryUsage();
		time  = System.nanoTime();
		for(int i = 0; i < 1000000; i++){
			stack.push(null);
		}
		time = (System.nanoTime() - time);
		totalTime += time;
		memory = StackTest.currentMemoryUsage() - memory;
		totalMemory += memory;
		System.out.format(
			"1 million push operations in %8.2f milliseconds (memory used: %d bytes)\n",
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
