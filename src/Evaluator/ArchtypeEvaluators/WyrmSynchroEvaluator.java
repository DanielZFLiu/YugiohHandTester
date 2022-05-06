package Evaluator.ArchtypeEvaluators;

import Board.*;
import Cards.BraveToken.JourneyOfDestiny;
import Cards.BraveToken.RiteOfAramesia;
import Cards.BraveToken.WaterEnchantress;
import Cards.General.MaxxC;
import Cards.General.PotOfProsperity;
import Cards.General.PotOfProsperityFor3;
import Combinations.Entities.OpeningCombination;
import Combinations.Flundereeze.Strich;
import Combinations.General.CalledByTheGrave;
import Combinations.General.CrossoutDesignator;
import Evaluator.Entities.CardPool;
import Evaluator.Entities.EvaluationSource;
import Evaluator.Entities.HandEvaluator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class WyrmSynchroEvaluator extends CardPool implements EvaluationSource {

    public static void main(String[] args) {
        HandEvaluator wyrmEvaluator = new HandEvaluator(new WyrmSynchroEvaluator(), 1000000);
        wyrmEvaluator.showEvaluation();

    }

    public WyrmSynchroEvaluator(){
        cardPool = new HashMap<>();
        cardPoolInitialization();
        SZsWyrmList();
    }

    private ArrayList<String> deckList = new ArrayList<>();

    public void SZsWyrmList(){

//        String[] deckList = new String[]{
//                "雷仙神", "雷仙神", "天威龙-宽恕蟠龙", "天威龙-大同蟠龙", "天威龙-大同蟠龙",
//                "圣殿的水遣", "圣殿的水遣", "阿拉弥塞亚之仪", "流离的狮鹫高手", "法外骑士", "命运之旅路", "骑龙 驼龙",
//                "十六夜蔷薇龙", "赤蔷薇龙", "赤蔷薇龙", "赤蔷薇龙", "馨香蔷薇的发芽",
//                "地龙星-狴犴", "光龙星-螭吻", "龙星的九支",
//                "喷气同调士", "喷气同调士", "喷气同调士",
//                "幻兽机 猎户座飞狮", "幻兽机 猎户座飞狮",
//                "金满而谦虚之壶","金满而谦虚之壶",
//                "墓穴的指名者", "墓穴的指名者", "抹杀之指名者",
//                "灰流丽","灰流丽","灰流丽",
//                "增殖的g","增殖的g","增殖的g",
//                "无限泡影", "无限泡影", "无限泡影", "相剑暗转"
//        };
        String[] deckList = new String[]{
                "雷仙神", "雷仙神", "雷仙神", "天威龙-宽恕蟠龙", "天威龙-大同蟠龙", "天威龙-大同蟠龙",
                "圣殿的水遣", "圣殿的水遣", "阿拉弥塞亚之仪", "流离的狮鹫高手", "法外骑士", "命运之旅路", "骑龙 驼龙",
                "十六夜蔷薇龙", "赤蔷薇龙", "赤蔷薇龙", "赤蔷薇龙", "馨香蔷薇的发芽",
                "地龙星-狴犴", "光龙星-螭吻", "龙星的九支",
                "喷气同调士", "喷气同调士",
                "幻兽机 猎户座飞狮", "幻兽机 猎户座飞狮",
                "金满而谦虚之壶","金满而谦虚之壶",
                "墓穴的指名者", "墓穴的指名者", "抹杀之指名者",
                "灰流丽","灰流丽","灰流丽",
                "增殖的g","增殖的g","增殖的g",
                "无限泡影", "无限泡影", "无限泡影", "相剑暗转"
        };

        this.deckList = new ArrayList<String>(Arrays.asList(deckList));
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
    public void cardPoolInitialization(){
        addMonsterToCardPool("雷仙神", "光","雷", "N/A", new ArrayList<String>(){{add("特殊召唤");}},7,2700,2400);
        addMonsterToCardPool("流离的狮鹫高手", "风","鸟兽", "N/A", new ArrayList<String>(){{add("特殊召唤");}},7,2000,2800);
        addMonsterToCardPool("法外骑士", "暗","恶魔", "N/A", new ArrayList<String>(){{add("特殊召唤");}},7,2000,2000);
        addMonsterToCardPool("天威龙-宽恕蟠龙", "光","幻龙", "N/A", new ArrayList<String>(){{add("特殊召唤");add("天威");}},7,1600,2600);
        addMonsterToCardPool("天威龙-大同蟠龙", "暗","幻龙", "N/A", new ArrayList<String>(){{add("特殊召唤");add("天威");}},7,1500,2500);
        addMonsterToCardPool("十六夜蔷薇龙", "暗","龙", "N/A", new ArrayList<String>(){{add("蔷薇");add("调整");}},3,1600,1200);
        addMonsterToCardPool("地龙星-狴犴", "地","幻龙", "N/A", new ArrayList<String>(){{add("龙星");}},3,1600,0);
        cardPool.put("圣殿的水遣", new WaterEnchantress());
        addMonsterToCardPool("赤蔷薇龙", "暗","龙", "N/A", new ArrayList<String>(){{add("调整");add("蔷薇");}},3,1000,1800);
        addMonsterToCardPool("幻兽机 猎户座飞狮", "风","机械", "N/A", new ArrayList<String>(){{add("调整");add("幻兽机");}},3,600,1000);
        addMonsterToCardPool("喷气同调士", "炎","机械", "N/A", new ArrayList<String>(){{add("调整");add("同调士");}},1,500,0);
        addMonsterToCardPool("光龙星-螭吻", "光","幻龙", "N/A", new ArrayList<String>(){{add("龙星");}},1,0,0);
        addMonsterToCardPool("灰流丽", "炎","不死", "N/A", new ArrayList<String>(){{add("调整");}},3,0,1800);
        cardPool.put("增殖的g", new MaxxC());

        cardPool.put("金满而谦虚之壶", new PotOfProsperityFor3());
        cardPool.put("阿拉弥塞亚之仪", new RiteOfAramesia());
//        addSpellToCardPool("愚蠢的埋葬", "通常", new ArrayList<>());
        addSpellToCardPool("墓穴的指名者", "速攻", new ArrayList<>());
        addSpellToCardPool("抹杀之指名者", "速攻", new ArrayList<>());
        addSpellToCardPool("馨香蔷薇的发芽", "速攻", new ArrayList<String>(){{add("蔷薇");}});
        cardPool.put("命运之旅路", new JourneyOfDestiny());
        addSpellToCardPool("骑龙 驼龙", "装备", new ArrayList<String>(){{add("记述 勇者衍生物");}});

        addTrapToCardPool("无限泡影", "通常", new ArrayList<>());
        addTrapToCardPool("相剑暗转", "通常", new ArrayList<>());
        addTrapToCardPool("龙星的九支", "反击", new ArrayList<>());
    }

    @Override
    public void addGoSecondTags(Hand hand) {

    }

    @Override
    public boolean handPlayable(Hand hand) {
        if(new OpeningCombination("雷仙神", "雷仙神").checkHandCombination(hand)){
            hand.addTag("大场面");
            return true;
        }
        else if(new OpeningCombination("雷仙神", "流离的狮鹫高手").checkHandCombination(hand)){
            hand.addTag("大场面");
            return true;
        }
        else if(new OpeningCombination("雷仙神", "法外骑士").checkHandCombination(hand)){
            hand.addTag("大场面");
            return true;
        }
        else if(new OpeningCombination("雷仙神", "天威龙-宽恕蟠龙").checkHandCombination(hand)){
            hand.addTag("大场面");
            return true;
        }
        else if(new OpeningCombination("雷仙神", "天威龙-大同蟠龙").checkHandCombination(hand)){
            hand.addTag("大场面");
            return true;
        }
        else if(new OpeningCombination("流离的狮鹫高手", "法外骑士").checkHandCombination(hand)){
            hand.addTag("大场面");
            return true;
        }
        else if(new OpeningCombination("流离的狮鹫高手", "天威龙-宽恕蟠龙").checkHandCombination(hand)){
            hand.addTag("大场面");
            return true;
        }
        else if(new OpeningCombination("流离的狮鹫高手", "天威龙-大同蟠龙").checkHandCombination(hand)){
            hand.addTag("大场面");
            return true;
        }
        else if(new OpeningCombination("法外骑士", "天威龙-宽恕蟠龙").checkHandCombination(hand)){
            hand.addTag("大场面");
            return true;
        }
        else if(new OpeningCombination("法外骑士", "天威龙-大同蟠龙").checkHandCombination(hand)){
            hand.addTag("大场面");
            return true;
        }


        else if(new OpeningCombination("雷仙神", "赤蔷薇龙").checkHandCombination(hand)){
            hand.addTag("大场面");
            return true;
        }
        else if(new OpeningCombination("流离的狮鹫高手", "赤蔷薇龙").checkHandCombination(hand)){
            hand.addTag("大场面");
            return true;
        }
        else if(new OpeningCombination("法外骑士", "赤蔷薇龙").checkHandCombination(hand)){
            hand.addTag("大场面");
            return true;
        }
        else if(new OpeningCombination("天威龙-宽恕蟠龙", "赤蔷薇龙").checkHandCombination(hand)){
            hand.addTag("大场面");
            return true;
        }
        else if(new OpeningCombination("天威龙-大同蟠龙", "赤蔷薇龙").checkHandCombination(hand)){
            hand.addTag("大场面");
            return true;
        }


        else if(new OpeningCombination("喷气同调士").checkHandCombination(hand)){
            hand.addTag("单水机");
            return true;
        }
        else if(new OpeningCombination("幻兽机 猎户座飞狮", "幻兽机 猎户座飞狮").checkHandCombination(hand)){
            hand.addTag("单水机");
            return true;
        }

        else if(new OpeningCombination("特殊召唤", "调整").checkTagsCombination(hand) == 1){
            hand.addTag("单水机");
            return true;
        }

        else if(new OpeningCombination("圣殿的水遣").checkHandCombination(hand)){
            hand.addTag("菜逼场");
        }
        else if(new OpeningCombination("阿拉弥塞亚之仪").checkHandCombination(hand)){
            hand.addTag("菜逼场");
        }
        else if(new OpeningCombination("命运之旅路", "流离的狮鹫高手").checkHandCombination(hand)){
            hand.addTag("菜逼场");
        }
        else if(new OpeningCombination("命运之旅路", "法外骑士").checkHandCombination(hand)){
            hand.addTag("菜逼场");
        }

        return false;
    }

    @Override
    public void addTagsToHand(Hand hand) {
//        new CrossoutDesignator().checkHandCombination(hand);
//        if(new OpeningCombination("灰流丽").checkHandCombination(hand)){
//            hand.addTag("防增殖的g");
//        }
//        new CalledByTheGrave().checkHandCombination(hand);
    }
}

/*
(菜逼场算是卡手)
不卡手率: 0.848418
大场面: 0.442445
单水机: 0.405973
菜逼场: 0.093364

不确定(真正概率比测的高)
防灰流丽: 0.372971
防无限泡影: 0.138627
防效果遮蒙者: 0.264457

确定:
防大宇宙人: 0.237179487
防小丑与锁鸟: 0.237179487
防增殖的g: 0.577123682
* */