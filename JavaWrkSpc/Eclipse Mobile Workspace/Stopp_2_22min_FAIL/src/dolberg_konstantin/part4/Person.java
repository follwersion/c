package dolberg_konstantin.part4;

import dolberg_konstantin.part3.ExtendetName;

public class Person {
	
	ExtendetName name;
	String city;
	
	public Person(ExtendetName name, String city) {
		this.name = name;
		this.city = city;
	}

	public String toString() {
		return String.format("Person [city=%s, name=%s]", city, name);
	}
	
}
