package aufgabenzettel4_A9.test;

import cards.*;

public class ResultOfPlayer {
    
    int          playerNo;
    int          position;  // 1=best, 5=worst
    HandRanking  handRank;  
    Card[]       card;
    
    
    public ResultOfPlayer( int pos, HandRanking hrk, Card[] card ){
        this.playerNo = 0;
        this.position = pos;
        this.handRank = hrk;
        this.card     = card.clone();
    }//ResultOfPlayer
    
}//ResultOfPlayer
