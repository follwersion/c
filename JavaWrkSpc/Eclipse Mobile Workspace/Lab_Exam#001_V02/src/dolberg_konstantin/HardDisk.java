package dolberg_konstantin;

public class HardDisk extends Storage {
	
	int heads;
	
	//enum HDI {IDE, ATA, SATA, SCSI, USB};
	HDI intf;

	public HardDisk(String name, int price, String cap, int heads, HDI intf) {
		super(name, price, cap);
		this.heads = heads;
		this.intf = intf;
	}

	public String toString() {
		return super.toString() + String.format("HardDisk [heads=%s, intf=%s]", heads, intf);
	}

}
