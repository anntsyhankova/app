package com.company.services;

import com.company.command.Command;
import com.company.command.CommandType;
import com.company.entity.Synopsis;

import java.util.HashMap;
import java.util.Map;

public class SynopsisDispatcher {

    private final Map<CommandType, Synopsis> messageMap = new HashMap<>();

    public SynopsisDispatcher(){
        messageMap.put(CommandType.HELP, new Synopsis("HELP <name of command>"));
        messageMap.put(CommandType.INFO, new Synopsis("INFO <product from storage>"));
        messageMap.put(CommandType.BUY, new Synopsis("BUY <product from storage>"));
        messageMap.put(CommandType.EXIT, new Synopsis("EXIT"));
        messageMap.put(CommandType.WALLET, new Synopsis("WALLET <amount of money>"));
        messageMap.put(CommandType.BALANCE, new Synopsis("BALANCE"));
    }

    public Synopsis commandToSynopsis(Command command){

        CommandType commandType = command.type();
        return messageMap.getOrDefault(commandType, new Synopsis("Sorry, no help for this command: " + command.getName()));
    }

}
