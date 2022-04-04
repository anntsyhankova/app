package com.company.entity;

public class User {

    private String name;
    private int wallet = 700;

    public User(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getWallet() {
        return this.wallet;
    }

    public void setWallet(int wallet){
        this.wallet = wallet;
    }
}
