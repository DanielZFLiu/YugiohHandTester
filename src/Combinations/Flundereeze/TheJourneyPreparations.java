package Combinations.Flundereeze;

import Board.Hand;
import Combinations.Entities.OpeningCombination;

public class TheJourneyPreparations extends OpeningCombination {
    public TheJourneyPreparations(){
        super("随风旅鸟与旅行准备");
    }

    @Override
    public boolean checkHandCombination(Hand hand){
        boolean evaluation = super.checkHandCombination(hand);
        if(evaluation){
            addTags(hand);
        }

        return evaluation;
    }

    private void addTags(Hand hand){
        if(!hand.cardsUsed.contains("随风旅鸟与旅行准备")){
            hand.addTag("防无限泡影");
            hand.addTag("防效果遮蒙者");
        }
    }
}
