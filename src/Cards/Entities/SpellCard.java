package Cards.Entities;

import Cards.Entities.Card;

import java.util.ArrayList;

public class SpellCard extends Card {
    public String type;
    public ArrayList<String> tags;
    public SpellCard(String name, String type, ArrayList<String> tags) {
        super(name);
        this.type = type;
        this.tags = tags;
    }

    public String getType() {
        return type;
    }

    @Override
    public String getGenericType(){
        return "魔法卡";
    }

    public ArrayList<String> getTags(){
        return tags;
    }
}
