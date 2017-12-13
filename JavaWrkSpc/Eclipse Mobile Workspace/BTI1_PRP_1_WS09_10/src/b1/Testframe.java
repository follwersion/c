package b1;

public class Testframe {

    /**
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
        MagicList<Integer> l12 = new MagicList<Integer>();
        MagicList<Integer> l22 = new MagicList<Integer>();
        l12.putF(1);    
        l12.putF(2);    
        l12.putF(3);    
        l12.putF(4);    
        l12.putF(5);    
        l12.putF(6);    
        l12.printF2L();
        System.out.println();
       System.out.println(l22.putNo(0, l12.getL()));
        System.out.println();
        l22.printF2L();
        System.out.println();
        l12.printF2L();
     MagicList<Disc> l1 = new MagicList<Disc>();
     MagicList<Disc> l2 = new MagicList<Disc>();
     
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
     l1.printF2L();
//     l1.remove(15);
//     System.out.println();
//     l1.printF2L();
//     System.out.println();
//     l2.putF(l1.getL());
//     l2.putF(l1.getL());
//     l2.printF2L();
    
        while (!l1.isEmpty()) {
            l2.putF(l1.getL());
        }
        System.out.println();
        l2.printF2L();
        System.out.println("list2 "+l2.size());
        
        while (!l2.isEmpty()) {
            l1.putL(l2.getF());
        }
        l1.printF2L();
        System.out.println("list1 "+l1.size());
//        
     
        while (!l1.isEmpty()) {
            l2.putNo(0, l1.getL());
        }
        l2.printF2L();
        System.out.println("list2 "+l2.size());
//        
        while (!l2.isEmpty()) {
            l1.putNo(l1.size(), l2.getF());
        }
        l1.printF2L();
        System.out.println(l1.size());
//        
        while (!l1.isEmpty()) {
          l2.putNo((int) (Math.random() * l2.size()), l1.getL());
        }
        l2.printF2L();
        System.out.println(l2.size());
        while (!l2.isEmpty()) {
            Disc d = l2.peekNo((int) (Math.random() * l2.size()));
            l2.remove( d );
            l1.putNo((int) (Math.random() * l1.size()), d);
        }// while
        l1.printF2L();
        System.out.println(l1.size());
        l1.printL2F();
        System.out.println(l1.size());
        l1.printF2L();
        System.out.println(l1.size());
        l2.printF2L();
        System.out.println(l2.size());
        l2.printL2F();
        System.out.println(l2.size());
        System.out.println("-----------------------------");

    }

}
