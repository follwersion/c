/*
 * Praktikum: P1P
 * Semester:  WS07
 * Team:      S1T7
 * Author:    Bruns, Felix       #1907766
 *            Schulz, Thomas     #1899432
 * Aufgabe:   A4 - Texas Hold �em Endauswertung
 */

package ti1prp_.aufgabe04;

import cards.*;
import java.util.LinkedList;
import java.util.List;

public class Player {
    /*
     * cards => List of cards this player has.
     */
    private List<Card> cards;
    
    /*
     * Constructor.
     * Initializes cards.
     */
    public Player() {
        cards = new LinkedList<Card>();
    }
    
    /*
     * Gives num cards to this player.
     * Cards are taken from Deck d.
     */
    public void giveCards(Deck d, int num){
        for(int i = 0; i < num; i++){
            cards.add(d.deal());
        }
    }
    
    /*
     * Give a single card to this player.
     */
    public void giveCard(Card c){
        cards.add(c);
    }
    
    /*
     * Give a single card from a deck to this player.
     */
    public void giveCard(Deck d){
        cards.add(d.deal());
    }
    
    /*
     * Remove a card this player has.
     */
    public void removeCard(int i){
        cards.remove(i);
    }
    
    /*
     * Remove all cards this player has.
     */
    public void clearCards(){
        cards.clear();
    }
    
    /*
     * Get a single card from this player by index.
     */
    public Card getCard(int i){
        return cards.get(i);
    }
    
    /*
     * Get number of cards this player has.
     */
    public int numCards(){
        return cards.size();
    }
    
    /*
     * Convert this player to a string.
     * This returns a string of cards.
     */
    public String toString(){
        return cards.toString();
    }
}
