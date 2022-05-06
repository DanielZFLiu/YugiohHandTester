package Evaluator.ArchtypeEvaluators;

import Board.Deck;
import Board.Hand;
import Cards.Cyber.CyberEmergency;
import Cards.Drytron.DrytronFafnir;
import Cards.Drytron.DrytronNova;
import Combinations.Drytron.HeraldOrangeLight;
import Combinations.Entities.OpeningCombination;
import Combinations.General.CalledByTheGrave;
import Evaluator.Entities.CardPool;
import Evaluator.Entities.EvaluationSource;
import Evaluator.Entities.HandEvaluator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DrytronEvaluator extends CardPool implements EvaluationSource {

    public static void main(String[] args) {

        HandEvaluator drytronEvaluator = new HandEvaluator(new DrytronEvaluator(), 10000);
        drytronEvaluator.showEvaluation();

    }

    public ArrayList<String> deckList = new ArrayList<>();

    public DrytronEvaluator(){
        cardPool = new HashMap<>();
        cardPoolInitialization();
        SZsDrytronList();
    }

    public void SZsDrytronList(){
        String[] deckList = new String[]{
                "龙辉巧-右枢α", "龙辉巧-右枢α","龙辉巧-右枢α",
                "龙辉巧-上弼ζ", "龙辉巧-天棓四γ", "龙辉巧-天厨一δ",
                "崇光之宣告者",
                "宣告者的神巫","宣告者的神巫","宣告者的神巫",
                "朱光之宣告者", "朱光之宣告者","朱光之宣告者",
                "电子化天使-弁天-","电子化天使-弁天-","电子化天使-弁天-",
                "地外生命","地外生命",
                "增殖的g","增殖的g","增殖的g",
                "灰流丽", "灰流丽","灰流丽",
                "极超之龙辉巧","极超之龙辉巧","极超之龙辉巧",
                "龙辉巧-扶筐增二","龙辉巧-扶筐增二","龙辉巧-扶筐增二",
                "愚蠢的埋葬",
                "流星辉巧群",
                "电子紧急呼救","电子紧急呼救","电子紧急呼救",
                "墓穴的指名者", "墓穴的指名者",
                "融合命运",
                "命运英雄 神性人", "命运英雄 冲刺人"
        };

        this.deckList = new ArrayList<>(Arrays.asList(deckList));
    }

    @Override
    public void cardPoolInitialization() {
        addMonsterToCardPool("龙辉巧-右枢α", "光", "机械", "",
                new ArrayList<String>(){{add("龙辉巧");add("不能通常召唤");}}, 1, 2000, 0);
        addMonsterToCardPool("龙辉巧-上弼ζ", "光", "机械", "",
                new ArrayList<String>(){{add("龙辉巧");add("不能通常召唤");}}, 1, 2000, 0);
        addMonsterToCardPool("龙辉巧-天棓四γ", "光", "机械", "",
                new ArrayList<String>(){{add("龙辉巧");add("不能通常召唤");}}, 1, 2000, 0);
        addMonsterToCardPool("龙辉巧-天厨一δ", "光", "机械", "",
                new ArrayList<String>(){{add("龙辉巧");add("不能通常召唤");}}, 1, 2000, 0);

        addMonsterToCardPool("崇光之宣告者", "光", "天使", "仪式",
                new ArrayList<String>(){{add("宣告者");add("不能通常召唤");}}, 12, 2000, 3000);
        addMonsterToCardPool("宣告者的神巫", "光", "天使", "",
                new ArrayList<String>(){{add("宣告者");add("调整");}}, 2, 500, 300);
        addMonsterToCardPool("朱光之宣告者", "光", "天使", "",
                new ArrayList<String>(){{add("宣告者");add("调整");}}, 2, 300, 500);

        addMonsterToCardPool("电子化天使-弁天-", "光", "天使", "仪式",
                new ArrayList<String>(){{add("电子化天使");}}, 6, 1800, 1500);
        addMonsterToCardPool("电子化天使-那沙帝弥-", "光", "天使", "仪式",
                new ArrayList<String>(){{add("电子化天使");}}, 5, 1000, 1000);

        addMonsterToCardPool("地外生命", "光", "天使", "",
                new ArrayList<>(), 1, 500, 200);


        addMonsterToCardPool("增殖的g", "地","昆虫", "",
                new ArrayList<String>(){{add("g");}},2,500,200);
        addMonsterToCardPool("灰流丽", "炎","不死", "",
                new ArrayList<>(),3,0,1800);
        addMonsterToCardPool("古遗物-圣枪", "光","天使", "",
                new ArrayList<String>(){{add("古遗物");}},5,1700,2300);
        addMonsterToCardPool("小丑与锁鸟", "风","魔法师", "",
                new ArrayList<>(),1,0,0);

        addMonsterToCardPool("命运英雄 神性人", "暗","战士", "",
                new ArrayList<String>(){{add("英雄");add("命运英雄");}},4,1600,1400);
        addMonsterToCardPool("命运英雄 冲刺人", "暗","战士", "",
                new ArrayList<String>(){{add("英雄");add("命运英雄");}},6,2100,1000);
        addSpellToCardPool("融合命运", "通常", new ArrayList<String>(){{add("融合");}});

//13001291248
        cardPool.put("龙辉巧-扶筐增二", new DrytronFafnir());
        cardPool.put("极超之龙辉巧", new DrytronNova());
        addSpellToCardPool("流星辉巧群", "仪式", new ArrayList<String>(){{add("龙辉巧");}});

        cardPool.put("电子紧急呼救", new CyberEmergency());
        addSpellToCardPool("墓穴的指名者", "速攻", new ArrayList<>());
        addSpellToCardPool("抹杀之指名者", "速攻", new ArrayList<>());
        addSpellToCardPool("禁忌的一滴", "速攻", new ArrayList<>());
        addSpellToCardPool("愚蠢的埋葬", "速攻", new ArrayList<>());

        addTrapToCardPool("filler", "通常", new ArrayList<>());
    }

    @Override
    public Deck deck() {
        Deck deck = new Deck();

        for(String card: deckList){
            deck.addCard(cardPool.get(card));
        }

        return deck;
    }

    @Override
    public void addGoSecondTags(Hand hand) {
        if(new OpeningCombination( "增殖的g").checkHandCombination(hand)){
            hand.addTag("后攻有g");
            hand.addTag("后攻有手坑");
        }

        if(new HeraldOrangeLight().checkHandCombination(hand)){
            hand.addTag("后攻有朱光");
            hand.addTag("后攻有手坑");
        }

        if(new OpeningCombination( "灰流丽").checkHandCombination(hand)){
            hand.addTag("后攻有灰");
            hand.addTag("后攻有手坑");
        }
    }

    @Override
    public boolean handPlayable(Hand hand) {

        if(new OpeningCombination("龙辉巧-右枢α", "龙辉巧-上弼ζ", "宣告者的神巫").checkHandCombination(hand)){
            hand.addTag("防灰流丽");
        }

        if(new OpeningCombination("龙辉巧-右枢α", "龙辉巧-上弼ζ", "电子化天使-弁天-").checkHandCombination(hand)){
            hand.addTag("防灰流丽");
        }

        if(new OpeningCombination(false, "龙辉巧-右枢α", "龙辉巧-上弼ζ").checkHandCombination(hand)){
            hand.addTag("大场");
            hand.addTag("防无限泡影");
            hand.addTag("防效果遮蒙者");
            return true;
        }
        else if(new OpeningCombination(false, "龙辉巧-右枢α", "龙辉巧-天棓四γ").checkHandCombination(hand)){
            hand.addTag("大场");
            return true;
        }
        else if(new OpeningCombination(false, "龙辉巧-右枢α", "龙辉巧-天厨一δ").checkHandCombination(hand)){
            hand.addTag("大场");
            return true;
        }
        else if(new OpeningCombination(false, "愚蠢的埋葬", "龙辉巧-上弼ζ").checkHandCombination(hand)){
            hand.addTag("大场");
            return true;
        }
        else if(new OpeningCombination(false, "愚蠢的埋葬", "龙辉巧-天棓四γ").checkHandCombination(hand)){
            hand.addTag("大场");
            return true;
        }
        else if(new OpeningCombination(false, "愚蠢的埋葬", "龙辉巧-天厨一δ").checkHandCombination(hand)){
            hand.addTag("大场");
            return true;
        }
        else if(new OpeningCombination(false, "龙辉巧-右枢α", "电子化天使-弁天-").checkHandCombination(hand)){
            hand.addTag("大场");
            return true;
        }
        else if(new OpeningCombination(false, "龙辉巧-上弼ζ", "电子化天使-弁天-").checkHandCombination(hand)){
            hand.addTag("大场");
            return true;
        }
        else if(new OpeningCombination(false, "龙辉巧-上弼ζ", "龙辉巧-天棓四γ").checkHandCombination(hand)){
            hand.addTag("大场");
            return true;
        }
        else if(new OpeningCombination(false, "龙辉巧-上弼ζ", "宣告者的神巫").checkHandCombination(hand)){
            hand.addTag("大场");
            return true;
        }
        else if(new OpeningCombination(false, "地外生命").checkHandCombination(hand) &&
                (new OpeningCombination("龙辉巧-上弼ζ").checkFieldCombination(hand))){
            hand.addTag("大场");
            return true;
        }
        else if(new OpeningCombination(false, "融合命运").checkHandCombination(hand)){
            return true;
        }

        else if(new OpeningCombination(false, "龙辉巧-右枢α", "愚蠢的埋葬").checkHandCombination(hand)){
            return true;
        }
        else if(new OpeningCombination(false, "龙辉巧-天厨一δ", "龙辉巧-天棓四γ").checkHandCombination(hand)){
            return true;
        }
        else if(new OpeningCombination(false, "龙辉巧-天棓四γ", "电子化天使-弁天-").checkHandCombination(hand)){
            return true;
        }
        else if(new OpeningCombination(false, "龙辉巧-天厨一δ", "电子化天使-弁天-").checkHandCombination(hand)){
            return true;
        }
        else if(new OpeningCombination(false, "龙辉巧-右枢α", "宣告者的神巫").checkHandCombination(hand)){
            return true;
        }
        else if(new OpeningCombination(false, "龙辉巧-天厨一δ", "宣告者的神巫").checkHandCombination(hand)){
            return true;
        }
        else if(new OpeningCombination(false, "龙辉巧-天棓四γ", "宣告者的神巫").checkHandCombination(hand)){
            return true;
        }
        else if(new OpeningCombination(false, "龙辉巧-上弼ζ", "龙辉巧-天厨一δ", "地外生命").checkHandCombination(hand)){
            return true;
        }

        else if(new OpeningCombination(false, "地外生命").checkHandCombination(hand) &&
                (new OpeningCombination("龙辉巧-右枢α").checkFieldCombination(hand) ||
                        new OpeningCombination("龙辉巧-天厨一δ").checkFieldCombination(hand) ||
                        new OpeningCombination("龙辉巧-天棓四γ").checkFieldCombination(hand))){

            return true;
        }


        else if(new OpeningCombination(false, "朱光之宣告者").checkHandCombination(hand) &&
                (new OpeningCombination("龙辉巧-右枢α").checkFieldCombination(hand) ||
                        new OpeningCombination("龙辉巧-上弼ζ").checkFieldCombination(hand)||
                        new OpeningCombination("龙辉巧-天厨一δ").checkFieldCombination(hand) ||
                        new OpeningCombination("龙辉巧-天棓四γ").checkFieldCombination(hand))){

            return true;
        }

        else if(new OpeningCombination(false, "灰流丽").checkHandCombination(hand) &&
                (new OpeningCombination("龙辉巧-右枢α").checkFieldCombination(hand) ||
                        new OpeningCombination("龙辉巧-上弼ζ").checkFieldCombination(hand)||
                        new OpeningCombination("龙辉巧-天厨一δ").checkFieldCombination(hand) ||
                        new OpeningCombination("龙辉巧-天棓四γ").checkFieldCombination(hand))){

            return true;
        }

        else if(new OpeningCombination(false, "增殖的g").checkHandCombination(hand) &&
                (new OpeningCombination("龙辉巧-右枢α").checkFieldCombination(hand) ||
                        new OpeningCombination("龙辉巧-上弼ζ").checkFieldCombination(hand)||
                        new OpeningCombination("龙辉巧-天厨一δ").checkFieldCombination(hand) ||
                        new OpeningCombination("龙辉巧-天棓四γ").checkFieldCombination(hand))){

            return true;
        }


        return false;
    }

    @Override
    public void addTagsToHand(Hand hand) {
        new CalledByTheGrave().checkHandCombination(hand);
        if(new OpeningCombination("灰流丽").checkHandCombination(hand)){
            hand.addTag("防增殖的g");
        }

        new HeraldOrangeLight().checkHandCombination(hand);
        if(new OpeningCombination("命运英雄 神性人").checkHandCombination(hand) ||
                new OpeningCombination("命运英雄 冲刺人").checkHandCombination(hand)){
            hand.addTag("有凤凰人废件");
        }
    }
}

