package com.shopwise.service.module3;

import com.shopwise.model.Order;
import com.shopwise.model.OrderItem;
import com.shopwise.model.Product;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Compute total revenue per product category using downstream collectors.
 */
public class FinancialReportService {

    public Map<String, Double> revenueByCategory(List<Order> orders, List<Product> products) {
        // TODO: Implement groupingBy category and summingDouble over order items prices*quantities
        throw new UnsupportedOperationException("Not implemented yet");
    }
}

