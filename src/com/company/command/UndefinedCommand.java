package com.company.command;

public class UndefinedCommand implements CommandProcessor {

    @Override
    public boolean execute(Command command) {
        System.err.println("Command is undefined. See list of allowed commands");
        CommandDispatcher.processorMap.get(CommandType.HELP).printSynopsis(new Command("help"));
        return false;
    }
}
