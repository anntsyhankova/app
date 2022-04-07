package com.company.command;

import com.company.services.WalletService;

public class BalanceCommand implements CommandProcessor {

    private WalletService walletService = new WalletService();

    @Override
    public boolean execute(Command command){
        System.out.println("You have " + walletService.getWallet() + " money");
        return true;
    }
}
