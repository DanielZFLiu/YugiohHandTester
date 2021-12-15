package Combinations.Entities;

import Board.Hand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class OpeningCombination {
    public ArrayList<String> cardCombination = new ArrayList<>();
    public boolean keepCombCards = true;

    public OpeningCombination(String ... cards){
        Collections.addAll(cardCombination, cards);
    }

    public OpeningCombination(boolean keepCombCards, String ... cards){
        Collections.addAll(cardCombination, cards);
        this.keepCombCards = keepCombCards;
    }


    public boolean checkHandCombination(Hand hand){
        for(String combCard: cardCombination){
            if(!hand.containsCard(combCard)){
                return false;
            }
        }

        if(!keepCombCards){
            makeCombinationCardsUnavailable(hand);
        }

        return true;
    }

    public boolean checkFieldCombination(Hand hand){
        for(String combCard: cardCombination){
            if(!hand.getField().containsCard(combCard)){
                return false;
            }
        }

        if(!keepCombCards){
            makeCombinationCardsUnavailable(hand);
        }

        return true;
    }

    public boolean checkGraveCombination(Hand hand){
        for(String combCard: cardCombination){
            if(!hand.getGrave().containsCard(combCard)){
                return false;
            }
        }

        if(!keepCombCards){
            makeCombinationCardsUnavailable(hand);
        }

        return true;
    }

    public boolean checkBanishedZoneCombination(Hand hand){
        for(String combCard: cardCombination){
            if(!hand.getBanishedZone().containsCard(combCard)){
                return false;
            }
        }

        if(!keepCombCards){
            makeCombinationCardsUnavailable(hand);
        }

        return true;
    }

    public boolean checkDeckCombination(Hand hand){
        for(String combCard: cardCombination){
            if(!hand.getDeck().containsCard(combCard)){
                return false;
            }
        }

        if(!keepCombCards){
            makeCombinationCardsUnavailable(hand);
        }

        return true;
    }

    public void makeCombinationCardsUnavailable(Hand hand){
        hand.cardsUsed.addAll(cardCombination);
    }
}
