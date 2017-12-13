package stuff;

/**
 * @param args
 */

public class no8_1 {
	public static void main(String[] args) {
		Q q = new Q();
		System.out.println(q);
		q.o();
		L l = new P();
		System.out.println(l);
		l.o();
		K k = (P) l;
		System.out.println(k);
		k.o();
		l = q;
		((Q) l).r();
		System.out.println(l);
	}
}
	static class L {
		static void c() {
			System.out.println("Lc");
		}

		void o() {
			System.out.println("Lo");
		}

		public String toString() {
			return "L2S";
		}
	}

	class Q extends L {
		void r() {
			System.out.println("Qr");
		}

		public String toString() {
			return "Q2S";
		}
	}

	class K extends L {
		void o() {
			System.out.println("Ko");
		}

		public String toString() {
			return "K2S";
		}
	}

	class P extends K {
		void o() {
			System.out.println("Po");
		}

		public String toString() {
			return "P2S";
		}
	}

