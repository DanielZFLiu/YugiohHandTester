package Cards.Entities;

import Cards.Entities.Card;

import java.nio.charset.Charset;
import java.util.ArrayList;

public class MonsterCard extends Card {
    public String attribute;
    public String type;
    public String extraDeckType;
    public ArrayList<String> tags;
    public int level;
    public int attack;
    public int defense;
    public MonsterCard(String name, String attribute, String type, String extraDeckType, ArrayList<String> tags,
                       int level, int attack, int defense) {
        super(name);
        this.attribute = attribute;
        this.type = type;
        this.extraDeckType = extraDeckType;
        this.tags = tags;
        this.level = level;
        this.attack = attack;
        this.defense = defense;
    }

    @Override
    public String getGenericType(){
        return "怪兽卡";
    }

    public ArrayList<String> getTags() {
        return tags;
    }
}
