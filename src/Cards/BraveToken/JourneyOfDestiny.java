package Cards.BraveToken;

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

public class JourneyOfDestiny extends SpellCard {
    public JourneyOfDestiny() {
        super("命运之旅路", "永续", new ArrayList<String>(){{add("记述 勇者衍生物");}});
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
        Hand newHand = hand.clone();
        Deck deck = newHand.getDeck();
        Field field = newHand.getField();

        newHand.removeCard(this);
        field.addCard(this);

        ArrayList<Card> searchedCards = new ArrayList<>();
        for(Card card: deck.returnStack()){
            if(Objects.equals(card.getGenericType(), "怪兽卡")){
                if(((MonsterCard)card).getTags().contains("记述 勇者衍生物")){
                    searchedCards.add(card);
                }
            }
        }

        if(searchedCards.size() == 0){
            return new ArrayList<Hand>(){
                {
                    add(newHand);
                }
            };
        }

        ArrayList<Hand> possibleHands = new ArrayList<>();
        for(Card card: searchedCards){
            Hand potentialHand = newHand.clone();
            Deck potentialDeck = potentialHand.getDeck();

            potentialHand.addCard(card);
            potentialDeck.removeCard(card);

            possibleHands.add(potentialHand);
        }

        return possibleHands;

    }
}
