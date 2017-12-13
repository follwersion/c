package stuff;

public class asd {

	static boolean what(String s) {
		boolean wasgehtab = false;
		int j = s.length() - 1;
		for (int i = 0; i <= j; i++, j--) {
			if (s.charAt(i) == s.charAt(j)) {
				wasgehtab = true;
			} else {
				return false;
			}
		}
		return wasgehtab;
	}

	public static void main(String[] args) {

		System.out.println(what("reittier"));
		System.out.println(what("xxxxpxqxxxx"));
		System.out.println(what("eibohphobie"));
		System.out.println(what("abccdedcvba"));

	}

}
