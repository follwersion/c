package part1;

public class NonExistingComponentException extends IndexOutOfBoundsException {
	
//	static String fehlermeldung = "Angebene Position ist ungültig!";
	int index;
	
	public NonExistingComponentException(int index) {
//		  super("Angebene Position ist ungültig! Fehlerhafter Index Nr.: " + index + " - Für element Nr.: " + (index - 1));
		super("Angebene Position ist ungültig!");
		this.index = index;
	}
	
	public String toString(){
		return super.toString() + " Fehlerhafter Index Nr.: " + index + " - Für element Nr.: " + (index - 1);
	}	
}