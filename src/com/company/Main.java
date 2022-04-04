package com.company;

import com.company.entity.PriceList;
import com.company.entity.Product;
import com.company.entity.User;
import com.company.services.AuthService;
import com.company.services.CatalogService;
import com.company.services.SellService;

import java.util.Scanner;

public class Main {

    static SellService sellService = new SellService();
    static CatalogService catalogService = new CatalogService();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        User user = new User(in.nextLine());

        if (!AuthService.getInstance().auth(user, in.nextLine())){
            System.out.println("Invalid password or username");
            return;
        }

        while (true){
            catalogService.getCatalog().catalogContent.forEach(product -> System.out.println(product));

            Product productName = new Product(in.nextLine());
            if (!sellService.sell(user, productName)){
                return;
           }
//            if (!sellService.sell(product)){
//                System.err.println("No product found");
//                return;
            }
    }
}
