package com.company.command;

import com.company.entity.Synopsis;
import com.company.services.SynopsisDispatcher;

interface CommandProcessor {

    default boolean printSynopsis(Command command){
        SynopsisDispatcher synopsisDispatcher = new SynopsisDispatcher();
        Synopsis synopsis = synopsisDispatcher.commandToSynopsis(command);
        System.out.println(synopsis.getMessage());
        return true;
    };

    boolean execute(Command command);
}
