package com.example.horsetrack.horsetrack;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorseTrackHandler {
    private CommandParser commandParser = new CommandParser();

    public String handle(String param1, String param2){
        CommandInfo commandInfo = commandParser.parse(param1, param2);
        if(!commandInfo.isValid()){
            return commandInfo.getMessage();
        }else if(commandInfo.isQuit()){
            commandInfo.setMessage("QUIT");
        }else if(commandInfo.isRestock()){
            HorseTrackHelper.restockCashInventory();
            commandInfo.setMessage(HorseTrackHelper.displayCurrentInventory() + "<br/>" +
                    HorseTrackHelper.displayCurrentHorseInfo());
        }else if(commandInfo.isReSetWinningHorse()){
            HorseOdd horseOdd = HorseTrackHelper.findByHorseNumber(Integer.valueOf(param2));
            if(horseOdd == null){
                commandInfo.setMessage("Invalid Horse Number:" + param2);
            }else{
                HorseTrackHelper.resetWinningHorse(Integer.valueOf(param2));
                commandInfo.setMessage(HorseTrackHelper.displayCurrentInventory() + "<br/>" +
                        HorseTrackHelper.displayCurrentHorseInfo());
            }
        }else if(commandInfo.isBet()){
            BetResult betResult = HorseTrackHelper.bet(commandInfo.betHorse, commandInfo.betAmount);
            if(!betResult.isHorseFound()){
                commandInfo.setMessage("Invalid Horse Number:" + commandInfo.betHorse);
            }else if(!betResult.getMatchingHorse().isWin()){
                commandInfo.setMessage("No Payout:" + betResult.getMatchingHorse().getHorseName());
            }else if(betResult.getWinningAmount() > HorseTrackHelper.cashBalance()){
                commandInfo.setMessage("Insufficient Funds: $" + betResult.getWinningAmount());
            }else{
                List<InventoryItem> list = HorseTrackHelper.cashOut(betResult.getWinningAmount());
                commandInfo.setMessage("Payout:" + betResult.getMatchingHorse().getHorseName() + ", $" +
                        betResult.getWinningAmount() + "<br/>" +
                        HorseTrackHelper.displayPayoutInfo(list) + "<br/>" +
                        HorseTrackHelper.displayCurrentInventory() + "<br/>" +
                        HorseTrackHelper.displayCurrentHorseInfo());
            }
        }

        return commandInfo.getMessage();
    }

}
