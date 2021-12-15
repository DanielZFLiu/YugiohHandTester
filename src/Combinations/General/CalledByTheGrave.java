package Combinations.General;

import Combinations.Entities.OpeningCombination;
import Board.*;

public class CalledByTheGrave extends OpeningCombination {
    public CalledByTheGrave(){
        super("墓穴的指名者");
    }

    @Override
    public boolean checkHandCombination(Hand hand){
        boolean evaluation = super.checkHandCombination(hand);
        if(evaluation){
            hand.addTag("防灰流丽");
            hand.addTag("防增殖的g");
            hand.addTag("防小丑与锁鸟");
//            hand.addTag("防古遗物-圣枪");
            hand.addTag("防效果遮蒙者");
            hand.addTag("防大宇宙人");
        }

        return evaluation;
    }

}
