package com.company.services;

import com.company.entity.User;

public final class AuthService {

    private static AuthService instance;

    private AuthService(){}

    public static AuthService getInstance(){
        if (instance == null){
            instance = new AuthService();
        }
        return instance;
    }

    public boolean auth(User user, String password){
        if (user.getName().equals("admin") && password.equals("password")){
            UserHandler.currentUser = user;
            return true;
        }
        return false;
    }
}
