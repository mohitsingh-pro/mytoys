package com.mytoys.task.web;

import com.mytoys.task.domain.Products;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.function.Function;

public class ResourceConverter implements Converter<Products, ProductResources> {

    @Override
    public ProductResources convert(final Products source) {
        final ProductResources target = new ProductResources(new ArrayList<>());
        if (source == null) {
            return new ProductResources(new ArrayList<>());
        }
        source.getProducts().stream()
                .map(resourceFunction)
                .forEach(target.getProducts()::add);
        return target;
    }

    private static final Function<Products.Product, ProductResource> resourceFunction = (final Products.Product product) -> {
        final ProductResource resource = new ProductResource();
        resource.setId(product.getId());
        resource.setName(product.getName());
        resource.setPrice(product.getPrice());
        resource.setOldPrice(product.getOldPrice());
        resource.setStock(product.getStock());
        resource.setBrand(product.getBrand());
        return resource;
    };

}
