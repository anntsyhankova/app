package com.company.command;

import com.company.entity.Product;
import com.company.services.CatalogService;
import com.company.services.SellService;
import com.company.services.StorageService;

import java.util.Scanner;

public class BuyCommand implements CommandProcessor {

    private CatalogService catalogService = new CatalogService();
    private SellService sellService = new SellService();
    private StorageService storageService = new StorageService();

    private boolean checkProduct(String productName) {

        Product product = new Product(productName);

        if (catalogService.getCatalog().getCatalogContent().contains(product)) {
            if (storageService.getStorageContent().get(product) == 0) {
                System.err.println(product.getName() + " is out. Use command INFO to check product availability:");
                CommandDispatcher.processorMap.get(CommandType.INFO).printSynopsis(new Command("info"));
                return false;
            }
            if (!sellService.sell(product)) {
                System.err.println("You don't have enough money. Check your balance with a command BALANCE:");
                CommandDispatcher.processorMap.get(CommandType.BALANCE).printSynopsis(new Command("balance"));
                return false;
            }
        } else {
            System.err.println("Product " + product.getName() + " doesn't exist in storage. Use command INFO to check product availability:");
            CommandDispatcher.processorMap.get(CommandType.INFO).printSynopsis(new Command("info"));
        }
        return false;
    }

    @Override
    public boolean execute(Command command) {

        if (command.args().size() == 0 ){
            System.out.println("Select product to buy: " + catalogService.getCatalog().getCatalogContent());
            Scanner in = new Scanner(System.in);
            checkProduct(in.nextLine());
        }

        for (int i = 0; i < command.args().size(); i++) {
            checkProduct(command.args().get(i));
        }
        return true;
    }
}
