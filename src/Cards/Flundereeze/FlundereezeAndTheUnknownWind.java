package Cards.Flundereeze;

import Cards.Entities.Card;
import Cards.Entities.MonsterCard;
import Cards.Entities.SpellCard;
import Board.*;
import Restrictions.RestrictionChecker;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

public class FlundereezeAndTheUnknownWind extends SpellCard {
    public FlundereezeAndTheUnknownWind() {
        super("随风旅鸟与未知之风", "永续", new ArrayList<String>(){{add("随风旅鸟");}});
    }

    @Override
    public boolean usableEffect(Set<String> cardsUsed){
        RestrictionChecker restriction = new RestrictionChecker(cardsUsed);
        if(cardsUsed.contains(name) || !restriction.drawCardsAvailable){
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<Hand> effect(Hand hand) {
        ArrayList<Card> cards = hand.returnStack();


        ArrayList<Card> wingedBeasts = new ArrayList<>();
        for(Card card: cards){
            if(Objects.equals(card.getGenericType(), "怪兽卡")){
                if(((MonsterCard) card).type.equals("鸟兽")){
                    wingedBeasts.add(card);
                }
            }
        }

        ArrayList<Hand> newHands = new ArrayList<>();

        for(int i = 0; i<wingedBeasts.size(); i++){
            for(int e=i+1; e<wingedBeasts.size(); e++){
                Hand newHand = hand.clone();
                Deck newHandDeck = newHand.getDeck();
                newHandDeck.addCard(wingedBeasts.get(i));
                newHandDeck.addCard(wingedBeasts.get(e));

                newHand.removeCard(this);
                newHand.removeCard(wingedBeasts.get(i));
                newHand.removeCard(wingedBeasts.get(e));
                newHand.drawCards(2);
                newHands.add(newHand);
            }
        }

        for (Card wingedBeast : wingedBeasts) {
            Hand newHand = hand.clone();
            Deck newHandDeck = newHand.getDeck();

            newHandDeck.addCard(wingedBeast);

            newHand.removeCard(this);
            newHand.removeCard(wingedBeast);
            newHand.drawCard();
            newHands.add(newHand);
        }

        return newHands;
    }
}
