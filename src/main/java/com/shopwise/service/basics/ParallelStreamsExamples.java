package com.shopwise.service.basics;

import com.shopwise.model.Order;

import java.util.List;

/**
 * Demonstrate safe usage of parallel streams for CPU-bound operations and reductions.
 */
public class ParallelStreamsExamples {

    public double sumOrdersParallel(List<Order> orders) {
        if (orders == null) return 0.0;
        return orders.parallelStream().mapToDouble(Order::getTotalAmount).sum();
    }

    // Caution: avoid using mutable shared state with forEach on parallelStream
}

