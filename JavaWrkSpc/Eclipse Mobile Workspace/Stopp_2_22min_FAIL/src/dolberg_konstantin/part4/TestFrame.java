package dolberg_konstantin.part4;

import dolberg_konstantin.part3.ExtendetName;

public class TestFrame {

	public static void main(String[] args) {

		Person name1 = new Person((new ExtendetName("sname1","fname1","titel1")), "city1");
		Person name2 = new Person((new ExtendetName("sname2","fname2","titel2")), "city2");
		Person name3 = new Person((new ExtendetName("sname3","fname3","titel3")), "city3");
		
		System.out.println(name1);
		System.out.println(name2);
		System.out.println(name3);

	}

}
