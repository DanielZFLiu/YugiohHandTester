package Combinations.Entities;

import Board.Hand;
import Cards.Entities.Card;

import java.util.*;

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

    // when multiple tags are entered, 1 card with more than 1 of the tags does not satisfy the check
    // when one tag is entered, returns the number of cards with that tag
    public int checkTagsCombination(Hand hand){
        if(cardCombination.size()==1){
            int tagCount = 0;
            ArrayList<Card> cards = hand.returnStack();
            for(Card card: cards){
                if(card.getTags().contains(cardCombination.get(0))){
                    tagCount++;
                }
            }
            return tagCount;
        }

        Set<Card> repetitiveCards = new HashSet<>();

        for(String tag: cardCombination){
            int tagYes = 0;
            ArrayList<Card> cards = hand.returnStack();
            for(Card card: cards){
                if(card.getTags().contains(tag)){
                    tagYes=1;
                    repetitiveCards.add(card);
                }
            }
            if(tagYes == 0){
                return 0;
            }
        }

        if(repetitiveCards.size() < cardCombination.size()){
            return 0;
        }

        if(!keepCombCards){
            makeCombinationCardsUnavailable(hand);
        }

        return 1;
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
