package Cards.General;

import Cards.Entities.MonsterCard;
import Board.*;

import java.util.ArrayList;
import java.util.Set;

public class MaxxC extends MonsterCard {
    public MaxxC() {
        super("增殖的g", "地","昆虫", "N/A", new ArrayList<String>(){{add("g");}},2,500,200);
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
        Grave newGrave = newHand.getGrave();

        newHand.removeCard(this);
        newGrave.addCard(this);

        return new ArrayList<Hand>(){
            {
                add(newHand);
            }
        };
    }

}
