package com.company.services;

import com.company.entity.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class CatalogService {
    public static List<Product> catalog = new ArrayList<Product>();
    private static CatalogService instance;

    static {
        catalog.add(new Product("laptop"));
        catalog.add(new Product("computer"));
        catalog.add(new Product("tablet"));
        catalog.add(new Product("mouse"));
        catalog.add(new Product("keyboard"));
    }

    private CatalogService(){};

    public static CatalogService getInstance(){
        if (instance == null){
            instance = new CatalogService();
        }
        return instance;
    }

//    public void setNewProduct(String product_name){
//        catalog.add(new Product(product_name));
//    }

//    public void printCatalog(){
//        System.out.println();
//    }
}
