package com.shopwise.service.module3;

import com.shopwise.model.Product;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Advanced analytics: group products by category and find most expensive per category.
 */
public class AdvancedAnalyticsService {

    public Map<String, Optional<Product>> mostExpensiveByCategory(List<Product> products) {
        // TODO: Group by category and find max price per group using collectingAndThen
        throw new UnsupportedOperationException("Not implemented yet");
    }
}

