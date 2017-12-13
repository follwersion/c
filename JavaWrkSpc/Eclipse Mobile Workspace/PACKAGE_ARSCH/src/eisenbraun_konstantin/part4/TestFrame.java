package eisenbraun_konstantin.part4;

import eisenbraun_konstantin.part3.ExtendedName;

public class TestFrame {

    public static void main(String[] args) {
        
        Person name1 = new Person(new ExtendedName("Schlampe", "Alex", "Eisenzwerg"), "Dorf");
        Person name2 = new Person(new ExtendedName("Hure", "Konnsen", "Knolzberg"), "Land");
        Person name3 = new Person(new ExtendedName("Drecksau", "Mike", "Hannsen"), "Stadt");
        
        System.out.println(name1);
        System.out.println(name2);
        System.out.println(name3);

    }

}
