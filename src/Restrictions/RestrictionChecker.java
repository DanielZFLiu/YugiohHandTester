package Restrictions;

import java.util.Set;

public class RestrictionChecker {
    public boolean drawnBefore = false;
    public boolean drawCardsAvailable = true;
//    public boolean addCardsAvailable = true;
    public boolean specialSummoned = false;
    public boolean specialSummonAvailable = true;

    public RestrictionChecker(Set<String> usedCards){
        if(usedCards.contains("金满而谦虚之壶")){
            drawCardsAvailable = false;
        }
        else if(usedCards.contains("随风旅鸟与未知之风")){
            drawnBefore = true;
        }
        else if(usedCards.contains("强欲而谦虚之壶")){
            specialSummonAvailable = false;
        }
    }
}
