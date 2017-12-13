package uebungen;

public class Test_06_B_DVDPlayerTestlauf {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Test_06_B_DVDPlayer d = new Test_06_B_DVDPlayer();
		
		d.kannAufzeichnen = true;
		
		d.dvdAbspielen();
		
		if (d.kannAufzeichnen == true) {
			d.dvdAufzeichnen();
		}
		
	}

}
