package a02;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 06.04.09
 * Teamname: SingleMalt
 * @author Konstantin Dolberg
 * @author Lukas Lukowski
 */

public class Struktur2Test {

	int k = 3;
	Struktur2 Variantetest_2 = new Struktur2(k);

	@Test
	public void testGetLinkenNachfolger() {
		int[] a = { 0, 0, 1, 0, 2, 0, 5, 0 };
		for (int i = 1; i < 8; i++) {
			assertEquals(a[i], Variantetest_2.getLinkenNachfolger(i));
		}
	}

	@Test
	public void testGetRechtenNachfolger() {
		int[] a = { 0, 0, 3, 0, 6, 0, 7, 0 };
		for (int i = 1; i < 8; i++) {
			assertEquals(a[i], Variantetest_2.getRechtenNachfolger(i));
		}
	}

	@Test
	public void testGetVorgaenger() {
		int[] a = { 0, 2, 4, 2, 0, 6, 4, 6 };
		for (int i = 1; i < 8; i++) {
			assertEquals(a[i], Variantetest_2.getVorgaenger(i));
		}
	}

	@Test
	public void testGetNachbar() {
		int[] a = { 0, 3, 6, 1, 0, 7, 2, 5 };
		for (int i = 1; i < 8; i++) {
			assertEquals(a[i], Variantetest_2.getNachbar(i));
		}
	}

}
