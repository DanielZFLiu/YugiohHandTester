package Cards.BraveToken;

import Board.BanishedZone;
import Board.Deck;
import Board.Grave;
import Board.Hand;
import Cards.Entities.MonsterCard;

import java.util.ArrayList;
import java.util.Set;

public class WaterEnchantress extends MonsterCard {
    public WaterEnchantress(){
        super("圣殿的水遣", "水","魔法师", "N/A", new ArrayList<String>(){{add("记述 勇者衍生物");}},3,1500,1200);
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
        BanishedZone newBZ = newHand.getBanishedZone();

        newHand.removeCard(this);
        newBZ.addCard(this);
        deck.removeCard("阿拉弥塞亚之仪");
        newHand.addCard(new RiteOfAramesia());

        return new ArrayList<Hand>(){
            {
                add(newHand);
            }
        };
    }
}
