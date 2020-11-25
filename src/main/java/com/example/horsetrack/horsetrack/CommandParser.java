package com.example.horsetrack.horsetrack;

import org.apache.dubbo.common.utils.StringUtils;

public class CommandParser {
    public CommandInfo parse(String param1, String param2){
        CommandInfo commandInfo = new CommandInfo();
        commandInfo.setParam1(param1);
        commandInfo.setParam2(param2);

        if("R".equalsIgnoreCase(param1)){
            commandInfo.setValid(true);
            commandInfo.setRestock(true);
        }else if("Q".equalsIgnoreCase(param1)){
            commandInfo.setValid(true);
            commandInfo.setQuit(true);
        }else if("W".equalsIgnoreCase(param1)){
            commandInfo.setReSetWinningHorse(true);
            if(StringUtils.isInteger(param2)){
                commandInfo.setValid(true);
            }else{
                commandInfo.setMessage("Invalid Bet Amount: " + param2);
            }
        }else if(StringUtils.isInteger(param1)){
            commandInfo.setBet(true);
            if(StringUtils.isInteger(param2)){
                commandInfo.setValid(true);
                commandInfo.setBetHorse(Integer.valueOf(param1));
                commandInfo.setBetAmount(Integer.valueOf(param2));
            }else{
                commandInfo.setMessage("Invalid Bet: " + param2);
            }
        }else if(StringUtils.isBlank(param1) && StringUtils.isBlank(param2)){
            commandInfo.setValid(true);
            commandInfo.setStart(true);
        }else{
            commandInfo.setValid(false);
            commandInfo.setMessage("Invalid Command:" + param1 + " " + param2);
        }
        return commandInfo;
    };
}
