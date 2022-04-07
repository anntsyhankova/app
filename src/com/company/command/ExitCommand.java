package com.company.command;

public class ExitCommand implements CommandProcessor {

    @Override
    public boolean execute(Command command) {
        System.exit(0);
        return false;
    }
}
