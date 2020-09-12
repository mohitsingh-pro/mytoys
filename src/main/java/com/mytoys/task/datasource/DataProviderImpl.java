package com.mytoys.task.datasource;

import com.mytoys.task.domain.Products;
import org.springframework.stereotype.Component;

import static com.mytoys.task.datasource.CsvDataLoader.loadData;

@Component
public class DataProviderImpl implements DataProvider {

    @Override
    public Products get() {
        return loadData();
    }
}
