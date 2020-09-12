package com.mytoys.task.web;

import java.util.List;

public class ProductResources {
    private List<ProductResource> products;

    public ProductResources(List<ProductResource> products) {
        this.products = products;
    }

    public List<ProductResource> getProducts() {
        return products;
    }
}