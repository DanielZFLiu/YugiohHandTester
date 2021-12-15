package Board;

import Cards.Entities.Card;

import java.util.ArrayList;

public class Grave extends CardStack{
    public Grave(){
        name = "Grave";
    }

    @Override
    public Grave clone(){
        Grave clone = new Grave();
        clone.cardStack = (ArrayList<Card>) this.cardStack.clone();

        return clone;
    }
}
