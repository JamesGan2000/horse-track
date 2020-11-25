package com.example.horsetrack.horsetrack;

public class CommandInfo {
    private String param1;
    private String param2;

    private String message = "";

    private boolean restock= false;
    private boolean quit= false;
    private boolean reSetWinningHorse= false;
    private boolean bet= false;
    private boolean start = false;
    private boolean valid = false;

    Integer betHorse;
    Integer betAmount;

    public boolean isStart() {
        return start;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    public String getParam2() {
        return param2;
    }

    public void setParam2(String param2) {
        this.param2 = param2;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isRestock() {
        return restock;
    }

    public void setRestock(boolean restock) {
        this.restock = restock;
    }

    public boolean isQuit() {
        return quit;
    }

    public void setQuit(boolean quit) {
        this.quit = quit;
    }

    public boolean isReSetWinningHorse() {
        return reSetWinningHorse;
    }

    public void setReSetWinningHorse(boolean reSetWinningHorse) {
        this.reSetWinningHorse = reSetWinningHorse;
    }

    public boolean isBet() {
        return bet;
    }

    public void setBet(boolean bet) {
        this.bet = bet;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public Integer getBetHorse() {
        return betHorse;
    }

    public void setBetHorse(Integer betHorse) {
        this.betHorse = betHorse;
    }

    public Integer getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(Integer betAmount) {
        this.betAmount = betAmount;
    }
}
