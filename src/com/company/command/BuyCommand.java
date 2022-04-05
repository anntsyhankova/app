package com.company.command;

import com.company.entity.Product;
import com.company.entity.User;
import com.company.services.CatalogService;
import com.company.services.SellService;
import com.company.services.UserHandler;

import java.util.Scanner;

public class BuyCommand extends Command{

    private CatalogService catalogService = new CatalogService();
    private SellService sellService = new SellService();

    @Override
    public boolean execute() {

        System.out.println("Select product to buy: " + catalogService.getCatalog().getCatalogContent());
        Scanner in = new Scanner(System.in);
        Product productName = new Product(in.nextLine());
        sellService.sell(productName);
        return true;
    }
}
