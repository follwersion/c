package dolberg_konstantin.part4;

import dolberg_konstantin.part3.ExtendedName;

public class Person {

	ExtendedName name;
	String city;

public Person(ExtendedName name, String city) {
		this.name = name;
		this.city = city;
	}

	public String toString() {
		return "Person [city=" + city + ", name=" + name + "]";
	}
		
}
