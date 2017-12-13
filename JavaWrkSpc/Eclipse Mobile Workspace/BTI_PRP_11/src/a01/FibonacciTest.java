package a01;

import static org.junit.Assert.*;

import org.junit.Test;
/*
 * Team name:SingleMalt 	PR01 	Datum:26.03.09
 * Autoren: Konstantin Dolberg, Lukas Lukowski
 */
public class FibonacciTest {

	@Test
	public void testFibonacci() {
		
		int [] a = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34};
		
		for (int i = 0; i < 10; i++) {
			assertEquals(a[i], Fibonacci.fibonacci(i));
		}
		
	}

}
