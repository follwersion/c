/*
 * Praktikum: P1P
 * Semester:  WS07
 * Team:      S1T7
 * Author:    Bruns, Felix       #1907766
 *            Schulz, Thomas     #1899432
 * Aufgabe:   A4 - Texas Hold �em Endauswertung
 */

package ti1prp_.aufgabe04;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import cards.Card;
public class Hand {
    /*
     * cards                    => List of cards in hand.
     * combi                    => List which holds the best combination of cards.
     * kicker                   => List of kickers.
     * handRank                 => Rank of this hand (See HandType enum).
     * suitCounts               => Array which contains counts of suits (Club, Diamond, Heart, Spades).
     * rankCounts               => Array which contains counts of ranks in hand.
     * flusRanks                => Array which contains counts of ranks in hand that are of the flush suit.
     * kickers                  => Array containing kickers for comparison.
     * straightHighCard         => High card of straight, straight flush or royal flush.
     * mostFrequentRank         => Index of the rank with the maximum count.
     * secondMostFrequentRank   => Index of the rank with the second max count.
     * flushSuit                => Suit of flush or royal flush.
     */
    private List<Card> cards;
    private List<Card> combi;
    private List<Card> kicker;
    private HandRank handRank;
    private int suitCounts[] = new int[Card.Suit.values().length];
    private int rankCounts[] = new int[Card.Rank.values().length];
    private boolean flushRanks[] = new boolean[Card.Rank.values().length];
    private int kickers[] = new int[0];
    private int straightHighCard = -1;
    private int mostFrequentRank;
    private int secondMostFrequentRank;
    private int flushSuit;
    
    /*
     * enum which holds all possible hand ranks.
     */
    public enum HandRank {
        ROYALFLUSH,
        STRAIGHTFLUSH,
        FOUROFAKIND,
        FULLHOUSE,
        FLUSH,
        STRAIGHT,
        THREEOFAKIND,
        TWOPAIR,
        PAIR,
        HIGHCARD;
        
        /*
         * Converts hand rank to string.
         */
        public String toString(){
            String str;
            
            switch(this) {
                case ROYALFLUSH    : str = "Royal Flush"; break;
                case STRAIGHTFLUSH : str = "Straight Flush"; break;
                case FOUROFAKIND   : str = "Four of a kind"; break;
                case FULLHOUSE     : str = "Full House"; break;
                case FLUSH         : str = "Flush"; break;
                case STRAIGHT      : str = "Straight"; break;
                case THREEOFAKIND  : str = "Three of a kind"; break;
                case TWOPAIR       : str = "Two pair"; break;
                case PAIR          : str = "Pair"; break;
                case HIGHCARD      : str = "Highcard"; break;
                default            : str = "?";
            }
            
            return str;
        }
    }
    
    /*
     * Constructor of Hand class.
     * Takes a community and a player as arguments
     * in order to add their cards to the hands card list.
     */
    public Hand(Community c, Player p){
        cards = new LinkedList<Card>();
        combi = new LinkedList<Card>();
        kicker = new LinkedList<Card>();
        
        for(int i = 0; i < 5; i++){
            cards.add(c.getCard(i));            
        }
        for(int i = 0; i < 2; i++){
            cards.add(p.getCard(i));
        }
        
        analyze();
    }
    
    /*
     * Analyze hand (Count suits and ranks,
     * get most frequent and second most frequent
     * rank, and finally get the hands rank by
     * checking for combinations).
     */
    public void analyze(){
        for(int i = 0; i < cards.size(); i++){
            suitCounts[cards.get(i).getSuit().ordinal()]++;
            rankCounts[cards.get(i).getRank().ordinal()]++;
        }
        
        mostFrequentRank = getMostFrequentRank();
        secondMostFrequentRank = getSecondMostFrequentRank();
        handRank = getHandRank();
    }
    
    /*
     * Returns a list of kickers for this hand.
     */
    public List<Card> getKickers(){
        return kicker;
    }
    
    /*
     * Returns the winning combination.
     */
    public List<Card> getCombination(){
        combi.clear();
        kicker.clear();
        
        /*
         * If it's a flush, add all cards which are of flushSuit,
         */
        if(handRank.equals(HandRank.FLUSH)){
            for(int i = 0; i < cards.size(); i++){
                if(cards.get(i).getSuit().ordinal() == flushSuit && combi.size() < 5){
                    combi.add(cards.get(i));
                }
            }
            Collections.sort(combi);
            return combi;
        }
        /*
         * For straights, add all cards in a row starting from straightHighCard.
         * Special case: A 2 3 4 5. If this is the case, add the A first.
         */        
        else if(handRank.equals(HandRank.STRAIGHT) ||
                handRank.equals(HandRank.STRAIGHTFLUSH) ||
                handRank.equals(HandRank.ROYALFLUSH)){
            int j = 4;
            Collections.sort(cards);
            /*
             * This is for handling the special case mentioned above.
             */
            for(int i = 0; i < cards.size(); i++){
                if(straightHighCard == 3 && cards.get(i).getRank() == Card.Rank.ACE){
                    combi.add(cards.get(i));
                    j--;
                }
            }
            /*
             * Now add cards which are in a row.
             */
            for(int i = 0; i < cards.size(); i++){
                if(cards.get(i).getRank().ordinal() == straightHighCard - j){
                    if(handRank.equals(HandRank.STRAIGHT) && combi.size() < 5){
                        combi.add(cards.get(i));
                    }
                    else if(cards.get(i).getSuit().ordinal() == flushSuit && combi.size() < 5){                  
                        combi.add(cards.get(i));
                    }
                    j--;
                }
            }
            Collections.sort(combi);
            return combi;
        }
        /*
         * For other combinations just add the cards with rank equal to mostFrequentRank
         * or secondMostFrequentRank (this depends on the combination again (Pair, Two Pair, etc.).
         * Also add cards to the kicker list by taking the highest cards that are not in the combination.
         */
        else {
            for(int i = 0; i < cards.size(); i++){
                if(cards.get(i).getRank().ordinal() == mostFrequentRank && combi.size() < 5){
                    combi.add(cards.get(i));
                }
                else if(cards.get(i).getRank().ordinal() != secondMostFrequentRank && !handRank.equals(HandRank.TWOPAIR)){
                    kicker.add(cards.get(i));
                }
            }
            if(handRank.equals(HandRank.FULLHOUSE) ||
                    handRank.equals(HandRank.TWOPAIR)){
                for(int i = 0; i < cards.size(); i++){
                    if(cards.get(i).getRank().ordinal() == secondMostFrequentRank && combi.size() < 5){
                        combi.add(cards.get(i));
                    }
                    else if(cards.get(i).getRank().ordinal() != mostFrequentRank){
                        kicker.add(cards.get(i));
                    }
                }
            }
        }
        
        /*
         * Sort everything and remove kickers that would extend the combination above 5.
         */
        Collections.sort(kicker);
        while(kicker.size() > 5 - combi.size()) kicker.remove(0);
        Collections.reverse(kicker);
        Collections.sort(combi);
        return combi;
    }
    
    /*
     * Gets the most frequent rank in rankCounts.
     */
    public int getMostFrequentRank(){
        int max = -1;
        
        for(int i = rankCounts.length - 1; i >= 0; i--){
            if(max == -1 || rankCounts[i] >= rankCounts[max]){
                max = i;
            }
        }
        
        return max;
    }

    /*
     * Gets the second most frequent rank in rankCounts.
     */
    public int getSecondMostFrequentRank(){
        int max = -1;
        int max2 = -1;
        
        for(int i = rankCounts.length - 1; i >= 0; i--){
            if(max == -1 || rankCounts[i] >= rankCounts[max]){
                max2 = max;
                max = i;
            }
            else if(max2 == -1 || rankCounts[i] >= rankCounts[max2]){
                max2 = i;
            }
        }
        
        return max2;
    }
    
    /*
     * Tests for a flush, determines flushSuit and then sets booleans in flushRanks.
     */
    public boolean isFlush(){
        for(int i = 0; i < suitCounts.length; i++){
            if(suitCounts[i] >= 5){
                flushSuit = i;
                for(int j = 0; j < cards.size(); j++){
                    if(cards.get(j).getSuit().ordinal() == flushSuit){
                        flushRanks[cards.get(j).getRank().ordinal()] = true;
                    }
                    else {
                        flushRanks[cards.get(j).getRank().ordinal()] = false;
                    }
                }
                return true;
            }
        }
        return false;
    }
    
    /*
     * Tests for a straight by looping through the cards starting with A.
     * Also handles the special case: A 2 3 4 5.
     */
    public boolean isStraight(){
        int c = 0;
        for(int i = rankCounts.length - 1; i >= 0; i--){
            if(rankCounts[i] > 0){
                c++;
                if(c == 5){
                    straightHighCard = i + 4;
                    return true;
                }
            }
            else{
                c = 0;                   
            }
        }
        if(c == 4 && rankCounts[Card.Rank.ACE.ordinal()] > 0){
            straightHighCard = Card.Rank.FIVE.ordinal();
            return true;
        }
        return false;
    }
    
    /*
     * Tests for a straight flush.
     * This is basically a combination of isFlush and isStraight.
     */
    public boolean isStraightFlush(){
        int c = 0;
        for(int i = 0; i < suitCounts.length; i++){
            if(suitCounts[i] >= 5){
                flushSuit = i;
                for(int j = 0; j < cards.size(); j++){
                    flushRanks[cards.get(j).getRank().ordinal()] =
                        (cards.get(j).getSuit().ordinal() == flushSuit)?true:false;
                }
            }
        }
        for(int i = flushRanks.length - 1; i >= 0; i--){
            if(flushRanks[i]){
                c++;
                if(c == 5){
                    straightHighCard = i + 4;
                    return true;
                }
            }
            else{
                c = 0;                   
            }
        }
        if(c == 4 && flushRanks[Card.Rank.ACE.ordinal()]){
            straightHighCard = 3;
            return true;            
        }
        return false;
    }
    
    /*
     * Tests for four of a kind. Self explaining.
     * Calls otherKickers to get kicker.
     */
    public boolean isFourOfAKind(){
        if(rankCounts[mostFrequentRank] == 4){
            otherKickers();
            return true;
        }
        return false;
    }

    /*
     * Tests for full house. Self explaining.
     */
    public boolean isFullHouse(){
        if(rankCounts[mostFrequentRank] == 3 && rankCounts[secondMostFrequentRank] >= 2){
            return true;
        }
        return false;
    }
    
    /*
     * Tests for three of a kind. Self explaining.
     * Calls otherKickers to get kickers.
     */
    public boolean isThreeOfAKind(){
        if(rankCounts[mostFrequentRank] == 3){
            otherKickers();
            return true;
        }
        return false;
    }
    
    /*
     * Tests for two pair. Self explaining.
     * Calls twoPairKickers to get kickers.
     */
    public boolean isTwoPair(){
        if(rankCounts[mostFrequentRank] == 2 && rankCounts[secondMostFrequentRank] == 2){
            twoPairKickers();
            return true;
        }
        return false;
    }
    
    /*
     * Tests for pair. Self explaining.
     * Calls otherKickers to get kickers.
     */
    public boolean isPair(){
        if(rankCounts[mostFrequentRank] == 2){
            otherKickers();
            return true;
        }
        return false;
    }
    
    /*
     * Gets kicker for two pair.
     * Needs to be a separate method, because it also
     * checks if card is not of secondMostFrequentRank.
     */
    public void twoPairKickers(){
        kickers = new int[1];
        for(int i = rankCounts.length - 1; i >= 0; i--){
            if(i != mostFrequentRank && i != secondMostFrequentRank && rankCounts[i] > 0){
                kickers[0] = i;
                return;
            }
        }
    }
    
    /*
     * Gets kickers for other combinations.
     */
    public void otherKickers(){
        kickers = new int[5 - rankCounts[mostFrequentRank]];
        int c = 0;
        for(int i = rankCounts.length - 1; i >= 0; i--){
            if(i != mostFrequentRank && rankCounts[i] > 0){
                kickers[c++] = i;
                if(c == kickers.length){
                    return;
                }
            }
        }
    }
    
    /*
     * Calls methods to check for different combinations
     * and on success returns the HandRank.
     */
    public HandRank getHandRank(){
        if(isStraightFlush() && straightHighCard == Card.Rank.ACE.ordinal()){
            return HandRank.ROYALFLUSH;
        }
        else if(isStraightFlush()){
            return HandRank.STRAIGHTFLUSH;
        }
        else if(isFourOfAKind()){
            return HandRank.FOUROFAKIND;
        }
        else if(isFullHouse()){
            return HandRank.FULLHOUSE;
        }
        else if(isFlush()){
            return HandRank.FLUSH;
        }
        else if(isStraight()){
            return HandRank.STRAIGHT;
        }
        else if(isThreeOfAKind()){
            return HandRank.THREEOFAKIND;
        }
        else if(isTwoPair()){
            return HandRank.TWOPAIR;
        }
        else if(isPair()){
            return HandRank.PAIR;
        }
        
        otherKickers();
        return HandRank.HIGHCARD;
    }
    
    /*
     * Compares this hand to a hand give by argument.
     * First comparing by the hands ranks,
     * then by combination specific values
     * (straight high card, higher cards).
     * Finally compares by kickers.
     */
    public int compareTo(Hand hand){
        if(handRank.ordinal() > hand.handRank.ordinal())
            return -1;
        else if(handRank.ordinal() < hand.handRank.ordinal())
            return 1;
        else{
            if(handRank.equals(HandRank.STRAIGHTFLUSH) ||
               handRank.equals(HandRank.STRAIGHT)){
                if(straightHighCard > hand.straightHighCard) return 1;
                if(straightHighCard < hand.straightHighCard) return -1;
                else return 0;
            }
            else if(handRank.equals(HandRank.FLUSH)){
                int n = 0;
                for(int i = Card.Rank.values().length - 1; i >= 0; i--){
                    if(flushRanks[i]){
                        if(hand.flushRanks[i]){
                            n++;
                            if(n == 5){
                                return 0;
                            }
                        }
                        else {
                            return 1;                            
                        }
                    }
                    else if(hand.flushRanks[i]){
                        return -1;
                    }
                }
                return 0;
            }
            else if(handRank.equals(HandRank.FOUROFAKIND) ||
                    handRank.equals(HandRank.THREEOFAKIND) ||
                    handRank.equals(HandRank.PAIR) ||
                    handRank.equals(HandRank.HIGHCARD)){
                if(mostFrequentRank > hand.mostFrequentRank) return 1;
                if(mostFrequentRank < hand.mostFrequentRank) return -1;
                for(int i = 0; i < kickers.length; i++){
                    if(kickers[i] > hand.kickers[i]) return 1;
                    if(kickers[i] < hand.kickers[i]) return -1;
                }
                return 0;
            }
            else if(handRank.equals(HandRank.FULLHOUSE) ||
                    handRank.equals(HandRank.TWOPAIR)){
                if(mostFrequentRank > hand.mostFrequentRank) return 1;
                if(mostFrequentRank < hand.mostFrequentRank) return -1;
                if(secondMostFrequentRank > hand.secondMostFrequentRank) return 1;
                if(secondMostFrequentRank < hand.secondMostFrequentRank) return -1;
                for(int i = 0; i < kickers.length; i++){
                    if(kickers[i] > hand.kickers[i]) return 1;
                    if(kickers[i] < hand.kickers[i]) return -1;
                }
                return 0;
            }
        }
        
        return 0;
    }
    
    /*
     * Simply compares the two hands given by argument.
     * Defined a static to be accessible by Hand.compare(arg1, arg2);
     */
    public static int compare(Hand one, Hand two){
        return one.compareTo(two);
    }
}
