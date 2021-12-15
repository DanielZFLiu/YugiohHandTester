package Board;

import Cards.Entities.Card;

import java.util.ArrayList;

public class CardStack {
    public ArrayList<Card> cardStack = new ArrayList<>();
    public String name = "CardStack";

    public void displayStack() {
        System.out.println(name + ": " + "_____________________________________________");
        for (Card card : cardStack) {
            System.out.println(card.getName());
        }
        System.out.println("___________________________________________________");
    }

    public boolean addCard(Card card){
        return cardStack.add(card);
    }

    public void addCard(int i, Card card){
        cardStack.add(i, card);
    }

    public boolean removeCard(Card card){
        return cardStack.remove(card);
    }

    public int isCardThere(Card card){
        return cardStack.indexOf(card);
    }

    public boolean containsCard(String name){
        for(Card card: cardStack){
            if(name.equals(card.getName())){
                return true;
            }
        }
        return false;
    }

    public boolean removeCard(String name){
        for(Card card: cardStack){
            if(name.equals(card.getName())){
                cardStack.remove(card);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Card> returnStack() {
        return cardStack;
    }

    public int size(){
        return cardStack.size();
    }
}
