package magicList;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			MagicList<Integer> test = new MagicList<Integer>();
			
			test.addLast(8);
			test.addLast(150);

			System.out.println(test);
			test.addFirst(2);
			test.addFirst(5);
			
			System.out.println(test);
	}

}
