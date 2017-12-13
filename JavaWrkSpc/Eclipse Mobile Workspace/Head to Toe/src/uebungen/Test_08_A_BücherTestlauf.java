package uebungen;

public class Test_08_A_BücherTestlauf {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Test_08_A_Buch[] meineBücher = new Test_08_A_Buch[3];
		
		int x = 0;
		int y = 0;
		
		while (y < 3) {
			meineBücher[y] = new Test_08_A_Buch();
			y++;
		}
		
		meineBücher[0].titel = "Die Früchte von Java";
		meineBücher[1].titel = "Der Java-Gatsby";
		meineBücher[2].titel = "Das Java-Kochbuch";
		meineBücher[0].author = "richard";
		meineBücher[1].author = "susanne";
		meineBücher[2].author = "ian";
		
		while (x < 3) {
			System.out.print(meineBücher[x].titel);
			System.out.print(" von ");
			System.out.println(meineBücher[x].author);
			
			x++;
		}
		
	}

}
