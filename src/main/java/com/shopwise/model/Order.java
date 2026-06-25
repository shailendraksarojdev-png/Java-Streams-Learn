package com.shopwise.model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    public enum Status {PENDING, SHIPPED, DELIVERED, CANCELLED}

    private String id;
    private String userId;
    private List<OrderItem> items;
    private LocalDateTime orderDate;
    private Status status;
    private double totalAmount;

    public Order() {
    }

    // Explicit all-args constructor
    public Order(String id, String userId, List<OrderItem> items, LocalDateTime orderDate, Status status, double totalAmount) {
        this.id = id;
        this.userId = userId;
        this.items = items;
        this.orderDate = orderDate;
        this.status = status;
        this.totalAmount = totalAmount;
    }

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public List<OrderItem> getItems() { return items; }
    public void setItems(List<OrderItem> items) { this.items = items; }

    public LocalDateTime getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDateTime orderDate) { this.orderDate = orderDate; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
}
