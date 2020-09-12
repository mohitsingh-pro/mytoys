package com.mytoys.task.web;

import com.mytoys.task.service.ProductService;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    private final ProductService productService;
    private final ResourceConverter resourceConverter;

    public ProductController(ProductService productService) {
        this.productService = productService;
        this.resourceConverter = new ResourceConverter();
    }

    @GetMapping(value = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<ProductResources> get() {
        final ProductResources products = resourceConverter.convert(productService.getProducts());
        return ResponseEntity.ok().body(products);
    }
}
