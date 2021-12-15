package Combinations.General;

import Combinations.Entities.OpeningCombination;
import Board.*;

public class CrossoutDesignator extends OpeningCombination {
    public CrossoutDesignator(){
        super("抹杀之指名者");
    }

    @Override
    public boolean checkHandCombination(Hand hand){
        boolean evaluation = super.checkHandCombination(hand);
        if(evaluation){
            addTags(hand, hand.getDeck());
        }

        return evaluation;
    }

    private void addTags(Hand hand, Deck deck){
        if(deck.containsCard("灰流丽")){
            hand.addTag("防灰流丽");
        }
        if(deck.containsCard("无限泡影")){
            hand.addTag("防无限泡影");
        }
        if(deck.containsCard("增殖的g")){
            hand.addTag("防增殖的g");
        }
//        if(deck.containsCard("古遗物-圣枪")){
//            hand.addTag("古遗物-圣枪");
//        }
        if(deck.containsCard("小丑与锁鸟")){
            hand.addTag("防小丑与锁鸟");
        }
    }
}
