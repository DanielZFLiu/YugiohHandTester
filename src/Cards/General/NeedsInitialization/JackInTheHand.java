package Cards.General.NeedsInitialization;

import Cards.Entities.Card;
import Cards.Entities.MonsterCard;
import Cards.Entities.SpellCard;
import Board.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

public class JackInTheHand extends SpellCard {
    public JackInTheHand() {
        super("吓人手中盒", "通常", new ArrayList<>());
    }
    public ArrayList<String> priorityList;

    public void initialize(){
        priorityList = new ArrayList<String>(){
            {
                add("随风旅鸟x知更鸟");
                add("随风旅鸟x白头鹰");
                add("随风旅鸟x鸵鸟");
                add("随风旅鸟x巨嘴鸟");
            }
        };
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
        initialize();

        ArrayList<Card> deckList = deck.returnStack();
        ArrayList<Card> levelOneMonsters = new ArrayList<>();
        ArrayList<String> levelOneMonstersNames = new ArrayList<>();

        for(Card card: deckList){
            if(Objects.equals(card.getGenericType(), "怪兽卡")){
                if(((MonsterCard) card).level == 1 && !levelOneMonstersNames.contains(card.getName())){
                    levelOneMonstersNames.add(card.getName());
                    levelOneMonsters.add(card);
                }
            }
        }

        if (levelOneMonsters.size() < 3){
            return new ArrayList<>();
        }

        ArrayList<Hand> newHands = new ArrayList<>();
        for(int i = 0; i < priorityList.size(); i++){
            if(levelOneMonstersNames.contains(priorityList.get(i))) {
                int indexOpponentMonster = levelOneMonstersNames.indexOf(priorityList.get(i));
                Card opponentMonster = levelOneMonsters.get(indexOpponentMonster);
                for (int e = i + 1; e < priorityList.size(); e++) {
                    if(levelOneMonstersNames.contains(priorityList.get(e))){
                        Hand newHand = hand.clone();
                        Deck newHandDeck = newHand.getDeck();
                        Grave newHandGrave = newHand.getGrave();

                        int indexPlayerMonster = levelOneMonstersNames.indexOf(priorityList.get(e));
                        Card playerMonster = levelOneMonsters.get(indexPlayerMonster);

                        newHand.removeCard(this);
                        newHandGrave.addCard(this);

                        newHandDeck.removeCard(playerMonster);
                        newHand.addCard(playerMonster);

                        newHandDeck.removeCard(opponentMonster);
                        newHandDeck.shuffle();

                        newHands.add(newHand);
                    }
                }
                break;
            }
        }

        return newHands;
    }
}
