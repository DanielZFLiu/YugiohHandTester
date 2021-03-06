package Evaluator.Entities;

import Board.*;
import Cards.Entities.Card;

import java.util.ArrayList;
import java.util.HashMap;

public class HandEvaluator {

    public HashMap<String, Integer> tagCount = new HashMap<>();
    public EvaluationSource source;
    public int testHandNum;
    public boolean goSecond = false;

    public HandEvaluator(EvaluationSource source, int testHandNum){
        this.source = source;
        this.testHandNum = testHandNum;
    }

    public void showEvaluation(){
        float probability = this.calculatePlayability(source.deck());

        if(testHandNum != 1){
            System.out.println("δΈε‘ζη: " + probability);

            for(String tag: this.tagCount.keySet()){
                System.out.println(tag + ": " + (float)this.tagCount.get(tag)/(float)testHandNum);
            }
        }
    }

    public void showEvaluation(boolean goSecond){
        this.goSecond = goSecond;
        showEvaluation();
    }

    public float calculatePlayability(Deck deck){
        Hand hand = new Hand(deck, new Grave(), new BanishedZone(), new Field());

        int playableCounter = 0;
        for(int i = 0; i < testHandNum; i++){
            hand.drawCards(5);

            PossibilityTree possibilityTree = new PossibilityTree(hand.clone());
            ArrayList<Hand> possibleHands = possibilityTree.deducePossibleHands();

            ArrayList<Hand> playableHands = new ArrayList<>();
            for(Hand possibleHand: possibleHands){
                if(goSecond){
                    source.addGoSecondTags(possibleHand);
                    possibleHand.drawCard();
                }

                source.addTagsToHand(possibleHand);

                if(source.handPlayable(possibleHand)){
                    playableHands.add(possibleHand);
                }
            }

            if(playableHands.size() > 0) {
                playableCounter++;

                Hand bestHand = playableHands.get(0);
                for (int e = 1; e < playableHands.size(); e++) {
                    Hand testHand = playableHands.get(e);
                    if (testHand.getTags().size() > bestHand.getTags().size()) {
                        bestHand = testHand;
                    }
                }


                ArrayList<String> tags = bestHand.getTags();
                for (String tag : tags) {
                    if (tagCount.containsKey(tag)) {
                        tagCount.put(tag, tagCount.get(tag) + 1);
                    } else {
                        tagCount.put(tag, 1);
                    }
                }
            }

            else{
                Hand bestHand = possibleHands.get(0);
                for(int e = 1; e < possibleHands.size(); e++){
                    Hand testHand = possibleHands.get(e);
                    if (testHand.getTags().size() > bestHand.getTags().size()) {
                        bestHand = testHand;
                    }
                }

                ArrayList<String> tags = bestHand.getTags();
                for (String tag : tags) {
                    if (tagCount.containsKey(tag)) {
                        tagCount.put(tag, tagCount.get(tag) + 1);
                    } else {
                        tagCount.put(tag, 1);
                    }
                }
            }

            if(testHandNum == 1){
                for(Card card: hand.returnStack()){
                    System.out.println(card.getName());
                }
                System.out.println("");
                System.out.println("ε―η©: " + source.handPlayable(possibleHands.get(0)));
                System.out.println("");
                for(String tag: possibleHands.get(0).getTags()){
                    System.out.println(tag);
                }
            }

            hand.resetHand();
        }

        return (float)playableCounter/(float)testHandNum;
    }
}
