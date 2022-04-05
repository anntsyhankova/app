package com.company.command;

import com.company.services.WalletService;

public class WalletCommand extends Command{

    private WalletService walletService = new WalletService();

    @Override
    public boolean execute(){
        System.out.println("You have " + walletService.getWallet() + " money");
        return true;
    }
}
