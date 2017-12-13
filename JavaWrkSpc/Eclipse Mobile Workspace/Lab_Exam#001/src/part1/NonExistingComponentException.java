package part1;

public class NonExistingComponentException extends IndexOutOfBoundsException {
	
//	static String fehlermeldung = "Angebene Position ist ung�ltig!";
	int index;
	
	public NonExistingComponentException(int index) {
//		  super("Angebene Position ist ung�ltig! Fehlerhafter Index Nr.: " + index + " - F�r element Nr.: " + (index - 1));
		super("Angebene Position ist ung�ltig!");
		this.index = index;
	}
	
	public String toString(){
		return super.toString() + " Fehlerhafter Index Nr.: " + index + " - F�r element Nr.: " + (index - 1);
	}	
}