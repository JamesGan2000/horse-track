package com.example.horsetrack.horsetrack;

public class HorseOdd {
    private Integer horseNumber;
    private String horseName;
    private Integer odds;
    private boolean win;

    public HorseOdd(Integer horseNumber, String horseName, Integer odds, boolean win) {
        this.horseNumber = horseNumber;
        this.horseName = horseName;
        this.odds = odds;
        this.win = win;
    }

    public Integer getHorseNumber() {
        return horseNumber;
    }

    public void setHorseNumber(Integer horseNumber) {
        this.horseNumber = horseNumber;
    }

    public String getHorseName() {
        return horseName;
    }

    public void setHorseName(String horseName) {
        this.horseName = horseName;
    }

    public Integer getOdds() {
        return odds;
    }

    public void setOdds(Integer odds) {
        this.odds = odds;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    @Override
    public String toString() {
        return horseNumber + ", " + horseName + ", " + odds +
                ", " + (win ? "won" : "lost");
    }
}
