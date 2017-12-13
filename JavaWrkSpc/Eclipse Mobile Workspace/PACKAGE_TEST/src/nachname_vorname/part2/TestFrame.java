package nachname_vorname.part2;

import _untouchable_.Name;

public class TestFrame {
    public static void main(String[] args) {
        Name name1 = new Name("Horst","Hansen");
        Name name2 = new Name("Peter","Pansen");
        Name name3 = new Name("Uwe","Gans");
        name1.printName();
        name2.printName();
        name3.printName();
    }

}
