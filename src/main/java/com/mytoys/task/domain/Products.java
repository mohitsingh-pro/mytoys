package com.mytoys.task.domain;

import java.util.List;

public class Products {
    private List<Product> products;

    public Products(List<Product> products) {
        this.products = products;
    }

    public static class Product {
        private long id;
        private String name;
        private double price;
        private double oldPrice;
        private int stock;
        private String brand;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public double getOldPrice() {
            return oldPrice;
        }

        public void setOldPrice(double oldPrice) {
            this.oldPrice = oldPrice;
        }

        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }
    }

    public List<Product> getProducts() {
        return products;
    }
}