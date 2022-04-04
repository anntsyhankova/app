package com.company.services;

import com.company.entity.Catalog;

public final class CatalogService {

    private Catalog catalog = Catalog.getInstance();

    public Catalog getCatalog() {
        return this.catalog;
    }
}
