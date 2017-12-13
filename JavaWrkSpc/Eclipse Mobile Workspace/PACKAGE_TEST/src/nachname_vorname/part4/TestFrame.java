package nachname_vorname.part4;

import nachname_vorname.part3.ExtendedName;

public class TestFrame {

    /**
     * @param args
     */
    public static void main(String[] args) {
      Person pers1 = new Person (new ExtendedName("Peter", "Petersen", "Prof."), "Hamburg");
      Person pers2 = new Person (new ExtendedName("Peter", "Peters", "Prof."), "Hamburg");
      Person pers3 = new Person (new ExtendedName("Hans", "Hansen", "Prof."), "Hamburg");
      System.out.println(pers1);
    }

}
