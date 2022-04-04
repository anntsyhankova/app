package com.company.services;

import com.company.entity.Product;
import com.company.entity.User;

public class SellService {
    private StorageService storageService = new StorageService();
    private PriceListService priceListService = new PriceListService();

    private boolean isAvailable(Product product){
        return storageService.getStorageContent().containsKey(product);
    }

    public boolean sell(User user, Product product){
        if (!isAvailable(product)) {
            return false;
        }

        int currentProduct = storageService.getStorageContent().get(product);
        if (currentProduct > 0){
            int price = priceListService.getPriceList().get(product);
            if (user.getWallet() >= price){
                System.out.println("Your money is " + user.getWallet());
                System.out.println("Number of current product is " + currentProduct);
                storageService.getStorageContent().put(product, --currentProduct);
                user.setWallet(user.getWallet() - price);
                System.out.println("Price of the " + product + " is " + price);
                System.out.println("Your money is " + user.getWallet());
                System.out.println("Number of current product is " + storageService.getStorageContent().get(product));
                return true;
            }
            else {
                System.err.println("You don't have enough money");
                return false;
            }
        }
        else {
            System.err.println(currentProduct + " is out");
            return false;
        }
    }

    public boolean productInfo(Product productName){
        if (isAvailable(productName)){
            System.out.println(productName + " quantity is " + storageService.getStorageContent().get(productName));
            return true;
        }
        else {
            System.out.println(productName + " is out");
            return false;
        }
    }

}
