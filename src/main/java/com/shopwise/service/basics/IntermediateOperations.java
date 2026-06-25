package com.shopwise.service.basics;

import com.shopwise.model.Product;

import java.util.Comparator;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Examples of intermediate Stream operations: map, filter, flatMap, distinct, sorted, peek, limit, skip
 */
public class IntermediateOperations {

    public List<String> mapProductNames(List<Product> products) {
        if (products == null) return Collections.emptyList();
        return products.stream()
                .filter(Objects::nonNull)
                .map(Product::getName)
                .collect(Collectors.toList());
    }

    public List<Product> filterByCategory(List<Product> products, String category) {
        if (products == null) return Collections.emptyList();
        return products.stream()
                .filter(Objects::nonNull)
                .filter(p -> category == null || category.equals(p.getCategory()))
                .collect(Collectors.toList());
    }

    public List<String> flatMapProductTags(List<Product> products) {
        if (products == null) return Collections.emptyList();
        return products.stream()
                .filter(Objects::nonNull)
                .flatMap(p -> p.getTags() == null ? java.util.stream.Stream.empty() : p.getTags().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Product> sortedByPrice(List<Product> products, boolean ascending) {
        if (products == null) return Collections.emptyList();
        Comparator<Product> cmp = Comparator.comparingDouble(Product::getPrice);
        if (!ascending) cmp = cmp.reversed();
        return products.stream()
                .filter(Objects::nonNull)
                .sorted(cmp)
                .collect(Collectors.toList());
    }

    public List<Product> limitProducts(List<Product> products, int n) {
        if (products == null || n <= 0) return Collections.emptyList();
        return products.stream()
                .limit(n)
                .collect(Collectors.toList());
    }

    public List<Product> skipProducts(List<Product> products, int n) {
        if (products == null) return Collections.emptyList();
        if (n <= 0) return products;
        return products.stream()
                .skip(n)
                .collect(Collectors.toList());
    }

    public List<Product> peekExample(List<Product> products, Consumer<Product> action) {
        if (products == null) return Collections.emptyList();
        return products.stream()
                .peek(action)
                .collect(Collectors.toList());
    }
}

