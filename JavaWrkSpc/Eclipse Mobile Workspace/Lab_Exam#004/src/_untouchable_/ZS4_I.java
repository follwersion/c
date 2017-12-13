package _untouchable_;

import java.util.*;

//ZulasungsStelle
public interface ZS4_I {                    // ZS Interface fuer Teilaufgabe 4
    void clear();                           // Loeschen aller erfassten MobilitaetsHilfen
    void add( MH3_I mh );                   // Hinzufuegen einer MobilitaetsHilfe
    void del( MH3_I mh ) throws Exception;  // Loeschen einer MobilitaetsHilfe
    int noMH();                             // Anzahl erfasster MobilitaetsHilfen
    Halter_I findHalter( KZ3_I kz );        // ueber gegebenes Kennzeichen identifizierter Halter
    Set<KZ3_I> findKZ( Halter_I h );        // alle Kennzeichen eines gegebenen Halters
    Map<KZ3_I,MH3_I> getMAP();              // Map ueber alle MobilitaetsHilfen mit ihrem Kennzeichen als Schluessel
    void printAll();                        // Ausgabe aller erfassten MobilitaetsHilfen
}
