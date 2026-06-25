package com.shopwise.service.module4;

import com.shopwise.model.DashboardMetrics;
import com.shopwise.model.Order;

import java.util.List;

/**
 * Provide a custom collector or mutable reduction to aggregate orders into DashboardMetrics.
 */
public class CustomOrderCollector {

    public DashboardMetrics collectMetrics(List<Order> orders) {
        // TODO: Implement custom mutable reduction or collector to compute totalOrders, totalRevenue, average
        throw new UnsupportedOperationException("Not implemented yet");
    }
}

