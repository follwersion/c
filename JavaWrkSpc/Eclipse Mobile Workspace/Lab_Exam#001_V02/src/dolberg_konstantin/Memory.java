package dolberg_konstantin;

public class Memory extends Storage {
	
	public Memory(String name, int price, String cap) {
		super(name, price, cap);
	}

	public String toString() {
		return super.toString() + String.format("Memory []");
	}
	
}
