package com.company.command;

import com.company.entity.Product;
import com.company.services.CatalogService;
import com.company.services.PriceListService;
import com.company.services.StorageService;

import java.util.List;
import java.util.Scanner;

public class InfoCommand implements CommandProcessor {

    private CatalogService catalogService = new CatalogService();
    private PriceListService priceListService = new PriceListService();
    private StorageService storageService = new StorageService();

    private void printInfo(Product product){
        System.out.println("_____________");
        System.out.println("Price of the " + product.getName() + " is "
                + priceListService.getPriceList().get(product));
        System.out.println("The number of " + product.getName() + " in storage is "
                + storageService.getStorageContent().get(product));
    }

    private boolean executeWithArgs(Command command) {

        for (int i = 0; i < command.args().size(); i++) {
            Product product = new Product(command.args().get(i));
            if (catalogService.getCatalog().getCatalogContent().contains(product)) {
                printInfo(product);
            } else {
                System.err.println("Product " + product.getName() + " doesn't exist in storage");
            }
        }
        return true;
    }

    @Override
    public boolean execute(Command command) {
        if (command.args().size() != 0){
            executeWithArgs(command);
            return true;
        }

        System.out.println("Select product: " + catalogService.getCatalog().getCatalogContent());
        Scanner in = new Scanner(System.in);
        Product productName = new Product(in.nextLine());

        List<Product> filteredProductList = catalogService.getCatalog().getCatalogContent()
                .stream()
                .filter(product -> product.getName().equals(productName.getName())).toList();

        if (!filteredProductList.iterator().hasNext()){
            System.err.println("We don't have this product");
            return false;
        }
        else {
            printInfo(productName);
            return true;
        }
    }
}
