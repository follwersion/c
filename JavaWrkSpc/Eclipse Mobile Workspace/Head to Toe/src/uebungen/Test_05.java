package uebungen;

public class Test_05 {

	public static void main(String[] args) {

		int x = 0;

		while (x < 4) {

			System.out.print("da");

			if (x < 1) {
				System.out.print(" ");
			}
			System.out.print("s");

			if (x > 0) {
				System.out.print("");
				x = x - 1;
			}

			if (x == 1) {
				System.out.print("itzend");
			}

			if (x > 1) {
				System.out.print(" kind");
			}

			System.out.println("");							
			x = x + 2;
		}

	}

}
//Ziehl: 
//da sagt
//dasitzend
//das kind