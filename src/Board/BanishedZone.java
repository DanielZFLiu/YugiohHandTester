package Board;

import Cards.Entities.Card;

import java.util.ArrayList;

public class BanishedZone extends CardStack{
    public BanishedZone(){
        name = "Banished Zone";
    }

    @Override
    public BanishedZone clone(){
        BanishedZone clone = new BanishedZone();
        clone.cardStack = (ArrayList<Card>) this.cardStack.clone();

        return clone;
    }
}
