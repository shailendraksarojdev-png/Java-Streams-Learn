package com.shopwise.service.module2;

import com.shopwise.model.Order;

import java.util.DoubleSummaryStatistics;
import java.util.List;

/**
 * Compute revenue, averages, and min/max order totals.
 */
public class SalesAnalyticsService {

    public double totalRevenue(List<Order> orders) {
        // TODO: Use mapToDouble and sum to compute total revenue
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public double averageOrderValue(List<Order> orders) {
        // TODO: Use mapToDouble and summaryStatistics to compute average
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public DoubleSummaryStatistics orderValueStats(List<Order> orders) {
        // TODO: Return DoubleSummaryStatistics over order totals
        throw new UnsupportedOperationException("Not implemented yet");
    }
}

