package com.example.horsetrack.horsetrack;

import java.util.ArrayList;
import java.util.List;

public class HorseTrackInitalizer {
    public static List<HorseOdd> initialHorseOdds(){
        List<HorseOdd> horseInfos = new ArrayList<>();
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
        List<InventoryItem> balances = new ArrayList<>();
        balances.add(new InventoryItem(1, 10));
        balances.add(new InventoryItem(5, 10));
        balances.add(new InventoryItem(10, 10));
        balances.add(new InventoryItem(20, 10));
        balances.add(new InventoryItem(100, 10));

        return balances;
    }
}
