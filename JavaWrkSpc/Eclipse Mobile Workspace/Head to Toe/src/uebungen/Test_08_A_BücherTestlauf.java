package uebungen;

public class Test_08_A_B�cherTestlauf {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Test_08_A_Buch[] meineB�cher = new Test_08_A_Buch[3];
		
		int x = 0;
		int y = 0;
		
		while (y < 3) {
			meineB�cher[y] = new Test_08_A_Buch();
			y++;
		}
		
		meineB�cher[0].titel = "Die Fr�chte von Java";
		meineB�cher[1].titel = "Der Java-Gatsby";
		meineB�cher[2].titel = "Das Java-Kochbuch";
		meineB�cher[0].author = "richard";
		meineB�cher[1].author = "susanne";
		meineB�cher[2].author = "ian";
		
		while (x < 3) {
			System.out.print(meineB�cher[x].titel);
			System.out.print(" von ");
			System.out.println(meineB�cher[x].author);
			
			x++;
		}
		
	}

}
