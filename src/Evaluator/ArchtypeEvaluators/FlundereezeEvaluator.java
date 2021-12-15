package Evaluator.ArchtypeEvaluators;

import Cards.Flundereeze.FlundereezeAndTheJourneyPreparations;
import Cards.Flundereeze.FlundereezeAndTheUnknownWind;
import Cards.General.*;
import Cards.General.NeedsInitialization.JackInTheHand;
import Combinations.General.CalledByTheGrave;
import Combinations.General.CrossoutDesignator;
import Combinations.Entities.OpeningCombination;
import Combinations.Flundereeze.Strich;
import Combinations.Flundereeze.TheJourneyPreparations;
import Board.*;
import Evaluator.Entities.CardPool;
import Evaluator.Entities.EvaluationSource;
import Evaluator.Entities.HandEvaluator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class FlundereezeEvaluator extends CardPool implements EvaluationSource {
    public static void main(String[] args) {
        HandEvaluator flundereezeEvaluator = new HandEvaluator(new FlundereezeEvaluator(), 100000);
        flundereezeEvaluator.showEvaluation();
    }

    public ArrayList<String> deckList = new ArrayList<>();

    public FlundereezeEvaluator(){
        cardPool = new HashMap<>();
        cardPoolInitialization();
        LLsFlundereezeList();
    }

    public void LLsFlundereezeList(){

        String[] deckList = new String[]{
                "随风旅鸟x帝企", "霞之谷的巨神鸟", "烈风帝 莱扎", "烈风之结界像",
                "随风旅鸟x知更鸟", "随风旅鸟x知更鸟", "随风旅鸟x知更鸟",
                "随风旅鸟x巨嘴鸟",
                "随风旅鸟x白头鹰", "随风旅鸟x白头鹰", "随风旅鸟x白头鹰",
                "随风旅鸟x鸵鸟",
                "星球改造", "随风旅鸟与迷之地图", "随风旅鸟与迷之地图", "随风旅鸟与迷之地图",
                "随风旅鸟与旅行准备", "随风旅鸟与旅行准备","随风旅鸟与旅行准备",
                "随风旅鸟与梦之町", "随风旅鸟与未知之风",
                "强欲而谦虚之壶","强欲而谦虚之壶","强欲而谦虚之壶",
                "金满而谦虚之壶","金满而谦虚之壶","金满而谦虚之壶",
                "墓穴的指名者", "墓穴的指名者", "抹杀之指名者", "抹杀之指名者",
                "灰流丽","无限泡影","次元吸引者","次元吸引者","次元吸引者",
                "冥王结界波","冥王结界波","冥王结界波",
                "虚无空间"
        };

        this.deckList = new ArrayList<String>(Arrays.asList(deckList));
    }

    @Override
    public void cardPoolInitialization(){
        addMonsterToCardPool("随风旅鸟x知更鸟", "水","鸟兽", "N/A", new ArrayList<String>(){{add("随风旅鸟");}},1,600,1200);
        addMonsterToCardPool("随风旅鸟x白头鹰", "风","鸟兽", "N/A",new ArrayList<String>(){{add("随风旅鸟");}},1,800,1000);
        addMonsterToCardPool("随风旅鸟x巨嘴鸟", "风","鸟兽", "N/A",new ArrayList<String>(){{add("随风旅鸟");}},1,500,1300);
        addMonsterToCardPool("随风旅鸟x鸵鸟", "水","鸟兽", "N/A",new ArrayList<String>(){{add("随风旅鸟");}},1,700,1100);
        addMonsterToCardPool("随风旅鸟x帝企", "风","鸟兽", "N/A",new ArrayList<String>(){{add("随风旅鸟");}},10,2700,1000);
        addMonsterToCardPool("霞之谷的巨神鸟", "风","鸟兽", "N/A",new ArrayList<String>(){{add("霞之谷");}},7,2700,2000);
        addMonsterToCardPool("烈风帝 莱扎", "风","鸟兽", "N/A",new ArrayList<String>(){{add("帝王");}},8,2800,1000);
        addMonsterToCardPool("烈风之结界像", "风","鸟兽", "N/A",new ArrayList<String>(){{add("结界像");}},4,1000,1000);
        addMonsterToCardPool("灰流丽", "炎","不死", "N/A",new ArrayList<>(),3,0,1800);
        cardPool.put("增殖的g", new MaxxC());
        cardPool.put("次元吸引者", new DimensionShifter());

        addSpellToCardPool("随风旅鸟与迷之地图", "场地", new ArrayList<String>(){{add("随风旅鸟");}});
        cardPool.put("星球改造", new Terraforming());
        cardPool.put("随风旅鸟与旅行准备", new FlundereezeAndTheJourneyPreparations());
        cardPool.put("随风旅鸟与未知之风", new FlundereezeAndTheUnknownWind());
        cardPool.put("强欲而谦虚之壶", new PotOfDuality());
        cardPool.put("金满而谦虚之壶", new PotOfProsperity());
        addSpellToCardPool("墓穴的指名者", "速攻", new ArrayList<>());
        addSpellToCardPool("抹杀之指名者", "速攻", new ArrayList<>());
        addSpellToCardPool("抹杀之指名者", "速攻", new ArrayList<>());
        addSpellToCardPool("冥王结界波", "通常", new ArrayList<>());
        cardPool.put("吓人手中盒", new JackInTheHand());

        addTrapToCardPool("随风旅鸟与梦之町", "通常", new ArrayList<String>(){{add("随风旅鸟");}});
        addTrapToCardPool("无限泡影", "通常", new ArrayList<>());
        addTrapToCardPool("虚无空间", "永续", new ArrayList<String>(){{add("虚无");}});
        addTrapToCardPool("蛊惑谋陷", "通常", new ArrayList<>());
        addTrapToCardPool("鹰身女妖的羽毛吹雪", "通常", new ArrayList<String>(){{add("鹰身女妖");}});

    }

    @Override
    public Deck deck(){
        Deck deck = new Deck();

        for(String card: deckList){
            deck.addCard(cardPool.get(card));
        }

        return deck;
    }

    @Override
    public void addGoSecondTags(Hand hand) {

    }

    @Override
    public boolean handPlayable(Hand hand) {
        if(new OpeningCombination("虚无空间").checkHandCombination(hand)){
            hand.addTag("虚无空间");
        }

        if(new OpeningCombination("随风旅鸟x白头鹰", "随风旅鸟与未知地图").checkHandCombination(hand)){
            hand.addTag("防灰流丽");
            return true;
        }
        else if(new OpeningCombination("随风旅鸟x知更鸟").checkHandCombination(hand)){
            return true;
        }
        else if(new OpeningCombination("随风旅鸟x巨嘴鸟", "随风旅鸟与迷之地图").checkHandCombination(hand)){
            return true;
        }
        else if(new OpeningCombination("随风旅鸟x鸵鸟", "随风旅鸟与迷之地图").checkHandCombination(hand)){
            return true;
        }
        else if(new Strich().checkHandCombination(hand) &&
                new OpeningCombination("随风旅鸟x白头鹰").checkHandCombination(hand)){
            return true;
        }
        else if(new OpeningCombination("随风旅鸟x白头鹰", "随风旅鸟与梦之町", "随风旅鸟x巨嘴鸟").checkHandCombination(hand)){
            hand.addTag("防无限泡影");
            return true;
        }
        else if(new OpeningCombination("随风旅鸟x白头鹰", "随风旅鸟与梦之町", "随风旅鸟x鸵鸟").checkHandCombination(hand)){
            hand.addTag("防无限泡影");
            return true;
        }
        else if(new Strich().checkHandCombination(hand) &&
                new OpeningCombination("随风旅鸟x巨嘴鸟", "随风旅鸟与梦之町", "随风旅鸟x帝企").checkHandCombination(hand)){
            hand.addTag("防无限泡影");
            return true;
        }
        return false;
    }

    @Override
    public void addTagsToHand(Hand hand) {
        new CrossoutDesignator().checkHandCombination(hand);
        new CalledByTheGrave().checkHandCombination(hand);
        new TheJourneyPreparations().checkHandCombination(hand);
    }
}
