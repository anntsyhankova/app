package com.company.entity;

import com.company.services.CatalogService;
import com.company.services.StorageService;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Storage {

    private Map<Product, Integer> content = new HashMap<>();
    private static Storage instance;
    private CatalogService catalogService = new CatalogService();

    private Storage(){
        Catalog catalog = catalogService.getCatalog();
        catalog.getCatalogContent().forEach(product ->
                content.put(product, new Random().nextInt(10)));
    }

    public static Storage getInstance(){
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    public Map<Product, Integer> getStorageContent(){
        return this.content;
    }
}
