package com.company.command;


public enum CommandType {
    EXIT("exit"),
    INFO("info"),
    BUY("buy"),
    WALLET("wallet"),
    BALANCE("balance"),
    HELP("help"),
    EMPTY(""),
    UNDEFINED("");

    private String name;

    public String getName(){
        return this.name;
    }

    CommandType(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }
}
