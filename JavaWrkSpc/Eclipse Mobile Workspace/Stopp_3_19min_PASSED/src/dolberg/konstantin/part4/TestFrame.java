package dolberg.konstantin.part4;

import dolberg.konstantin.part3.ExtendedName;

public class TestFrame {

	public static void main(String[] args) {

		Person name1 = new Person(new ExtendedName("SName1", "FName1", "Titel1"), "City1");
		Person name2 = new Person(new ExtendedName("SName2", "FName2", "Titel2"), "City2");
		Person name3 = new Person(new ExtendedName("SName3", "FName3", "Titel3"), "City3");
		
		System.out.println(name1);
		System.out.println(name2);
		System.out.println(name3);

	}

}
