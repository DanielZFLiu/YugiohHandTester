package Board;

import Cards.Entities.Card;

import java.util.ArrayList;

public class Deck extends CardStack {

    public Deck(){
        name = "Deck";
    }

    public void shuffle(){
        ArrayList<Card> newStack = new ArrayList<>();
        while (this.cardStack.size() != 0){
            int i = (int) (Math.random() * this.cardStack.size());
            Card card = cardStack.get(i);
            cardStack.remove(i);
            newStack.add(card);
        }
        this.cardStack = newStack;
    }

    @Override
    public boolean addCard(Card card){
        cardStack.add(card);
        shuffle();
        return true;
    }

    public Card drawCard() {
        if (cardStack.size() > 0){
            Card card = cardStack.get(0);
            cardStack.remove(0);
            return card;
        }
        return null;
    }

    public void returnCardToTop(Card card){
        cardStack.add(0, card);
    }

    public void returnCardToBottom(Card card){
        cardStack.add(card);
    }

    @Override
    public Deck clone(){
        Deck clone = new Deck();
        clone.cardStack = (ArrayList<Card>) this.cardStack.clone();

        return clone;
    }
}
