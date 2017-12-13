package _untouchable_;

import java.util.*;

//ZulasungsStelle
public interface ZS1_I {                    // ZS Interface fuer Teilaufgabe 1
    void clear();                           // Loeschen aller erfassten MobilitaetsHilfen
    void add( MH_I mh );                    // Hinzufuegen einer MobilitaetsHilfe
    int noMH();                             // Anzahl erfasster MobilitaetsHilfen
    Halter_I findHalter ( KZ_I kz );        // ueber gegebenes Kennzeichen identifizierter Halter
    Map<KZ_I,MH_I> getMAP();                // Map ueber alle MobilitaetsHilfen mit ihrem Kennzeichen als Schluessel
    void printAll();                        // Ausgabe aller erfassten MobilitaetsHilfen
}
