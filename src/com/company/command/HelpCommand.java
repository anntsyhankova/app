package com.company.command;

import java.util.List;
import java.util.Objects;

public class HelpCommand implements CommandProcessor{

    @Override
    public boolean execute(Command command) {
        if (command.args().isEmpty()) {
            List<CommandType> filteredList = CommandDispatcher.processorMap
                    .keySet()
                    .stream()
                    .filter(type -> !Objects.equals(type.getName(), ""))
                    .toList();
            filteredList.forEach(type -> CommandDispatcher.processorMap.get(type).printSynopsis(new Command(type.getName())));
            return true;
        }
        else {
            command.args().forEach(type -> {
                try {
                    CommandDispatcher.processorMap
                            .get(CommandType
                                    .valueOf(type.toUpperCase()))
                            .printSynopsis(new Command(type));

                }
                catch (Exception e){
                    printSynopsis(new Command(type));
                }
            }
            );
            return true;
        }
    }
}
