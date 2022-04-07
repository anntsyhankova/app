package com.company.services;

import com.company.command.Command;
import com.company.command.CommandDispatcher;
import com.company.command.CommandType;
import com.company.entity.Product;

public class SellService {
    private StorageService storageService = new StorageService();
    private PriceListService priceListService = new PriceListService();
    private WalletService walletService = new WalletService();

    public boolean sell(Product product){

        int currentProduct = storageService.getStorageContent().get(product);

        int price = priceListService.getPriceList().get(product);
        if (walletService.getWallet() >= price){
            storageService.getStorageContent().put(product, --currentProduct);
            walletService.addToWallet(-price);
            System.out.println("You spent " + price + " on " + product.getName());
            return true;
        }
        return false;
    }
}
