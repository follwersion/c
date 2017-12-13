package dolberg_konstantin;

public abstract class Component {
	
	String name;
	int price;
	int cnsNo;
	static int cnsNoCounter = 1;
	
	public Component(String name, int price) {
		super();
		this.name = name;
		this.price = price;
		this.cnsNo = cnsNoCounter++;
	}

	public String toString() {
		return String.format("\nComponent [cnsNo=%s, name=%s, price=%s]", cnsNo,
				name, price);
	}
		
}
