package eisenbraun_konstantin.part4;

import eisenbraun_konstantin.part3.ExtendedName;

public class Person {
    
    ExtendedName name;
    String city;
    
    public Person(ExtendedName name, String city) {
        super();
        this.name = name;
        this.city = city;
    }

    public String toString() {
        return String.format("Person [city=%s, name=%s]", city, name);
    }
    
}
