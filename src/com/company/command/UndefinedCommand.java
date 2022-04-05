package com.company.command;

public class UndefinedCommand extends Command{

    @Override
    public boolean execute(){
        System.err.println("Command is undefined");
        return false;
    }
}
