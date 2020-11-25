package com.example.horsetrack.horsetrack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HorseTrackHelperTest {

    @Test
    public void sum_value(){
       assertEquals(1360, HorseTrackHelper.valueFor(HorseTrackHelper.initialInventory()));
    }

    @Test
    public void display_inventory(){
       assertEquals("Inventory:\n" +
               "$1, 10\n" +
               "$5, 10\n" +
               "$10, 10\n" +
               "$20, 10\n" +
               "$100, 10", HorseTrackHelper.displayBalance(HorseTrackHelper.initialInventory()));
    }

    @Test
    public void displayInitialHorseInfo(){
        assertEquals("Horses:<br/>1, That DarnGray Cat, 5, won<br/>2, Fort Utopia, 10, lost<br/>3, Count Sheep, 9, lost<br/>4, Ms Traitour, 4, lost<br/>5, Real Princess, 3, lost<br/>6, Pa Kettle, 5, lost<br/>7, Gin Stinger, 6, lost", HorseTrackHelper.displayInitialHorseInfo());
    }

}