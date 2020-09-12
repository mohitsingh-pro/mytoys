package com.mytoys.task.service;

import com.mytoys.task.domain.Products;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
public class ProductServiceImpl implements ProductService {

    private final Supplier<Products> productsSupplier;

    public ProductServiceImpl(final Supplier<Products> productsSupplier) {
        this.productsSupplier = productsSupplier;
    }

    @Override
    public Products getProducts() {
        return productsSupplier.get();
    }
}
