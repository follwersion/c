package a06;

import static cards.Card.Constant.*;

import java.util.ArrayList;

import cards.Card;
import cards.Card.Rank;

public class a06_test {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Card [] karte = {CA,DQ,H9,HJ,CT,D8,H2}; 
        
        System.out.println(auswerten(karte));
        ArrayList <Card> blatt =new ArrayList<Card>();
        for (int i = 0; i < karte.length; i++) {
            blatt.add(karte[i]);
        }
        System.out.println(strasse(blatt));

    }
    
    public static ArrayList<Card> strasse(ArrayList<Card> k ){
        ArrayList<Card> strasse=new ArrayList<Card>();       
        int straightCounter= 0;
        Rank temp;
        temp=k.get(0).getRank();
        for (int i = 0; i < 6; i++) {
        
            for (int j = 1; j < 6; j++) {
                if(temp.decremented().equals(k.get(j).getRank())){
                    System.out.println(straightCounter);
                    straightCounter++;
                    strasse.add(k.get(j));
                    temp=k.get(j).getRank();
                }
                    
                
           
           
            }
        }
        
        return strasse;
        
    }
    
    public static ArrayList<ArrayList<Card>> auswerten(Card[] karte) {
        ArrayList<ArrayList<Card>> g = new ArrayList<ArrayList<Card>>();
        ArrayList<Card> vier = new ArrayList<Card>();
        ArrayList<Card> drei = new ArrayList<Card>();
        ArrayList<Card> zwei = new ArrayList<Card>();
        ArrayList<Card> ein = new ArrayList<Card>();
        int i = 0;
        while (i < karte.length) {
            if ((i < karte.length - 3 && karte[i].getRank().value() == karte[i + 1].getRank().value())
                    && (karte[i + 1].getRank().value() == karte[i + 2].getRank().value()) && (karte[i + 2].getRank().value() == karte[i + 3].getRank().value())) {
                vier.add(karte[i]);
                vier.add(karte[i + 1]);
                vier.add(karte[i + 2]);
                vier.add(karte[i + 3]);
                i += 4;
            } else if ((i < karte.length - 2 && karte[i].getRank().value() == karte[i + 1].getRank().value())
                    && (karte[i + 1].getRank().value() == karte[i + 2].getRank().value())) {
                drei.add(karte[i]);
                drei.add(karte[i + 1]);
                drei.add(karte[i + 2]);
                i += 3;
            } else if ((i < karte.length - 1 && karte[i].getRank().value() == karte[i + 1].getRank().value())) {
                zwei.add(karte[i]);
                zwei.add(karte[i + 1]);
                i += 2;
            } else {
                ein.add(karte[i]);
                i++;
            }
        }
        g.add(vier);
        g.add(drei);
        g.add(zwei);
        g.add(ein);
        return g;
    }

}