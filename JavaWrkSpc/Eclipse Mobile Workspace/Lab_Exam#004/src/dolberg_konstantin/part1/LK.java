package dolberg_konstantin.part1;

import _untouchable_.LK_I;

public class LK extends TK implements LK_I {

	public LK(KZ kz, Halter halter, int anzPersonen) {
		super(kz, halter, anzPersonen);
	}
	
	public String toString() {
		return super.toString() + String.format("LK []");
	}
}
