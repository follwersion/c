package dolberg_konstantin;

public class Screen extends Component {
	
	String descrip;
	
	public Screen(String name, int price, String descrip) {
		super(name, price);
		this.descrip = descrip;
	}

	public String toString() {
		return super.toString() +  String.format("Screen [descrip=%s]", descrip);
	}
	
	

}
