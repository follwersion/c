package dolberg_konstantin.part2;

import _untouchable_.TK_I;

public abstract class TK extends MH implements TK_I {
	
	int anzPersonen;
	
	public TK(KZ kz, Halter halter, int anzPersonen) {
		super(kz, halter);
		this.anzPersonen = anzPersonen;
	}

	public int getAnzPersonen() {
		return this.anzPersonen;
	}

	public String toString() {
		return super.toString() + String.format("TK [anzPersonen=%s]", anzPersonen);
	}

	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + anzPersonen;
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		TK other = (TK) obj;
		if (anzPersonen != other.anzPersonen)
			return false;
		return true;
	}	
}