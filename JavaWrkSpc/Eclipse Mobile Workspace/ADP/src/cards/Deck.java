package cards;

import java.util.Collections;
import java.util.List;
import java.util.LinkedList;



public class Deck{
   
    
    //
    //
    // CONSTANTs----------------------------------------------------------------

    //private final int DECK_SIZE = 52;

    
    
    //
    //
    // VARIABLEs----------------------------------------------------------------

    private List<Card> pack1st;
    private List<Card> pack2nd;
    
    
   
    //
    //
    // CONSTRUCTORs-------------------------------------------------------------

    public Deck(){
        pack1st = new LinkedList<Card>();  // cards in game/pack
        pack2nd = new LinkedList<Card>();  // cards out of game/pack
        
        for(Card.Suit suit : Card.Suit.values()){
            for(Card.Rank rank : Card.Rank.values()){
               pack1st.add( new Card( suit, rank ) );
            }//for
        }//for
        
        Collections.shuffle( pack1st );
    }//Deck
   
    
    
    //
    //
    // METHODs------------------------------------------------------------------

    public void shuffleDeck(){
        Collections.shuffle( pack1st );
    }//shuffleDeck
   
    public Card deal(){
        if (pack1st.isEmpty()){
            System.out.printf("\n>>>> ERROR !!! : no more cards in deck - opening new pack\n");
            while(!pack2nd.isEmpty()){
                 pack1st.add( pack2nd.remove(0) );
            }//for
            shuffleDeck();
        }//if
        Card c = pack1st.remove( 0 );
        pack2nd.add( c );
        return c;
    }//deal
   
    public void removeTopCard(){
       if (pack1st.isEmpty()){
           System.out.printf("\n>>>> ERROR !!! : no more cards in deck\n");
       }else{
           pack2nd.add( pack1st.remove( 0 ) );
       }//if
    }//remove
    
    public String toString(){
        String resu = "";        
        for( Card c : this.pack1st ){
            resu = resu + c;
        }//for        
        return resu;
    }//toString

}//class Deck
