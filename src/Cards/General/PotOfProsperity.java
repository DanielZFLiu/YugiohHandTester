package Cards.General;
import Cards.Entities.Card;
import Cards.Entities.SpellCard;
import Board.*;
import Restrictions.RestrictionChecker;

import java.util.ArrayList;
import java.util.Set;

public class PotOfProsperity extends SpellCard {

    public PotOfProsperity() {
        super("金满而谦虚之壶", "通常", new ArrayList<>());
    }

    @Override
    public boolean usableEffect(Set<String> cardsUsed){
        RestrictionChecker restriction = new RestrictionChecker(cardsUsed);
        if(cardsUsed.contains(name) || restriction.drawnBefore){
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<Hand> effect(Hand hand) {
        Deck deck = hand.getDeck();

        if (deck.size() < 6) {
            return new ArrayList<>();
        }

        ArrayList<Card> revealedCards = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Card card = deck.drawCard();
            revealedCards.add(card);
        }


        ArrayList<Card> filteredRevealedCards = new ArrayList<>();
        ArrayList<String> filteredCardsNames = new ArrayList<>();
        for (Card card : revealedCards) {
            if(!filteredCardsNames.contains(card.getName())){
                filteredCardsNames.add(card.getName());
                filteredRevealedCards.add(card);
            }
        }

        ArrayList<Hand> possibleHands = new ArrayList<>();
        for (Card card : filteredRevealedCards) {
            Hand newHand = hand.clone();
            Deck newHandDeck = newHand.getDeck();
            Grave newHandGrave = newHand.getGrave();
            int i = newHand.isCardThere(this);

            newHand.removeCard(this);
            newHand.addCard(i, card);

            newHandGrave.addCard(this);

            for (Card revealedCard: revealedCards) {
                if (revealedCard != card) {
                    newHandDeck.returnCardToBottom(revealedCard);
                }
            }

            possibleHands.add(newHand);
        }

        for (int i = 5; i >= 0; i--) {
            deck.returnCardToTop(revealedCards.get(i));
        }

        return possibleHands;
    }
}
