package part1;

public class Processor extends Component {
	
	String freq;

	public Processor(String name, int price, String freq) {
		super(name, price);
		this.freq = freq;
	}

	public String toString() {
		return super.toString() + String.format("Processor [freq=%s]", freq);
	}	
}