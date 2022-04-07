package com.company.command;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Command {

    private final String commandLine;
    private static final Set<String> types = Arrays.stream(CommandType.values())
                                                    .map(ct->ct.getName())
                                                    .collect(Collectors.toSet());

    public Command(String commandLine) {
        this.commandLine = commandLine;
    }

    public String getName(){
        return commandLine.trim().split(" ", 2)[0];
    }

    public CommandType type(){
        String name = getName();

        if (name.isEmpty()){
            return CommandType.EMPTY;
        }
        else if (types.contains(name.toLowerCase())){
            return CommandType.valueOf(name.toUpperCase());
        } else {
            return CommandType.UNDEFINED;
        }
    }

    public List<String> args(){
        return Arrays.stream(commandLine.trim().split(" "))
            .skip(1)
            .filter(s->!s.isEmpty())
            .collect(Collectors.toList());
    }
}
