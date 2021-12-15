package Cards.General;

import Cards.Entities.Card;
import Cards.Entities.SpellCard;
import Board.*;

import java.util.ArrayList;
import java.util.Set;

public class Terraforming extends SpellCard {
    public Terraforming() {
        super("星球改造", "通常", new ArrayList<>());
    }

    @Override
    public boolean usableEffect(Set<String> cardsUsed){
        if(cardsUsed.contains(name)){
            return false;
        }
        return true;
    }


    @Override
    public ArrayList<Hand> effect(Hand hand) {
        Deck deck = hand.getDeck();

        ArrayList<Card> DeckList = deck.returnStack();
        ArrayList<Card> targetCards = new ArrayList<>();
        for(Card card: DeckList){
            if(card.getGenericType().equals("魔法卡")){
                if(((SpellCard)card).getType().equals("场地")){
                    boolean evaluation = true;
                    for(Card targetCard: targetCards){
                        if(targetCard.getName().equals(card.getName())){
                            evaluation = false;
                            break;
                        }
                    }
                    if(evaluation){
                        targetCards.add(card);
                    }
                }
            }
        }

        ArrayList<Hand> newHands = new ArrayList<>();
        for(Card targetCard: targetCards){
            Hand newHand = hand.clone();
            Deck newHandDeck = newHand.getDeck();
            Grave newHandGrave = newHand.getGrave();

            newHand.removeCard(this);
            newHand.addCard(targetCard);
            newHandGrave.addCard(this);
            newHandDeck.removeCard(targetCard);
            newHandDeck.shuffle();

            newHands.add(newHand);
        }

        return newHands;
    }
}
