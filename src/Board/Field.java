package Board;

import Cards.Entities.Card;

import java.util.ArrayList;

public class Field extends CardStack{

    public class STZone extends CardStack{
        public STZone(){
            name = "Spell Trap Zone";
        }

        @Override
        public STZone clone(){
            STZone clone = new STZone();
            clone.cardStack = (ArrayList<Card>) this.cardStack.clone();

            return clone;
        }
    }

    public class MonsterZone extends CardStack{
        public MonsterZone(){
            name = "Spell Trap Zone";
        }

        @Override
        public MonsterZone clone(){
            MonsterZone clone = new MonsterZone();
            clone.cardStack = (ArrayList<Card>) this.cardStack.clone();

            return clone;
        }
    }

    public STZone stZone = new STZone();
    public MonsterZone monsterZone = new MonsterZone();

    public Field(){
        name = "Field";
    }

    @Override
    public Field clone(){
        Field clone = new Field();
        clone.cardStack = (ArrayList<Card>) this.cardStack.clone();
        clone.stZone = this.stZone.clone();
        clone.monsterZone = this.monsterZone.clone();

        return clone;
    }
}
