package Cards.Cyber;

import Board.Deck;
import Board.Field;
import Board.Grave;
import Board.Hand;
import Cards.Entities.Card;
import Cards.Entities.MonsterCard;
import Cards.Entities.SpellCard;
import Cards.Entities.TrapCard;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

public class CyberEmergency extends SpellCard {
    public CyberEmergency() {
        super("电子紧急呼救", "通常", new ArrayList<String>(){{add("电子");}});
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
                if(((MonsterCard) card).getTags().contains("电子") &&
                        !targetCardsNames.contains(card.getName())){
                    targetCards.add(card);
                    targetCardsNames.add(card.getName());
                }
                else if(((MonsterCard) card).getTags().contains("不能通常召唤") &&
                        Objects.equals(((MonsterCard) card).attribute, "光") &&
                        Objects.equals(((MonsterCard) card).type, "机械") &&
                        !targetCardsNames.contains(card.getName())){
                    targetCards.add(card);
                    targetCardsNames.add(card.getName());
                }
            }
        }

//        for(String card: targetCardsNames){
//            System.out.println(card);
//        }


        ArrayList<Hand> newHands = new ArrayList<>();
        for(Card targetCard: targetCards){
            Hand newHand = hand.clone();
            Deck newHandDeck = newHand.getDeck();
            Grave newHandGrave = newHand.getGrave();

            newHand.removeCard(this);
            newHandGrave.addCard(this);

            newHand.addCard(targetCard);
            newHandDeck.removeCard(targetCard);

            newHands.add(newHand);
        }

        return newHands;
    }
}
