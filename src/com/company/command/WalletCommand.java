package com.company.command;

import com.company.services.WalletService;

import java.util.Scanner;

public class WalletCommand implements CommandProcessor {

    private WalletService walletService = new WalletService();

    private boolean printChangedBalance(int money){
        if (money < 0){

            if (walletService.getWallet() <= 0){
                System.err.println("You cannot withdraw money because your balance is under 0. Use command to check your balance: ");
                CommandDispatcher.processorMap.get(CommandType.BALANCE).printSynopsis(new Command("balance"));
                return false;
            }
            if (walletService.getWallet() + money < 0) {
                System.err.println("You don't have enough money. Use command to check your balance: ");
                CommandDispatcher.processorMap.get(CommandType.BALANCE).printSynopsis(new Command("balance"));
                return false;
            }
            System.out.println("You withdraw money");
        }
        else {
            System.out.println("You entered money");
        }
        walletService.addToWallet(money);
        return true;
    }

    private boolean proofInt(Command command){
        try {
            int money = Integer.parseInt(command.args().get(0));
            printChangedBalance(money);
            return true;
        }
        catch (NumberFormatException e){
            System.err.println("Argument is not a number. See example for right usage of arguments:");
            CommandDispatcher.processorMap.get(command.type()).printSynopsis(command);
        }
        return false;
    }

    @Override
    public boolean execute(Command command){
        if (command.args().size() == 1){
            proofInt(command);
            return true;
        }
        else if (command.args().size() > 1){
            System.err.println("You cannot use more than 2 args. See example for right usage of arguments:");
            CommandDispatcher.processorMap.get(command.type()).printSynopsis(command);
            return false;
        }

        System.out.println("Enter amount of money: ");
        printChangedBalance(new Scanner(System.in).nextInt());
        return true;
    }
}
