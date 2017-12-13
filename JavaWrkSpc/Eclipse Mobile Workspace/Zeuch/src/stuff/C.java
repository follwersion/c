package stuff;

public class C {
	Integer i1;
	Integer i2;

	C(Integer i1, Integer i2) {
		this.i1 = i1;
		this.i2 = i2;
	}

	boolean m() throws EqualException {
		if (i1.intValue() < i2.intValue())
			return false;
		else if (i2.intValue() < i1.intValue())
			return true;
		else {
			throw new EqualException();
		}
	}
}