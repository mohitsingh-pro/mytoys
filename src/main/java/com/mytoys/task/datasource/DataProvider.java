package com.mytoys.task.datasource;

import com.mytoys.task.domain.Products;

import java.util.function.Supplier;

interface DataProvider extends Supplier<Products> {
}
