package dolberg_konstantin.part2;

import _untouchable_.GK_I;

public class GK extends TK implements GK_I {

	public GK(KZ kz, Halter halter, int anzPersonen) {
		super(kz, halter, anzPersonen);
	}

	public String toString() {
		return super.toString() + String.format("GK []");
	}
}
