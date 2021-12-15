package Evaluator.Entities;

import Board.Deck;
import Board.Hand;

public interface EvaluationSource {
    public Deck deck();

    public void addGoSecondTags(Hand hand);

    public boolean handPlayable(Hand hand);

    public void addTagsToHand(Hand hand);
}
