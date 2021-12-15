package Combinations.Drytron;

import Board.Hand;
import Cards.Entities.Card;
import Cards.Entities.MonsterCard;
import Combinations.Entities.OpeningCombination;

import java.util.Objects;

public class HeraldOrangeLight extends OpeningCombination {
    public HeraldOrangeLight(){
        super("朱光之宣告者");
    }

    @Override
    public boolean checkHandCombination(Hand hand){
        boolean evaluation = super.checkHandCombination(hand);
        if(evaluation){
            return addTags(hand);
        }

        return false;
    }

    private boolean addTags(Hand hand){
        hand.removeCard("朱光之宣告者");
        for(Card card: hand.returnStack()){
            if(Objects.equals(card.getGenericType(), "怪兽卡")){
                if(Objects.equals(((MonsterCard) card).type, "天使") && !hand.cardsUsed.contains(card.getName())){
                    hand.addTag("防小丑与锁鸟");
                    hand.addTag("防效果遮蒙者");
                    hand.addTag("防增殖的g");
                    hand.addTag("防灰流丽");
                    hand.addTag("防大宇宙人");
                    hand.removeCard(card.getName());
//                    hand.cardsUsed.add(card.getName());
                    return true;
                }
            }
        }
        return false;
    }
}
