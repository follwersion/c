package stuff;

public class iterations {

	public static void main (String [] args) {
		
		// Werte von 1 bis 10
		
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);			
		}
		System.out.println("*************");
		
		int i2 = 1;
		while (i2 <= 10) {
			System.out.println(i2);
			i2++;
		}
		System.out.println("*************");
		
		int i3 = 1;
		if (i3 <= 10) {
			do {
				System.out.println(i3);
				i3++;
			} while (i3 <= 10);
		}
		System.out.println("*************");
		
		int n = 6;
		for (int i = 3; i <= n; i++) {
			System.out.println(i);
		}
		System.out.println("*************");
		
		int i4 = 3;
		while (i4 <= n) {
			System.out.println(i4);
			i4++;
		}
		System.out.println("*************");
		
		int i5 = 3;
		if (i5 <= n) {
			do {
				System.out.println(i5);
				i5++;
			} while (i5 <= n);
		}
		System.out.println("*************");
		
		// Werte in 3er schritten
		int n2 = 10;
		int x = 1;
		for (int i = 4; i <= n2; i += 3) {
			if (x == 1) {
				System.out.print(i);
				x++;
			} else {
				System.out.print("," + i);
			}
		}
		System.out.println("\n*************");
		
		int i6 = 4;
		while (i6 <= n2) {
			System.out.println(i6);
			i6+=3;
		}
		System.out.println("*************");
		
		int i7 = 4;
		if (i7 <= n2) {
			do {
				System.out.println(i7);
				i7+=3;
			} while (i7 <= n2);
		}
		System.out.println("*************");
				
	}
}
