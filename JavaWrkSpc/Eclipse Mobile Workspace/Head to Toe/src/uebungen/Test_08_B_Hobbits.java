package uebungen;

public class Test_08_B_Hobbits {
	
	String name;
	
	public static void main(String[] args) {
		
		Test_08_B_Hobbits[] h = new Test_08_B_Hobbits[3];
		
		int z = 0;
		
		while (z < 3) {
			h[z] = new Test_08_B_Hobbits();
			h[z].name = "bilbo";
						
			if (z == 1) {
				h[z].name = "frodo";
			}
			
			if (z == 2) {
				h[z].name = "sam";
			}
			
		System.out.print(h[z].name + " ist ein ");
		System.out.println("guter Hobbit-Name");
		
		z++;
		}
		
	}

}
