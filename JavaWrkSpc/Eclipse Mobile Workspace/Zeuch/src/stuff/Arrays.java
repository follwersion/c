package stuff;

public class Arrays {

	public static void main(String[] args) {

		int [] a1 = {1,2,3,4,5};
		
		int [] a2 = new int [] {1,2,3,4,5};
		
		int [] a3 = new int [4];
		for (int i = 0; i < a3.length; i++) {
			a3[i] = i+1;
		}
		
		// Summe aller elemente brechnen
		int erg = 0;
		for (int i = 0; i < a1.length; i++) {
			erg += a1[i];
		}
		System.out.println(erg);
		
		System.out.println("**************");
		
		int erg2 = 1;
		for (int i = 0; i < a1.length; i++) {
			erg2 *= a1[i];
		}
		System.out.println(erg2);
		
		System.out.println("**************");

		

	}

}
