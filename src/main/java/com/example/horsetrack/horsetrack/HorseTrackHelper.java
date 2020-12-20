package com.example.horsetrack.horsetrack;

import java.util.ArrayList;
import java.util.List;

public class HorseTrackHelper {
    static List<HorseOdd> horseInfos = HorseTrackInitalizer.initialHorseOdds();
    static List<InventoryItem> balances = HorseTrackInitalizer.initialInventory();;

    public static List<HorseOdd> getHorseInfos() {
        return horseInfos;
    }

    public static List<InventoryItem> getBalances() {
        return balances;
    }

    public static void restockCashInventory(){
        balances = HorseTrackInitalizer.initialInventory();
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
}
