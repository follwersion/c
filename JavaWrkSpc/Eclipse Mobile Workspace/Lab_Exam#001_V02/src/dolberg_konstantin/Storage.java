package dolberg_konstantin;

public abstract class Storage extends Component {
	
	String cap;

	public Storage(String name, int price, String cap) {
		super(name, price);
		this.cap = cap;
	}

	public String toString() {
		return super.toString() + String.format("Storage [cap=%s]", cap);
	}
	
}
