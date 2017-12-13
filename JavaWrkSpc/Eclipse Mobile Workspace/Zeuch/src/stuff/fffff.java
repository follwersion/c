package stuff;

public class fffff {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		double b = (float)(7/2);
		System.out.println(b);
		
		float c = (float)((3/2)*(8/4)*(7/2));
		System.out.println(c);
		
		byte g = (byte)(0xAE ^ 0x60);
		System.out.println(g);

		
		short h = 0xAE;
		h = (short)( ((h & 0x1E) | ((0xC) << 1)) | (h & 0xE1) );
		System.out.printf("%x %d",h,h);
		
		
		
	}

}
