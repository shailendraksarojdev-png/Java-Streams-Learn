package com.shopwise.service.basics;

import com.shopwise.model.Order;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

/**
 * Examples of primitive streams (IntStream/DoubleStream/LongStream) and collectors for primitives
 */
public class PrimitiveStreamsAndCollectors {

    public IntSummaryStatistics quantityStats(List<Order> orders) {
        if (orders == null) return new IntSummaryStatistics();
        return orders.stream()
                .flatMap(o -> o.getItems().stream())
                .collect(Collectors.summarizingInt(item -> item.getQuantity()));
    }

    public OptionalDouble averageOrderValue(List<Order> orders) {
        if (orders == null) return OptionalDouble.empty();
        return orders.stream().mapToDouble(Order::getTotalAmount).average();
    }

    public double maxOrderValue(List<Order> orders) {
        if (orders == null) return 0.0;
        return orders.stream().mapToDouble(Order::getTotalAmount).max().orElse(0.0);
    }
}

