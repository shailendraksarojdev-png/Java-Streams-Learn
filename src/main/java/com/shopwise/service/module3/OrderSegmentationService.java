package com.shopwise.service.module3;

import com.shopwise.model.Order;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Group orders by their status (PENDING, SHIPPED, DELIVERED, CANCELLED).
 */
public class OrderSegmentationService {

    public Map<Order.Status, List<Order>> groupByStatus(List<Order> orders) {
        // TODO: Implement using Collectors.groupingBy
        throw new UnsupportedOperationException("Not implemented yet");
    }
}

