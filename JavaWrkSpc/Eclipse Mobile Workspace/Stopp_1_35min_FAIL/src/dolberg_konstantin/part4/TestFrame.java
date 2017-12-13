package dolberg_konstantin.part4;

import dolberg_konstantin.part3.ExtendedName;

public class TestFrame {

	public static void main(String[] args) {

		Person person1 = new Person(new ExtendedName("sname1", "fname1", "titel1"), "city1");
		Person person2 = new Person(new ExtendedName("sname2", "fname2", "titel2"), "city2");
		Person person3 = new Person(new ExtendedName("sname3", "fname3", "titel3"), "city3");
		
		System.out.println(person1);
		System.out.println(person2);
		System.out.println(person3);
	}

}
