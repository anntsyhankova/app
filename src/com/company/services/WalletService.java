package com.company.services;

public class WalletService {

    public int getWallet(){
        return UserHandler.currentUser.getWallet();
    }

    public void addToWallet(int money){
        UserHandler.currentUser.setWallet(money + UserHandler.currentUser.getWallet());
    }
}
