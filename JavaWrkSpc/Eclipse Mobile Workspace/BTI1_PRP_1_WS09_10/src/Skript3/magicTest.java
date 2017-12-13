package Skript3;

public class magicTest {

    public static void main(String[] args) {

        // String auf console eigeben und wieder ausgeben
        System.out.printf("Gib zeile!                 : ");
        String s = Magic.nextLine();
        System.out.printf("Es wurde folgendes eingegeben : %s\n", s);

        // String über gui eingeben und über console ausgeben
        String s2 = Magic.getString("Gib string! :");
        System.out.println("Es wurde bla :" + s2);

        // int auf console ein- & ausgeben
        System.out.print("gib zahl! :");
        int i1 = Magic.nextInt();
        System.out.println("noch eine! :");
        int i2 = Magic.nextInt();
        System.out.printf("Die beiden Zahlen waren %d und %d.\n", i1, i2);

        // int per gui ein- und auf console ausgeben
        int i3 = Magic.getInt("Gib mir eine Zahl : ");
        int i4 = Magic.getInt("Gib mir noch eine Zahl : ");
        System.out.printf("Die beiden Zahlen waren %d und %d.\n", i3, i4);

        // gibt die aktuelle Systemzeit + datum aus
        System.out.printf("Die aktuelle Zeit ist: %s\n", Magic
                .getTimeStampString());

        // Zeit die für best. operationen gebraucht wird durch setzen von
        // markern messen
        long mark1 = Magic.getTimeStamp();
        // einmal bis zu einer Milliarde zählen
        for (long l = 0; l < 1000000000L; l++)
            ;
        long mark2 = Magic.getTimeStamp();
        // die Differenz zwischen mark2 und mark1 ist die verstrichene Zeit in
        // Millisekunden
        System.out.printf("Sie Zeit für den Abschnitt betrug %d[ms]\n", mark2
                - mark1);
    }

}
