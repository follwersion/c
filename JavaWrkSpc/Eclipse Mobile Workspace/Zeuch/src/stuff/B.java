package stuff;

public class B {
	static void m(Integer x, Integer y) {
		try {
			C c = new C(x, y);
			if (c.m())
				System.out.printf("B: %d < %d\n", y, x);
			else
				System.out.printf("B: %d < %d\n", x, y);
		} catch (NullPointerException e) {
			System.out.printf("B: %s\n", e.getMessage());
		} catch (EqualException e) {
			System.out.printf("B: %s\n", e.getMessage());
		} finally {
			System.out.printf("B: THE END\n");
		}
	}
}