package Cards.BraveToken;

import Board.*;
import Cards.Entities.SpellCard;

import java.util.ArrayList;
import java.util.Set;

public class RiteOfAramesia extends SpellCard {
    public RiteOfAramesia() {
        super("阿拉弥塞亚之仪", "通常", new ArrayList<String>(){{add("记述 勇者衍生物");}});
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
        Grave newGrave = newHand.getGrave();

        newHand.removeCard(this);
        newGrave.addCard(this);
        deck.removeCard("命运之旅路");
        newHand.addCard(new JourneyOfDestiny());

        return new ArrayList<Hand>(){
            {
                add(newHand);
            }
        };
    }
}
