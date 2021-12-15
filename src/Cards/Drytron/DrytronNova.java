package Cards.Drytron;

import Board.Deck;
import Board.Field;
import Board.Grave;
import Board.Hand;
import Cards.Entities.Card;
import Cards.Entities.MonsterCard;
import Cards.Entities.SpellCard;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

public class DrytronNova extends SpellCard {
    public DrytronNova(){
        super("极超之龙辉巧","通常",new ArrayList<String>(){{add("龙辉巧");}});
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
            if(Objects.equals(card.getGenericType(), "怪兽卡")){
                if(((MonsterCard) card).getTags().contains("龙辉巧") &&
                        !targetCardsNames.contains(card.getName())){
                    targetCards.add(card);
                    targetCardsNames.add(card.getName());
                }
            }
        }

        ArrayList<Hand> newHands = new ArrayList<>();
        for(Card targetCard: targetCards){
            Hand newHand = hand.clone();
            Deck newHandDeck = newHand.getDeck();
            Grave newHandGrave = newHand.getGrave();
            Field newHandField = newHand.getField();

            newHand.removeCard(this);
            newHandGrave.addCard(this);

            newHand.addCard(targetCard);
            newHandDeck.removeCard(targetCard);
            newHandField.addCard(targetCard);

            newHands.add(newHand);
        }

        return newHands;
    }
}
