package com.company.services;

import com.company.entity.Product;

public class SellService {
    private StorageService storageService = new StorageService();
    private PriceListService priceListService = new PriceListService();
    private WalletService walletService = new WalletService();

    public boolean sell(Product product){

        if (!storageService.getStorageContent().containsKey(product)) {
            System.err.println("We don't have this product");
            return false;
        }

        int currentProduct = storageService.getStorageContent().get(product);

        if (currentProduct > 0){
            int price = priceListService.getPriceList().get(product);
            if (walletService.getWallet() >= price){
                storageService.getStorageContent().put(product, --currentProduct);
                walletService.addToWallet(-price);
                System.out.println("You spent " + price + " on " + product.getName());
                return true;
            }
            else {
                System.err.println("You don't have enough money");
                return false;
            }
        }
        else {
            System.err.println(product.getName() + " is out");
            return false;
        }
    }
}
