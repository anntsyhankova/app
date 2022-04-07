package com.company.command;

import java.util.HashMap;
import java.util.Map;

public class CommandDispatcher {

    public static Map<CommandType, CommandProcessor> processorMap = new HashMap<>();

    public CommandDispatcher(){
        processorMap.put(CommandType.INFO, new InfoCommand());
        processorMap.put(CommandType.BUY, new BuyCommand());
        processorMap.put(CommandType.EMPTY, new UndefinedCommand());
        processorMap.put(CommandType.EXIT, new ExitCommand());
        processorMap.put(CommandType.UNDEFINED, new UndefinedCommand());
        processorMap.put(CommandType.BALANCE, new BalanceCommand());
        processorMap.put(CommandType.WALLET, new WalletCommand());
        processorMap.put(CommandType.HELP, new HelpCommand());
    }

    public void process(String commandLine){
        Command command = new Command(commandLine);
        processorMap.get(command.type()).execute(command);
    }

}

