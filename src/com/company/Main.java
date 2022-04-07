package com.company;

import com.company.command.CommandDispatcher;
import com.company.entity.User;
import com.company.services.AuthService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        User user = new User(in.nextLine());

        if (!AuthService.getInstance().auth(user, in.nextLine())){
            System.out.println("Invalid password or username");
            return;
        }

        System.out.println("Select command: info, wallet, buy, exit, help, balance");

        CommandDispatcher commandProcessor = new CommandDispatcher();
        while(true){
            System.out.println("_____________");
            System.out.println("Enter command");
            System.out.println("_____________");
            commandProcessor.process(in.nextLine());
        }
    }
}
