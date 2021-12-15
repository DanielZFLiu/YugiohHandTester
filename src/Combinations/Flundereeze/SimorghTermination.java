package Combinations.Flundereeze;

import Combinations.Entities.OpeningCombination;
import Board.*;

public class SimorghTermination extends OpeningCombination {
    public SimorghTermination(){
        super("绝神鸟 斯摩夫");
    }

    @Override
    public boolean checkHandCombination(Hand hand){
        boolean evaluation = super.checkHandCombination(hand);
        if(evaluation){
            addTag(hand);
        }

        return evaluation;
    }

    public void addTag(Hand hand){
        if(new OpeningCombination("随风旅鸟x知更鸟", "随风旅鸟x帝企").checkHandCombination(hand)){
            hand.addTag("防灰流丽");
            hand.addTag("防无限泡影");
            hand.addTag("防效果遮蒙者");
        }
        else if(new OpeningCombination("随风旅鸟x知更鸟", "霞之谷的巨神鸟").checkHandCombination(hand)){
            hand.addTag("防灰流丽");
            hand.addTag("防无限泡影");
            hand.addTag("防效果遮蒙者");
        }
        else if(new OpeningCombination("随风旅鸟x白头鹰", "随风旅鸟x帝企").checkHandCombination(hand)){
            hand.addTag("防灰流丽");
            hand.addTag("防无限泡影");
            hand.addTag("防效果遮蒙者");
        }
        else if(new OpeningCombination("随风旅鸟x白头鹰", "霞之谷的巨神鸟").checkHandCombination(hand)){
            hand.addTag("防灰流丽");
            hand.addTag("防无限泡影");
            hand.addTag("防效果遮蒙者");
        }
    }
}
