package inDerVorlesung;

public class Test091015_Medaille {
    
    public static void main(String[] args) {
        
        int    punkte;   // Punkte die Teilnehmer im Wettkampf erworben hat
        int    alter;    // Alter des jeweiligen Teilnehmers
        String medaille; // Medaille, die jeweilgem Teilnehmer ausgehändigt wird
        
        
        // Initialisierung
        medaille = "keine";
        punkte   = 4567;
        alter    = 13;
        
        
        
        // Hier kommt Ihr Code hin.
        //
        // ...
        //
        // "Irgendwo" müssen Sie der Medaille den richtigen Wert zu weisen.        
        medaille = "GOLD";    // Medaille auf Gold setzen
        medaille = "SILBER";  // Medaille auf Silber setzen
        medaille = "BRONZE";  // Medaille auf Bronze setzen
        //
        // ...
        //
        
        
        
        // Zum Schluss / nach Ihrem Code erfolgt die Ausgabe
        System.out.printf("Der Teilnehmer mit dem Alter %d bekommt eine %s-Medaille für %d Punkte.\n", alter, medaille, punkte);
        
    }//main
    
}//Test091015_Medaille
