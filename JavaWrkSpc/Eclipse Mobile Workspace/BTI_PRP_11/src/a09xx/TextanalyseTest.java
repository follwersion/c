package a09xx;

/**
 * @Autor: Christopher Schmidt
 * 		   Martin Hua
 * Quelle: http://openbook.galileocomputing.de/javainsel8/javainsel_12_008.htm#mjd9d99744f8039b5fb45ed9d8a6510d6c 
 */

import static org.junit.Assert.*;
import org.junit.Test;

public class TextanalyseTest {

	@Test
	public void testAnzZeichen() {
		Textanalyse analyse = new Textanalyse();
		String text = "Ich und du und er und sie und es";
		
		assertEquals(24.0, analyse.numberOfTokens(text));
	}

	@Test
	public void testAnzWorte() {
		Textanalyse analyse = new Textanalyse();
		String text = "Ich und du und er und sie und es";
		
		assertEquals(9.0, analyse.numberOfWords(text));	
	}

	@Test
	public void testDurchschnittslaenge() {
		float anzToken = 0;
		float anzwords = 0;
		String text = "Ich und du und er und sie und es";

		Textanalyse analyse = new Textanalyse();
		anzToken = analyse.numberOfTokens(text);
		anzwords = analyse.numberOfWords(text);
		assertEquals(2.66, analyse.average(anzToken, anzwords));	
	}

	@Test
	public void testSuchenUndErsetzen() {
		String text = "Ich und du und ihr alle";
		SuchenUndErsetzen inhalt = new SuchenUndErsetzen();
		String lsg = "Ich oder du oder ihr alle";
		assertEquals(lsg, inhalt.searchAndReplace("und", "oder", text));
		
	}
	
	
	
	
}
