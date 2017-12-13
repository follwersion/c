package dolberg_konstantin.part1;

import _untouchable_.RH_I;

public class RH extends MH implements RH_I {

	public RH(KZ kz, Halter halter) {
		super(kz, halter);
	}

	public String toString() {
		return super.toString() + String.format("RH []");
	}	
}
