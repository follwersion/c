package uebungen;

public class Test_10_A_XKopie {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int orig = 42;
		
		Test_10_A_XKopie x = new Test_10_A_XKopie();
		
		int y = x.los(orig);
		
		System.out.println(orig + " " + y);
		
	}

	int los(int arg) {

		arg = arg * 2;
		
		return arg;
	}
	
	

}
