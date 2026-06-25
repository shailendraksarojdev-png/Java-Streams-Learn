package com.shopwise.service.basics;

import com.shopwise.model.Order;
import com.shopwise.model.Product;

import java.util.Collections;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Examples of terminal Stream operations: collect, forEach, reduce, min/max, count, anyMatch/allMatch/noneMatch
 */
public class TerminalOperations {

    public long countProducts(List<Product> products) {
        if (products == null) return 0;
        return products.stream().count();
    }

    public Optional<Product> minPriceProduct(List<Product> products) {
        if (products == null) return Optional.empty();
        return products.stream().min((a,b) -> Double.compare(a.getPrice(), b.getPrice()));
    }

    public Optional<Product> maxPriceProduct(List<Product> products) {
        if (products == null) return Optional.empty();
        return products.stream().max((a,b) -> Double.compare(a.getPrice(), b.getPrice()));
    }

    public DoubleSummaryStatistics priceStatistics(List<Product> products) {
        if (products == null) return new DoubleSummaryStatistics();
        return products.stream().collect(Collectors.summarizingDouble(Product::getPrice));
    }

    public Map<String, Long> productCountByCategory(List<Product> products) {
        if (products == null) return Collections.emptyMap();
        return products.stream().collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));
    }

    public boolean anyOrderForUser(List<Order> orders, String userId) {
        if (orders == null || userId == null) return false;
        return orders.stream().anyMatch(o -> userId.equals(o.getUserId()));
    }

    public boolean allOrdersDelivered(List<Order> orders) {
        if (orders == null) return false;
        return orders.stream().allMatch(o -> o.getStatus() == Order.Status.DELIVERED);
    }

    public boolean noPendingOrders(List<Order> orders) {
        if (orders == null) return true;
        return orders.stream().noneMatch(o -> o.getStatus() == Order.Status.PENDING);
    }

    public double totalOrderRevenue(List<Order> orders) {
        if (orders == null) return 0.0;
        return orders.stream().mapToDouble(Order::getTotalAmount).sum();
    }

    public Optional<Double> reduceExample(List<Order> orders) {
        if (orders == null) return Optional.empty();
        return orders.stream().map(Order::getTotalAmount).reduce(Double::sum);
    }
}

