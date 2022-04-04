package com.company.services;

import com.company.entity.PriceList;
import com.company.entity.Product;

import java.util.Map;

public class PriceListService {

    private PriceList priceList = PriceList.getInstance();

    public Map<Product, Integer> getPriceList(){
        return this.priceList.getPriceList();
    }
}
