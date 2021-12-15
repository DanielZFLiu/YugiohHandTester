package Cards.General;

import Cards.Entities.MonsterCard;
import Board.*;

import java.util.ArrayList;
import java.util.Set;

public class DimensionShifter extends MonsterCard {
    public DimensionShifter() {
        super("次元吸引者", "暗","魔法师", "N/A",new ArrayList<String>(){{add("次元");}},6,1200,2200);
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
