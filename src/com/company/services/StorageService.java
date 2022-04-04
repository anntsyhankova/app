package com.company.services;


import com.company.entity.Product;
import com.company.entity.Storage;

import java.util.Map;

public class StorageService {

    private Storage storage = Storage.getInstance();

    public Map<Product, Integer> getStorageContent(){
        return this.storage.getStorageContent();
    }
}
