package Cards.Flundereeze;

import Cards.Entities.Card;
import Cards.Entities.MonsterCard;
import Cards.Entities.SpellCard;
import Board.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

public class FlundereezeAndTheJourneyPreparations extends SpellCard {
    public FlundereezeAndTheJourneyPreparations() {
        super("随风旅鸟与旅行准备", "速攻", new ArrayList<String>(){{add("随风旅鸟");}});
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

        ArrayList<Card> handCards = hand.returnStack();
        ArrayList<Card> HandWingedBeasts = new ArrayList<>();
        for(Card card: handCards){
            if(Objects.equals(card.getGenericType(), "怪兽卡")){
                if(((MonsterCard) card).type.equals("鸟兽")){
                    HandWingedBeasts.add(card);
                }
            }
        }

        if(HandWingedBeasts.size() == 0){
            return new ArrayList<>();
        }

        ArrayList<Card> deckCards = deck.returnStack();
        ArrayList<Card> SearchTargets = new ArrayList<>();
        ArrayList<String> SearchTargetsNames = new ArrayList<>();
        for(Card card: deckCards){
            if(Objects.equals(card.getGenericType(), "怪兽卡")){
                if(((MonsterCard) card).tags.contains("随风旅鸟") && !SearchTargetsNames.contains(card.getName())){
                    SearchTargets.add(card);
                    SearchTargetsNames.add(card.getName());
                }
            }
            else if(card.getName().equals("随风旅鸟与迷之地图") && !SearchTargetsNames.contains(card.getName())){
                SearchTargets.add(card);
                SearchTargetsNames.add(card.getName());
            }
        }

        ArrayList<Hand> newHands = new ArrayList<>();

        for(Card wingedBeast: HandWingedBeasts){
            for(Card card: SearchTargets){
                Hand newHand = hand.clone();
                Deck newHandDeck = newHand.getDeck();
                Grave newHandGrave = newHand.getGrave();
                BanishedZone newHandBanishedZone = newHand.getBanishedZone();

                newHand.removeCard(this);
                newHand.removeCard(wingedBeast);
                newHand.addCard(card);

                newHandGrave.addCard(this);

                newHandBanishedZone.addCard(wingedBeast);

                newHandDeck.removeCard(card);
                newHandDeck.shuffle();

                newHands.add(newHand);
            }
        }

        return newHands;
    }
}
