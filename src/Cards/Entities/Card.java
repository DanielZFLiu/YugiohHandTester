package Cards.Entities;

import Board.Hand;

import java.util.ArrayList;
import java.util.Set;

public class Card {
    public String name;

    public Card(String name){
        this.name = name;
    }

    public ArrayList<Hand> effect(Hand hand) {
        return new ArrayList<>();
    }
    public String getName(){
        return name;
    }
    public boolean usableEffect(Set<String> cardsUsed){
        return false;
    }
    public String getGenericType(){
        return "游戏王卡牌";
    }
    public ArrayList<String> getTags(){
        return new ArrayList<>();
    }
}
