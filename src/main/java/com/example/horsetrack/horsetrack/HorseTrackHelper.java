package com.example.horsetrack.horsetrack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HorseTrackHelper {
    static List<HorseOdd> horseInfos;
    static List<InventoryItem> balances;

    public static void restockCashInventory(){
        balances = initialInventory();
    }

    public static BetResult bet(Integer horseNumber, Integer betAmount){
        BetResult betResult = new BetResult();
        betResult.setMatchingHorse(findByHorseNumber(horseNumber));

        if(betResult.isHorseFound()){
            if(betResult.getMatchingHorse().isWin()){
                betResult.setWinningAmount(betResult.getMatchingHorse().getOdds() * betAmount);
            }
        }
        return betResult;
    }


    public static void resetWinningHorse(Integer horseNumber){
        for (HorseOdd horseInfo : horseInfos) {
            horseInfo.setWin(horseInfo.getHorseNumber().equals(horseNumber));
        }
    }

    public static HorseOdd findByHorseNumber(Integer horseNumber){
        for (HorseOdd horseInfo : horseInfos) {
            if(horseInfo.getHorseNumber().equals(horseNumber)){
                return horseInfo;
            }
        }
        return null;
    }

    public static List<HorseOdd> initialHorseOdds(){
        horseInfos = new ArrayList<>();
        horseInfos.add(new HorseOdd(1, "That DarnGray Cat", 5, true));
        horseInfos.add(new HorseOdd(2, "Fort Utopia", 10, false));
        horseInfos.add(new HorseOdd(3, "Count Sheep", 9, false));
        horseInfos.add(new HorseOdd(4, "Ms Traitour", 4, false));
        horseInfos.add(new HorseOdd(5, "Real Princess", 3, false));
        horseInfos.add(new HorseOdd(6, "Pa Kettle", 5, false));
        horseInfos.add(new HorseOdd(7, "Gin Stinger", 6, false));
        return horseInfos;
    }

    public static List<InventoryItem> initialInventory(){
        balances = new ArrayList<>();
        balances.add(new InventoryItem(1, 10));
        balances.add(new InventoryItem(5, 10));
        balances.add(new InventoryItem(10, 10));
        balances.add(new InventoryItem(20, 10));
        balances.add(new InventoryItem(100, 10));

        return balances;
    }

    public static List<InventoryItem> cashOut(Integer payAmount){
        Integer remainingPayoutAmount = payAmount;

        List<InventoryItem> payoutInfo = new ArrayList<>();

        for (int i = balances.size() - 1; i >= 0; i--) {
            if(remainingPayoutAmount < 1){
                return payoutInfo;
            }

            InventoryItem s = balances.get(i);
            Integer count = s.getCount();

            int value1 = remainingPayoutAmount / s.getDollar();

            int min = Math.min(count, value1);
            s.setCount(s.getCount() - min);

            remainingPayoutAmount -= min * s.getDollar();

            payoutInfo.add(new InventoryItem(s.getDollar(), min));
        }

        return payoutInfo;
    }

    public static Integer cashBalance(){
        return balances.stream().mapToInt(x -> x.value()).sum();
    }

    public static String displayCurrentHorseInfo(){
        return "Horses:<br/>" + horseInfos.stream().map(Object::toString)
                .collect(Collectors.joining("<br/>"));
    }

    public static String displayPayoutInfo(List<InventoryItem> list){
        return "Dispensing:<br/>" + list.stream().map(Object::toString)
                .collect(Collectors.joining("<br/>"));
    }

    public static String displayCurrentInventory(){
        return "Inventory:<br/>" + balances.stream().map(Object::toString)
                .collect(Collectors.joining("<br/>"));
    }

    public static String displayInitialHorseInfo(){
        return "Horses:<br/>" + initialHorseOdds().stream().map(Object::toString)
                .collect(Collectors.joining("<br/>"));
    }

    public static String displayInitialInventory(){
        return "Inventory:<br/>" + initialInventory().stream().map(Object::toString)
                .collect(Collectors.joining("<br/>"));
    }

    public static Integer valueFor(List<InventoryItem> inventoryItems){
        return inventoryItems.stream().mapToInt(x -> x.value()).sum();
    }

    public static String displayBalance(List<InventoryItem> inventoryItems){
        return "Inventory:\n" + inventoryItems.stream().map(Object::toString)
                .collect(Collectors.joining("\n"));
    }


}
