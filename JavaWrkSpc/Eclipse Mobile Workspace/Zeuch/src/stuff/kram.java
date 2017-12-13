package stuff;
public class kram {
		
		public static void main(String[] args) {
			
			int x = 2;
			int y = 5;
			int xtemp = x;
				
			
			while (y != 1) {
				x = x * xtemp;
				y--;
				
			}
//			if (y == 0) {
//				x = 1;
//			}
			System.out.println("x hoch y = " + x);
			
		}
	
}


