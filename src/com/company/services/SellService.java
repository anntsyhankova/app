package com.company.services;

import com.company.entity.Product;
import com.company.entity.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SellService {
    private Map<Product, Integer> store = new HashMap<>();

    {
        CatalogService.catalog.forEach(product ->
                store.put(product, new Random().nextInt(10)));
    }

    private boolean isAvailable(Product product){
        return store.containsKey(product);
    }

    public boolean sell(Product product){
        if (!isAvailable(product)) {
            return false;
        }

        int current = store.get(product);
        if (current > 0){
            store.put(product, --current);
            System.out.println(product + " sold");
            return true;
        }

        return false;
    }

    public boolean productInfo(Product product){
        if (isAvailable(product)){
            System.out.println(product + " quantity is " + store.get(product));
            return true;
        }
        else {
            System.out.println(product + " is out");
            return false;
        }
    }

}
