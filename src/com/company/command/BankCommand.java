package com.company.command;

import com.company.services.WalletService;

import java.util.Scanner;

public class BankCommand extends Command{

    private WalletService walletService = new WalletService();

    @Override
    public boolean execute(){
        Scanner in = new Scanner(System.in);
        int money;
        System.out.println("Enter amount of money: ");
        money = in.nextInt();
        if (money < 0){

            if (walletService.getWallet() <= 0){
                System.err.println("You cannot withdraw money because your balance is under 0");
                return false;
            }
            if (walletService.getWallet() + money < 0) {
                System.err.println("You don't have enough money");
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
}
