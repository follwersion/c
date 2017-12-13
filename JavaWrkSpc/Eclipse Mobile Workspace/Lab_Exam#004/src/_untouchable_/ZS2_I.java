package _untouchable_;

import java.util.*;

//ZulasungsStelle
public interface ZS2_I {                    // ZS Interface fuer Teilaufgabe 2
    void clear();                           // Loeschen aller erfassten MobilitaetsHilfen
    void add( MH_I mh );                    // Hinzufuegen einer MobilitaetsHilfe
    int noMH();                             // Anzahl erfasster MobilitaetsHilfen
    Halter_I findHalter( KZ_I kz );         // ueber gegebenes Kennzeichen identifizierter Halter
    Set<KZ_I> findKZ( Halter_I h );         // alle Kennzeichen eines gegebenen Halters
    Map<KZ_I,MH_I> getMAP();                // Map ueber alle MobilitaetsHilfen mit ihrem Kennzeichen als Schluessel
    void printAll();                        // Ausgabe aller erfassten MobilitaetsHilfen
}
