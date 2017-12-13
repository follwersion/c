/*
 * Praktikum:           P1P 
 * Semester:            WS09
 * Team-Name:           S3T4
 * Namen:               Dolberg, Konstantin     #1959949
 *                      Eisenbraun, Alexander   #1965085
 * Aufgaben-Nr.:        B1
 * Kontrolleur:         Behnke
 * Datum der Abnahme:   14.01.2010
 * Quellen:             URL: https://pub.informatik.haw-hamburg.de/home/pub/prof/schafers/S09W_P1/Aufgabenzettel_Nr5_v06.pdf
 */
package b1;

public class Testframe {
    
    public static void main(String[] args) throws Exception {

        MagicList<String> a = new MagicList<String>();
        
        // isEmpty() test
        if(a.isEmpty()){
            System.out.println("Liste a ist leer!");
        }
        // printF2L test
        System.out.println("putF, putL");
        a.putF("a");
        a.putL("c");
        a.putNo(1, "b");
        
        System.out.println("F2L");
        a.printF2L();
        System.out.println("L2F");
        a.printL2F();
        // peekF test
        System.out.println("peekF");
        System.out.println(a.peekF());
        // peekL test
        System.out.println("peekL");
        System.out.println(a.peekL());
        // peekNo test
        System.out.println("peekNo");
        System.out.println(a.peekNo(1));
        // getX test
        System.out.println("getF");
        System.out.println(a.getF());
        System.out.println("getL");
        System.out.println(a.getL());
        System.out.println("getNo");
        System.out.println(a.getNo(0));
        System.out.println("F2L");
        a.printF2L();
        a.putF("a");
        a.putL("c");
        a.putNo(1, "b");
        // pos test
        System.out.println("pos von b (1)");
        System.out.println(a.pos("b"));
        System.out.println("pos von z (-1)");
        System.out.println(a.pos("z"));
        // putNo test
        System.out.println("putNo von d (true & a, d, b, c)");
        System.out.println(a.putNo(1, "d"));
        a.printF2L();
        a.remove(1);
        System.out.println("putNo von z nach 124307 (false & a, b, c)");
        System.out.println(a.putNo(124307, "z"));
        a.printF2L();
        // setNo test
        System.out.println("setNo von d nach a (d, b, c)");
        a.setNo(0, "d");
        a.printF2L();
        a.setNo(0, "a");
        System.out.println("setNo von d nach a (Ausgetauschtes Element: a)");
        System.out.println(a.setNo(0, "d"));
        a.setNo(0, "a");
        System.out.println("setNo von z (null)");
        System.out.println(a.setNo(125458, "z"));
        // size test
        System.out.println("size (3)");
        System.out.println(a.size());
        // remove test
        System.out.println("remove (a, c)");
        a.remove("b");
        a.printF2L();
        a.putNo(1, "b");
        System.out.println("remove (true)");
        System.out.println(a.remove("b"));
        a.putNo(1, "b");
        System.out.println("remove (false)");
        System.out.println(a.remove("z"));
        // sublist test
        System.out.println("sublist (c, d, e)");
        a.putL("d");
        a.putL("e");
        a.sublist("c").printF2L();
        System.out.println("sublist ([])");
        a.sublist("z").printF2L();
        // sublist O1 - O2 test
        System.out.println("sublist von b bis d (b, c)");
        a.sublist("b", "d").printF2L();
        System.out.println("sublist von d bis b (b, c)");
        a.sublist("d", "b").printF2L();
        System.out.println("sublist von b bis z (Fehler)");
        a.sublist("b", "z").printF2L();
        System.out.println("sublist von z bis b (Fehler)");
        a.sublist("z", "b").printF2L();
        System.out.println("sublist von x bis z (Fehler)");
        a.sublist("x", "z").printF2L();
        System.out.println("sublist von b bis b ([])");
        a.sublist("b", "b").printF2L();
        
        
        MagicList<Disc> l1 = new MagicList<Disc>();
        MagicList<Disc> l2 = new MagicList<Disc>();       
        
    System.out.println( "-----------------------------" );
    l1.putF(new CD("Last Night", Inhalt.Audio, "Host Uwe"));
    l1.putF(new DVD("Herr der Ringe", Inhalt.Movie, Format.PAL));
    l1.putF(new DVD("Lost Highway", Inhalt.Movie, Format.PAL));
    l1.putF(new CD("Toxic", Inhalt.Audio, "Britney"));
    l1.putF(new DVD("11-14",Inhalt.Movie, Format.NTSC));
    l1.putF(new DVD("Aerobic",Inhalt.Video, Format.NTSC));
    l1.putF(new DVD("Schwarze Schafe",Inhalt.Movie, Format.PAL));
    l1.putF(new DVD("Beginner Live", Inhalt.Video, Format.PAL));
    l1.putF(new CD("Rammstein Live", Inhalt.Audio, "Rammstein"));
    l1.putF(new CD("This is it", Inhalt.Audio, "Michael Jackson"));
    
    l1.putL(new CD("Sing mit Heino", Inhalt.Audio, "Heino"));
    l1.putF(new DVD("Augsburger Puppenkiste: Urmel aus dem Eis – Gold Edition", Inhalt.Movie, Format.PAL));
    l1.putL(new CD("IV", Inhalt.Audio, "Led Zeppelin"));
    l1.putF(new DVD( "Sin City - Uncut", Inhalt.Movie, Format.NTSC));
    l1.putF(new DVD("Gone with the Wind", Inhalt.Movie, Format.PAL));
    l1.putF(new DVD("David Bowie: Best of Bowie", Inhalt.Video, Format.PAL));
    l1.printF2L(); // viel in l1 reinstecken (min. 16 Elemente)
   
    // nun testen durch „hin-und-her“-kopieren
    while ( !l1.isEmpty() ){ l2.putF( l1.getL() ); } l2.printF2L(); System.out.println( l2.size() );
    while ( !l2.isEmpty() ){ l1.putL( l2.getF() ); } l1.printF2L(); System.out.println( l1.size() );
    while ( !l1.isEmpty() ){ l2.putNo( 0, l1.getL() ); } l2.printF2L(); System.out.println( l2.size() );
    while ( !l2.isEmpty() ){ l1.putNo( l1.size(), l2.getF() ); } l1.printF2L(); System.out.println( l1.size() );
    while ( !l1.isEmpty() ){ l2.putNo( (int)( Math.random()*l2.size() ), l1.getL() ); } l2.printF2L(); System.out.println( l2.size());
    while ( !l2.isEmpty() ){
    Disc d = l2.peekNo( (int)( Math.random()*l2.size() ) );
    System.out.println(d);
    l2.remove( d );
    l1.putNo( (int)( Math.random()*l1.size() ), d );
    }//while
    l1.printF2L(); System.out.println( l1.size() );
    l1.printL2F(); System.out.println( l1.size() );
    l1.printF2L(); System.out.println( l1.size() );
    l2.printF2L(); System.out.println( l2.size() );
    l2.printL2F(); System.out.println( l2.size() );
    System.out.println( "-----------------------------" );   
    }
}