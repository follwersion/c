package uebungen;

public class Test_06_A_KassettenRekorderTestlauf {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Test_06_A_KassettenRekorder kr = new Test_06_A_KassettenRekorder();
		
		kr.kannAufzeichnen = true;
		kr.kassetteAbspielen();
		
		if (kr.kannAufzeichnen == true) {
			kr.kassetteAufzeichnen();
		}

	}

}
