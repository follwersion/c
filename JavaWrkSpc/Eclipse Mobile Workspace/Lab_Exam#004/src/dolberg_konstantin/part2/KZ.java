package dolberg_konstantin.part2;

import _untouchable_.KZ3_I;
import _untouchable_.KZ_I;

public class KZ implements KZ3_I {
	
	String kng;

	public KZ(String kng) {
		this.kng = kng;
	}

	public String getKZ() {
		return this.kng;
	}

	public String toString() {
		return String.format("KZ [kng=%s]", kng);
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kng == null) ? 0 : kng.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KZ other = (KZ) obj;
		if (kng == null) {
			if (other.kng != null)
				return false;
		} else if (!kng.equals(other.kng))
			return false;
		return true;
	}	
}
