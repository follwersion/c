package dolberg_konstantin.part1;

import _untouchable_.KK_I;

public class KK extends TK implements KK_I {

	public KK(KZ kz, Halter halter, int anzPersonen) {
		super(kz, halter, anzPersonen);
	}

	public String toString() {
		return super.toString() + String.format("KK []");
	}
}
