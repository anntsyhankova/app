package com.company.entity;

import java.util.Objects;

public class Product {
    private String name;

    public Product(String name){
        this.name = name;
    }

    public String getName(){
       return this.name;
    }

    @Override
    public String toString(){
        return this.name;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || this.getClass()!=obj.getClass()) return false;
        Product product = (Product) obj;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name);
    }
}
