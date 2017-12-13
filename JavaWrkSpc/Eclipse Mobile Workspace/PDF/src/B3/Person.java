package nachname_vorname.part4;

import nachname_vorname.part3.ExtendedName;

public class Person {
    ExtendedName name;
    String city;
    
    public Person(ExtendedName name, String city) {
     this.name=name;
     this.city=city;
    }

    
    public String toString() {
        return String.format("(Person) [%s city=%s]", name,city);
    }

}
