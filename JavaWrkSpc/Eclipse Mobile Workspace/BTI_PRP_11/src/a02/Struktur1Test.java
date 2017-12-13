package a02;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 06.04.09
 * Teamname: SingleMalt
 * @author Konstantin Dolberg
 * @author Lukas Lukowski
 */

public class Struktur1Test {

	int k = 3;
	Struktur1 Variantetest_1 = new Struktur1(k);

	@Test
	public void testGetLinkenNachfolger() {
		int[] a = { 0, 2, 4, 6, 0, 0, 0, 0 };
		for (int i = 1; i < 8; i++) {
			assertEquals(a[i], Variantetest_1.getLinkenNachfolger(i));
		}
	}

	@Test
	public void testGetRechtenNachfolger() {
		int[] a = { 0, 3, 5, 7, 0, 0, 0, 0 };
		for (int i = 1; i < 8; i++) {
			assertEquals(a[i], Variantetest_1.getRechtenNachfolger(i));
		}
	}

	@Test
	public void testGetVorgaenger() {
		int[] a = { 0, 0, 1, 1, 2, 2, 3, 3 };
		for (int i = 1; i < 8; i++) {
			assertEquals(a[i], Variantetest_1.getVorgaenger(i));
		}
	}

	@Test
	public void testGetNachbar() {
		int[] a = { 0, 0, 3, 2, 5, 4, 7, 6 };
		for (int i = 1; i < 8; i++) {
			assertEquals(a[i], Variantetest_1.getNachbar(i));
		}
	}

}
