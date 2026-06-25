package com.shopwise.model;

import java.util.List;

public class Product {
    private String id;
    private String name;
    private String category;
    private double price;
    private int stock;
    private double rating;
    private List<String> tags;

    public Product() {}

    public Product(String id, String name, String category, double price, int stock, double rating, List<String> tags) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
        this.rating = rating;
        this.tags = tags;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

    public List<String> getTags() { return tags; }
    public void setTags(List<String> tags) { this.tags = tags; }
}
