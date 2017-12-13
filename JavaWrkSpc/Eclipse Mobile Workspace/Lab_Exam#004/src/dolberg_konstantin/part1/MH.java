package dolberg_konstantin.part1;

import _untouchable_.Halter_I;
import _untouchable_.KZ_I;
import _untouchable_.MH_I;

public abstract class MH implements MH_I {
	
	KZ kz;
	Halter halter;
	
	public MH(KZ kz, Halter halter) {
		this.kz = kz;
		this.halter = halter;
	}

	public Halter_I getHalter() {
		return this.halter;
	}

	public KZ_I getKZ() {
		return this.kz;
	}

	public String toString() {
		return String.format("MH [kz=%s, halter=%s]",kz , halter);
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((halter == null) ? 0 : halter.hashCode());
		result = prime * result + ((kz == null) ? 0 : kz.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MH other = (MH) obj;
		if (halter == null) {
			if (other.halter != null)
				return false;
		} else if (!halter.equals(other.halter))
			return false;
		if (kz == null) {
			if (other.kz != null)
				return false;
		} else if (!kz.equals(other.kz))
			return false;
		return true;
	}		
}
