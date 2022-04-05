package com.company.command;

import com.company.entity.Product;
import com.company.services.CatalogService;
import com.company.services.PriceListService;
import com.company.services.StorageService;

import java.util.List;
import java.util.Scanner;

public class InfoCommand extends Command{

    private CatalogService catalogService = new CatalogService();
    private PriceListService priceListService = new PriceListService();
    private StorageService storageService = new StorageService();

    @Override
    public boolean execute() {
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
            System.out.println("Price of the " + productName + " is "
                    + priceListService.getPriceList().get(productName));
            System.out.println("The number of " + productName + " in storage is "
                    + storageService.getStorageContent().get(productName));
            return true;
        }
    }
}
