package com.example.horsetrack.horsetrack;

import java.util.List;
import java.util.stream.Collectors;

public class HorseTrackViewHelper {
    public static String displayInitialHorseInfo(){
        return "Horses:<br/>" + HorseTrackInitalizer.initialHorseOdds().stream().map(Object::toString)
                .collect(Collectors.joining("<br/>"));
    }

    public static String displayInitialInventory(){
        return "Inventory:<br/>" + HorseTrackInitalizer.initialInventory().stream().map(Object::toString)
                .collect(Collectors.joining("<br/>"));
    }

    public static String displayCurrentHorseInfo(List<HorseOdd> horseInfos){
        return "Horses:<br/>" + horseInfos.stream().map(Object::toString)
                .collect(Collectors.joining("<br/>"));
    }

    public static String displayPayoutInfo(List<InventoryItem> list){
        return "Dispensing:<br/>" + list.stream().map(Object::toString)
                .collect(Collectors.joining("<br/>"));
    }

    public static String displayCurrentInventory(List<InventoryItem> balances){
        return "Inventory:<br/>" + balances.stream().map(Object::toString)
                .collect(Collectors.joining("<br/>"));
    }

    public static String displayBalance(List<InventoryItem> inventoryItems){
        return "Inventory:\n" + inventoryItems.stream().map(Object::toString)
                .collect(Collectors.joining("\n"));
    }

    public static Integer valueFor(List<InventoryItem> inventoryItems){
        return inventoryItems.stream().mapToInt(x -> x.value()).sum();
    }

}
