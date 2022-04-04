package com.company.entity;

import com.company.services.CatalogService;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PriceList {

    private Map<Product, Integer> priceList = new HashMap<>();
    private static PriceList instance;
    private CatalogService catalogService = new CatalogService();

    private PriceList(){
        Catalog catalog = catalogService.getCatalog();
        catalog.getCatalogContent().forEach(product -> priceList.put(product, new Random().nextInt(1000)));
    }

    public static PriceList getInstance(){
        if (instance == null){
            instance = new PriceList();
        }
        return instance;
    }

    public Map<Product, Integer> getPriceList(){
        return priceList;
    }
}
