package Evaluator.Entities;

import Cards.Entities.Card;
import Cards.Entities.MonsterCard;
import Cards.Entities.SpellCard;
import Cards.Entities.TrapCard;

import java.util.ArrayList;
import java.util.HashMap;

public class CardPool {
    public HashMap<String, Card> cardPool;

    public void cardPoolInitialization(){

    }

    public void addMonsterToCardPool(String name, String attribute, String type, String extraDeckType,
                                     ArrayList<String> tags, int level, int attack, int defense){
        cardPool.put(name, new MonsterCard(name, attribute, type, extraDeckType, tags, level, attack, defense));
    }

    public void addSpellToCardPool(String name, String type, ArrayList<String> tags){
        cardPool.put(name, new SpellCard(name, type, tags));
    }

    public void addTrapToCardPool(String name, String type, ArrayList<String> tags){
        cardPool.put(name, new TrapCard(name, type, tags));
    }
}
