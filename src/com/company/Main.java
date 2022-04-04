package com.company;

import com.company.entity.Product;
import com.company.entity.User;
import com.company.services.AuthService;
//import com.company.services.CatalogService;
import com.company.services.CatalogService;
import com.company.services.SellService;

import java.util.Scanner;

public class Main {
    static SellService sellService = new SellService();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        User user = new User(in.nextLine());

        if (!AuthService.getInstance().auth(user, in.nextLine())){
            System.out.println("Invalid password or username");
            return;
        }

        while (true){
            CatalogService.getInstance();
            CatalogService.catalog.forEach(product -> System.out.println(product));

            Product product = new Product(in.nextLine());
            if (!sellService.productInfo(product)){
                return;
            }
//            if (!sellService.sell(product)){
//                System.err.println("No product found");
//                return;
//            }
        }
    }
}
