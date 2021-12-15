package Evaluator.Entities;

import Cards.Entities.Card;
import Board.Hand;

import java.util.ArrayList;

public class PossibilityTree {

    public Hand value;
    public ArrayList<PossibilityTree> possibilities = new ArrayList<>();

    public PossibilityTree(Hand value){
        this.value = value;
    }

    public ArrayList<Hand> deducePossibleHands(){
        ArrayList<Card> hand = value.returnStack();
        ArrayList<Card> variableCards = new ArrayList<>();

        for(Card handCard: hand){
            if(handCard.usableEffect(value.cardsUsed)){
                variableCards.add(handCard);
            }
        }

        if(variableCards.size() == 0){
            return new ArrayList<Hand>(){
                {
                    add(value);
                }
            };
        }

        for(Card variable: variableCards){
            ArrayList<Hand> newHands = variable.effect(value);

            for(Hand newHand: newHands){
                PossibilityTree newTree = new PossibilityTree(newHand);
                newTree.value.addToCardsUsed(this.value.cardsUsed);
                newTree.value.addToCardsUsed(variable.getName());
                possibilities.add(newTree);
            }
        }

        PossibilityTree currentTreeClone = new PossibilityTree(value.clone());
        currentTreeClone.value.addToCardsUsed(value.cardsUsed);
        for(Card card: hand){
            currentTreeClone.value.addToCardsUsed(card.getName());
        }
        possibilities.add(currentTreeClone);

        ArrayList<Hand> possibleHands = new ArrayList<>();
        for(PossibilityTree handPossibility: possibilities){
            possibleHands.addAll(handPossibility.deducePossibleHands());
        }
        return possibleHands;
    }

    public void presentHands(ArrayList<Hand> hands){
        for(Hand hand: hands){
            hand.displayStack();
        }
    }
}
