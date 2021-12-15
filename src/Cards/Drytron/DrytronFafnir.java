package Cards.Drytron;

import Board.Deck;
import Board.Field;
import Board.Hand;
import Cards.Entities.Card;
import Cards.Entities.SpellCard;
import Cards.Entities.TrapCard;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

public class DrytronFafnir extends SpellCard {
    public DrytronFafnir() {
        super("龙辉巧-扶筐增二", "场地", new ArrayList<String>(){{add("龙辉巧");}});
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
        ArrayList<Card> deckList = deck.returnStack();

        ArrayList<Card> targetCards = new ArrayList<>();
        ArrayList<String> targetCardsNames = new ArrayList<>();
        for(Card card: deckList){
            if(!Objects.equals(card.getName(), "龙辉巧-扶筐增二")){
                if(Objects.equals(card.getGenericType(), "陷阱卡")){
                    if(((TrapCard) card).getTags().contains("龙辉巧") &&
                            !targetCardsNames.contains(card.getName())){
                        targetCards.add(card);
                        targetCardsNames.add(card.getName());
                    }
                }
                else if(Objects.equals(card.getGenericType(), "魔法卡")){
                    if(((SpellCard) card).getTags().contains("龙辉巧")&&
                            !targetCardsNames.contains(card.getName())){
                        targetCards.add(card);
                        targetCardsNames.add(card.getName());
                    }
                }
            }
        }

        ArrayList<Hand> newHands = new ArrayList<>();
        for(Card targetCard: targetCards){
            Hand newHand = hand.clone();
            Deck newHandDeck = newHand.getDeck();
            Field newHandField = newHand.getField();

            newHand.removeCard(this);
            newHandField.addCard(this);

            newHand.addCard(targetCard);
            newHandDeck.removeCard(targetCard);

            newHands.add(newHand);
        }

        return newHands;
    }
}
