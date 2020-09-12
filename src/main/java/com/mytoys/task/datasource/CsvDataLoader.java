package com.mytoys.task.datasource;


import com.mytoys.task.domain.Products;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CsvDataLoader {
    private static final String FILE_PATH = "product_data.csv";
    private static final char SEPARATOR = ',';
    private static final String[] HEADERS = new String[]{"ID", "NAME", "PRICE", "OLD_PRICE", "STOCK", "BRAND"};

    public static Products loadData() {
        final ClassPathResource resource = new ClassPathResource(FILE_PATH);
        CSVParser csvFileParser = null;
        try (InputStreamReader reader = new InputStreamReader(resource.getInputStream())) {
            csvFileParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader(HEADERS)
                    .withDelimiter(SEPARATOR));
            final List<CSVRecord> csvRecords = csvFileParser.getRecords();
            final List<Products.Product> productList = csvRecords.stream()
                    .skip(1) //skip header row
                    .map(productFunction)
                    .collect(Collectors.toList());

            return new Products(productList);
        } catch (final IOException exception) {
            throw new IllegalStateException("error in parsing the CSV ", exception);
        } catch (final Exception exception) {
            throw new IllegalStateException("error loading data from  CSV ", exception);
        } finally {
            if (csvFileParser != null) {
                try {
                    csvFileParser.close();
                } catch (final IOException ignore) {
                }
            }
        }
    }

    private static final Function<CSVRecord, Products.Product> productFunction = (final CSVRecord record) -> {
        final Products.Product product = new Products.Product();
        product.setId(Long.parseLong(getCellValue(record, 0)));
        product.setName(getCellValue(record, 1));
        product.setPrice(Double.parseDouble(getCellValue(record, 2)));
        product.setOldPrice(Double.parseDouble(getCellValue(record, 3)));
        product.setStock(Integer.parseInt(getCellValue(record, 4)));
        product.setBrand(getCellValue(record, 5));
        return product;
    };

    private static String getCellValue(final CSVRecord record, final int index) {
        return record.get(HEADERS[index]);
    }
}
