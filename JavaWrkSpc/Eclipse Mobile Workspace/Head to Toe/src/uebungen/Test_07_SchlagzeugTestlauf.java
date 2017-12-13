package uebungen;

public class Test_07_SchlagzeugTestlauf {
	
	public static void main(String[] args) {
		
		Test_07_Schlagzeug s = new Test_07_Schlagzeug();
		
		s.spieleSnare();
		s.spieleTomTom();
		
		s.snare = false;
		
		if ( s.snare == true) {
			
			s.spieleSnare();
		}
	}

}
