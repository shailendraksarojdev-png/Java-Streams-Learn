package com.shopwise.util;

import com.shopwise.model.Order;
import com.shopwise.model.OrderItem;
import com.shopwise.model.Product;
import com.shopwise.model.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class DataGenerator {

    public List<Product> generateProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(UUID.randomUUID().toString(), "Wireless Mouse", "Electronics", 25.99, 150, 4.3, Arrays.asList("accessory", "wireless", "computer")));
        products.add(new Product(UUID.randomUUID().toString(), "Gaming Keyboard", "Electronics", 79.49, 80, 4.7, Arrays.asList("gaming", "keyboard", "rgb")));
        products.add(new Product(UUID.randomUUID().toString(), "Coffee Mug", "Home", 12.0, 200, 4.1, Arrays.asList("kitchen", "mug")));
        products.add(new Product(UUID.randomUUID().toString(), "Leather Wallet", "Fashion", 45.0, 60, 4.5, Arrays.asList("wallet", "leather")));
        products.add(new Product(UUID.randomUUID().toString(), "Running Shoes", "Fashion", 120.0, 40, 4.6, Arrays.asList("shoes", "sport")));
        products.add(new Product(UUID.randomUUID().toString(), "Bluetooth Headphones", "Electronics", 99.99, 95, 4.4, Arrays.asList("audio", "wireless", "music")));
        products.add(new Product(UUID.randomUUID().toString(), "Espresso Machine", "Home", 249.99, 25, 4.8, Arrays.asList("kitchen", "coffee", "appliance")));
        products.add(new Product(UUID.randomUUID().toString(), "Yoga Mat", "Sports", 29.99, 120, 4.2, Arrays.asList("fitness", "exercise", "mat")));
        products.add(new Product(UUID.randomUUID().toString(), "LED Monitor 24\"", "Electronics", 159.99, 45, 4.5, Arrays.asList("display", "computer", "monitor")));
        products.add(new Product(UUID.randomUUID().toString(), "Stainless Steel Water Bottle", "Home", 19.5, 300, 4.6, Arrays.asList("kitchen", "bottle", "travel")));
        products.add(new Product(UUID.randomUUID().toString(), "Desk Lamp", "Home", 34.99, 85, 4.3, Arrays.asList("lighting", "office")));
        products.add(new Product(UUID.randomUUID().toString(), "Trail Running Socks", "Fashion", 14.99, 220, 4.1, Arrays.asList("clothing", "socks", "sport")));

        return products;
    }

    public List<User> generateUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User(UUID.randomUUID().toString(), "alice", "alice@example.com", User.Tier.GOLD, true));
        users.add(new User(UUID.randomUUID().toString(), "bob", "bob@example.com", User.Tier.SILVER, true));
        users.add(new User(UUID.randomUUID().toString(), "carol", "carol@example.com", User.Tier.PLATINUM, false));
        users.add(new User(UUID.randomUUID().toString(), "dave", "dave@example.com", User.Tier.SILVER, true));
        users.add(new User(UUID.randomUUID().toString(), "eve", "eve@example.com", User.Tier.GOLD, true));
        users.add(new User(UUID.randomUUID().toString(), "frank", "frank@example.com", User.Tier.SILVER, false));
        users.add(new User(UUID.randomUUID().toString(), "grace", "grace@example.com", User.Tier.PLATINUM, true));
        users.add(new User(UUID.randomUUID().toString(), "heidi", "heidi@example.com", User.Tier.GOLD, true));
        users.add(new User(UUID.randomUUID().toString(), "ivan", "ivan@example.com", User.Tier.SILVER, true));
        users.add(new User(UUID.randomUUID().toString(), "judy", "judy@example.com", User.Tier.GOLD, false));
        return users;
    }

    public List<Order> generateOrders(List<Product> products, List<User> users) {
        List<Order> orders = new ArrayList<>();

        // Build some order items combinations across multiple products
        OrderItem o1 = new OrderItem(products.get(0).getId(), 2, products.get(0).getPrice()); // Wireless Mouse
        OrderItem o2 = new OrderItem(products.get(1).getId(), 1, products.get(1).getPrice()); // Gaming Keyboard
        OrderItem o3 = new OrderItem(products.get(2).getId(), 4, products.get(2).getPrice()); // Coffee Mug
        OrderItem o4 = new OrderItem(products.get(5).getId(), 1, products.get(5).getPrice()); // Bluetooth Headphones
        OrderItem o5 = new OrderItem(products.get(6).getId(), 1, products.get(6).getPrice()); // Espresso Machine
        OrderItem o6 = new OrderItem(products.get(8).getId(), 2, products.get(8).getPrice()); // LED Monitor
        OrderItem o7 = new OrderItem(products.get(9).getId(), 3, products.get(9).getPrice()); // Water Bottle
        OrderItem o8 = new OrderItem(products.get(4).getId(), 1, products.get(4).getPrice()); // Running Shoes
        OrderItem o9 = new OrderItem(products.get(10).getId(), 1, products.get(10).getPrice()); // Desk Lamp
        OrderItem o10 = new OrderItem(products.get(11).getId(), 5, products.get(11).getPrice()); // Socks

        // Create multiple orders across users and dates
        orders.add(new Order(UUID.randomUUID().toString(), users.get(0).getId(), Arrays.asList(o1, o2), LocalDateTime.now().minusDays(2), Order.Status.SHIPPED, o1.getQuantity()*o1.getUnitPrice() + o2.getQuantity()*o2.getUnitPrice()));
        orders.add(new Order(UUID.randomUUID().toString(), users.get(1).getId(), Arrays.asList(o3), LocalDateTime.now().minusDays(10), Order.Status.DELIVERED, o3.getQuantity()*o3.getUnitPrice()));
        orders.add(new Order(UUID.randomUUID().toString(), users.get(2).getId(), Arrays.asList(o4, o7), LocalDateTime.now().minusHours(5), Order.Status.PENDING, o4.getQuantity()*o4.getUnitPrice() + o7.getQuantity()*o7.getUnitPrice()));
        orders.add(new Order(UUID.randomUUID().toString(), users.get(3).getId(), Arrays.asList(o5), LocalDateTime.now().minusDays(30), Order.Status.DELIVERED, o5.getQuantity()*o5.getUnitPrice()));
        orders.add(new Order(UUID.randomUUID().toString(), users.get(4).getId(), Arrays.asList(o6), LocalDateTime.now().minusDays(1), Order.Status.SHIPPED, o6.getQuantity()*o6.getUnitPrice()));
        orders.add(new Order(UUID.randomUUID().toString(), users.get(5).getId(), Arrays.asList(o7, o10), LocalDateTime.now().minusDays(3), Order.Status.CANCELLED, o7.getQuantity()*o7.getUnitPrice() + o10.getQuantity()*o10.getUnitPrice()));
        orders.add(new Order(UUID.randomUUID().toString(), users.get(6).getId(), Arrays.asList(o8), LocalDateTime.now().minusHours(20), Order.Status.PENDING, o8.getQuantity()*o8.getUnitPrice()));
        orders.add(new Order(UUID.randomUUID().toString(), users.get(7).getId(), Arrays.asList(o9, o3), LocalDateTime.now().minusDays(7), Order.Status.DELIVERED, o9.getQuantity()*o9.getUnitPrice() + o3.getQuantity()*o3.getUnitPrice()));
        orders.add(new Order(UUID.randomUUID().toString(), users.get(8).getId(), Arrays.asList(o2, o4), LocalDateTime.now().minusDays(15), Order.Status.DELIVERED, o2.getQuantity()*o2.getUnitPrice() + o4.getQuantity()*o4.getUnitPrice()));
        orders.add(new Order(UUID.randomUUID().toString(), users.get(9).getId(), Arrays.asList(o1, o10), LocalDateTime.now().minusHours(8), Order.Status.PENDING, o1.getQuantity()*o1.getUnitPrice() + o10.getQuantity()*o10.getUnitPrice()));
        orders.add(new Order(UUID.randomUUID().toString(), users.get(0).getId(), Arrays.asList(o6, o9), LocalDateTime.now().minusDays(4), Order.Status.SHIPPED, o6.getQuantity()*o6.getUnitPrice() + o9.getQuantity()*o9.getUnitPrice()));
        orders.add(new Order(UUID.randomUUID().toString(), users.get(2).getId(), Arrays.asList(o5, o8), LocalDateTime.now().minusDays(20), Order.Status.DELIVERED, o5.getQuantity()*o5.getUnitPrice() + o8.getQuantity()*o8.getUnitPrice()));

        return orders;
    }
}

