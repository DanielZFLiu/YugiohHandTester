package Cards.Entities;

import Cards.Entities.Card;

import java.util.ArrayList;

public class TrapCard extends Card {
    public String type;
    public ArrayList<String> tags;

    public TrapCard(String name, String type, ArrayList<String> tags) {
        super(name);
        this.type = type;
        this.tags = tags;
    }

    public String getType() {
        return type;
    }

    @Override
    public String getGenericType(){
        return "陷阱卡";
    }

    public ArrayList<String> getTags(){
        return tags;
    }
}
