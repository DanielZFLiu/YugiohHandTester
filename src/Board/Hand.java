package Board;

import Cards.Entities.Card;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Hand extends CardStack{
    public HashSet<String> tags = new HashSet<>();
    public Deck deck;
    public Grave grave;
    public BanishedZone banishedZone;
    public Field field;
    public Set<String> cardsUsed = new HashSet<>();

    public Hand(Deck deck, Grave grave, BanishedZone banishedZone, Field field){
        this.deck = deck;
        this.grave = grave;
        this.banishedZone = banishedZone;
        this.field = field;
        name = "Hand";
    }

    public void drawCard(){
        cardStack.add(deck.drawCard());
    }

    public void drawCards(int i){
        for(int e = 0; e < i; e++){
            drawCard();
        }
    }

    public Deck getDeck(){
        return this.deck;
    }

    public Grave getGrave(){
        return this.grave;
    }

    public BanishedZone getBanishedZone(){
        return this.banishedZone;
    }

    public Field getField(){return this.field;}

    public void addTag(String tag){
        tags.add(tag);
    }

    public ArrayList<String> getTags(){
        ArrayList<String> returnedValue = new ArrayList<>();
        returnedValue.addAll(tags);
        return returnedValue;
    }

    public void resetHand(){
        for(Card card: cardStack){
            deck.addCard(card);
        }
        cardStack.clear();
        grave.cardStack.clear();
        banishedZone.cardStack.clear();
        field.cardStack.clear();
        cardsUsed.clear();
        tags.clear();
    }

    @Override
    public Hand clone(){
        Hand handClone = new Hand(deck.clone(), grave.clone(), banishedZone.clone(), field.clone());
        handClone.cardStack = (ArrayList<Card>) this.cardStack.clone();
        handClone.tags = new HashSet<>();
        return handClone;
    }

    public void addToCardsUsed(String card){
        cardsUsed.add(card);
    }

    public void addToCardsUsed(Set<String> cards){
        cardsUsed.addAll(cards);
    }
}
