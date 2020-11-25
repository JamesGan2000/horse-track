package com.example.horsetrack.horsetrack;

public class BetResult {
    private HorseOdd matchingHorse;
    private Integer winningAmount;
    private boolean horseFound;

    public HorseOdd getMatchingHorse() {
        return matchingHorse;
    }

    public void setMatchingHorse(HorseOdd matchingHorse) {
        this.matchingHorse = matchingHorse;
        this.horseFound = (matchingHorse != null);

    }

    public Integer getWinningAmount() {
        return winningAmount;
    }

    public void setWinningAmount(Integer winningAmount) {
        this.winningAmount = winningAmount;
    }

    public boolean isHorseFound() {
        return horseFound;
    }

    public void setHorseFound(boolean horseFound) {
        this.horseFound = horseFound;
    }
}
