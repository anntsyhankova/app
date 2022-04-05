package com.company.entity;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Catalog {

    private static Catalog instance;
    private List<Product> catalogContent = new ArrayList<>();
    private Long creationTime;

    private Catalog(){
        this.catalogContent.add(new Product("laptop"));
        this.catalogContent.add(new Product("computer"));
        this.catalogContent.add(new Product("tablet"));
        this.catalogContent.add(new Product("mouse"));
        this.catalogContent.add(new Product("keyboard"));
    }

    public static Catalog getInstance(){
        if (instance == null) {
            instance = new Catalog();
        }
        return instance;
    }

    public List<Product> getCatalogContent(){
        return this.catalogContent;
    }
}
