package Combinations.Flundereeze;

import Combinations.Entities.OpeningCombination;
import Board.*;

public class Strich extends OpeningCombination {
    public Strich(){
        super("随风旅鸟x鸵鸟");
    }

    @Override
    public boolean checkHandCombination(Hand hand){
        boolean evaluation = super.checkHandCombination(hand);
        boolean evaluation2 = requirement1(hand.getGrave());

        return evaluation && evaluation2;
    }

    private boolean requirement1(Grave grave){
        return grave.size() > 0;
    }
}
