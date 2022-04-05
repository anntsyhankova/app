package com.company.command;

public class CommandProcessor {

    public void process(String commandLine){
        String line = processCommandLine(commandLine).toLowerCase();

        Command command;
        switch (line) {
            case "info" -> command = new InfoCommand();
            case "buy" -> command = new BuyCommand();
            case "exit" -> command = new ExitCommand();
            case "wallet" -> command = new WalletCommand();
            case "bank" -> command = new BankCommand();
            default -> command = new UndefinedCommand();
        }

        command.execute();
    }

    private String processCommandLine(String commandLine){
        String[] parts = commandLine.trim().split(" ", 2);
        if (parts.length==0){
            return "";
        } else {
            return parts[0];
        }
    }

//    CommandType type(){
//    String[] parts = command.trim().split(" ", 2);
//    if (parts.length==0){
//        return CommandType.EMPTY;
//    } else if (types.contains(parts[0].toLowerCase())){
//        return CommandType.valueOf(parts[0].toUpperCase());
//    } else {
//        return CommandType.UNAVAILABLE;
//    }
//    }


//
//    List<String> args(){
//        return Arrays.stream(command.trim().split(" "))
//                .skip(1)
//                .filter(s->!s.isEmpty())
//                .collect(Collectors.toList());
//    }
}

