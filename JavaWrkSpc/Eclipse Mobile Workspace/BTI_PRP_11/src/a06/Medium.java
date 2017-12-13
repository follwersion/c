package a06;

public abstract class Medium implements Comparable<Medium> {

	/**
	 * @author Lukas Lukowski Konstantin Dolberg Datum 04.05.09 Aufgabe 6
	 */

	private String title;
	private String release;

	protected Medium(String title, String release) {
		super();
		this.title = title;
		this.release = release;
	}

	public String toString() {
		return "\nEigenschaften des Objekts X\nTitel: " + this.getTitle()
				+ "\nErscheinungsjahr: " + this.getRelease() + "\n";
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setRelease(String release) {
		this.release = release;
	}

	public String getRelease() {
		return release;
	}

	@Override
	public int compareTo(Medium medium) {
		int result = 0;

		if (Integer.parseInt(medium.getRelease()) > Integer.parseInt(this
				.getRelease())) {
			result = 1;
		}
		if (Integer.parseInt(medium.getRelease()) < Integer.parseInt(this
				.getRelease())) {
			result = -1;
		}

		return result;
	}

	@Override
	public boolean equals(Object obj) {
//		if (obj instanceof Medium) {
//			return this.compareTo((Medium) obj) == 0 ? true : false;
//		}
//		return false;
		
		return obj instanceof Medium ? this.compareTo((Medium)obj) == 0 ? true:false:false;
	}
	
	//Überladen
	public boolean equals(Medium obj) {
		return this.compareTo(obj) == 0 ? true : false;
	}
}
