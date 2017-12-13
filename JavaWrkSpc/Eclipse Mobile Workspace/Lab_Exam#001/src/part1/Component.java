package part1;

public abstract class Component {
	
	String name;
	int price;
	int cnsNo = 1;
	static int cnsNoTemp;
		
	public Component(String name, int price) {
		super();
		this.name = name;
		this.price = price;
		this.cnsNo = cnsNoTemp++;
	}

	public String toString() {
		return String.format("\nComponent [name=%s, price=%s, cnsNo=%s]", name, price, cnsNo);
	}		
}