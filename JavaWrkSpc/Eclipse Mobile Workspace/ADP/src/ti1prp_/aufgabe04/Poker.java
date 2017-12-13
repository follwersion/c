/*
 * Praktikum: P1P
 * Semester:  WS07
 * Team:      S1T7
 * Author:    Bruns, Felix       #1907766
 *            Schulz, Thomas     #1899432
 * Aufgabe:   A4 - Texas Hold ’em Endauswertung
 */

package ti1prp_.aufgabe04;

import java.util.Scanner;

import cards.*;

public class Poker {
    /*
     * Players, Community, Deck and Player hands.
     * num_players => Number of players.
     * Set test to true, to run a test case.
     */
    private static Player players[];
    private static Community community;
    private static Deck deck;
    private static Hand hands[];
    private static int num_players = 4;
    private static boolean test = true;
    private static int index[], split = 0;
    
    /* 
     * Determines which player wins by comparing their hands.
     * Also handles split pot between two players.
     */
    public static void getWinner(){
        index = new int[num_players];
        for(int i = 0; i < num_players; i++){
            index[i] = -1;
        }
        
        for(int i = 0; i < hands.length; i++){
            if(index[0] == -1 || hands[i].compareTo(hands[index[0]]) == 1){
                split = 0;
                index[0] = i;
                for(int j = 1; j < num_players; j++){
                    index[j] = -1;
                }
            }
            else if(hands[i].compareTo(hands[index[0]]) == 0){
                index[++split] = i;
            }
        }
    }
    
    /* Main */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        do {      
          
        
        if(test) num_players = 4;
        
        /*
         * Initialize players, hands, community and deck.
         */
        players = new Player[num_players];
        hands = new Hand[num_players];
        community = new Community();
        deck = new Deck();
        
        System.out.printf("--------------------------------------------------------------------------------\n");
        System.out.printf("Texas Hold'em Analysis\n--------------------------------------------------------------------------------\n\n");
        
        /* 
         * Give cards to players and community.
         * For test case, give predefined cards.
         */
        System.out.printf("Cards\n--------------------------------------------------------------------------------\n");
        if(test){
            players[0] = new Player();
            players[0].giveCard(Card.Constant.S7);
            players[0].giveCard(Card.Constant.HA);
            System.out.printf("Player 1:\t%s\n", players[0]);
            players[1] = new Player();
            players[1].giveCard(Card.Constant.C7);
            players[1].giveCard(Card.Constant.DA);
            System.out.printf("Player 2:\t%s\n", players[1]);
            players[2] = new Player();
            players[2].giveCard(Card.Constant.D7);
            players[2].giveCard(Card.Constant.SJ);
            System.out.printf("Player 3:\t%s\n", players[2]);
            players[3] = new Player();
            players[3].giveCard(Card.Constant.D6);
            players[3].giveCard(Card.Constant.CA);
            System.out.printf("Player 4:\t%s\n", players[3]);
            community.giveCard(Card.Constant.S9);
            community.giveCard(Card.Constant.CT);
            community.giveCard(Card.Constant.DJ);
            community.giveCard(Card.Constant.HQ);
            community.giveCard(Card.Constant.CK);
            System.out.printf("Community:\t%s\n", community);
        }
        else {
            for(int i = 0; i < num_players; i++){
                players[i] = new Player();
                players[i].giveCards(deck, 2);
                System.out.printf("Player %d:\t%s\n", i + 1, players[i]);
            }
            community.giveCards(deck, 5);
            System.out.printf("Community:\t%s\n", community);
        }
        
        /* 
         * Create hands to get hand ranks and compare them.
         */
        System.out.printf("\nCombinations\n--------------------------------------------------------------------------------\n");
        for(int i = 0; i < num_players; i++){
            hands[i] = new Hand(community, players[i]);
            System.out.printf("Player %d:\t%s\n", i + 1, hands[i].getHandRank());
        }
        
        /*
         * Get winner index and display the winner plus winning combination.
         * On split pot, display both players.
         */
        System.out.printf("\nWinner\n--------------------------------------------------------------------------------\n");
        getWinner();
        if(split == 0){
            System.out.printf("Player %d wins with '%s'\nCards:\t\t%s\n", index[0] + 1, hands[index[0]].getHandRank(), hands[index[0]].getCombination());
            if(hands[index[0]].getKickers().size() > 0){
                System.out.printf("Kickers:\t%s\n", hands[index[0]].getKickers());
            }
        }
        else {
            System.out.printf("Split Pot!\n");
            for(int i = 0; i < index.length; i++){
                if(index[i] < 0) break;
                System.out.printf("Player %d has '%s'\nCards:\t\t%s\n", index[i] + 1, hands[index[i]].getHandRank(), hands[index[i]].getCombination());
                if(hands[index[i]].getKickers().size() > 0){
                    System.out.printf("Kickers:\t%s\n", hands[index[i]].getKickers());
                }
            }
        }
        
        System.out.printf("\n\nWiederholen? (j/n)\n");
        } while(sc.next().equals("j"));
    } 
}
