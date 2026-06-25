package com.shopwise.model;

public class DashboardMetrics {
    private long totalOrders;
    private double totalRevenue;
    private double averageOrderValue;

    public DashboardMetrics() {}

    public DashboardMetrics(long totalOrders, double totalRevenue, double averageOrderValue) {
        this.totalOrders = totalOrders;
        this.totalRevenue = totalRevenue;
        this.averageOrderValue = averageOrderValue;
    }

    public long getTotalOrders() { return totalOrders; }
    public void setTotalOrders(long totalOrders) { this.totalOrders = totalOrders; }

    public double getTotalRevenue() { return totalRevenue; }
    public void setTotalRevenue(double totalRevenue) { this.totalRevenue = totalRevenue; }

    public double getAverageOrderValue() { return averageOrderValue; }
    public void setAverageOrderValue(double averageOrderValue) { this.averageOrderValue = averageOrderValue; }
}
