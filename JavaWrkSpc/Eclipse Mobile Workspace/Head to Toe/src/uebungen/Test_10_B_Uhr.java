package uebungen;

public class Test_10_B_Uhr {

	String zeit;
			
	public void setZeit(String z) {
		zeit = z;
	}
	
	public String getZeit() {
		return zeit;
	}

	
	public static void main(String[] args) {
		
		Test_10_B_Uhr u = new Test_10_B_Uhr();
		
		u.setZeit("1245");
		String heute = u.getZeit();
		
		System.out.println("Zeit: " + heute);

	}

}
