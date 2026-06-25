package com.shopwise.service.module1;

import com.shopwise.model.Product;
import com.shopwise.model.Order;

import java.util.List;
import java.util.Optional;

/**
 * Demonstrate findFirst/findAny with Optionals to find products or orders.
 */
public class BasicSearchService {

    public Optional<Product> findProductByName(List<Product> products, String name) {
        // TODO: Use streams and findFirst to locate product by exact name
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public Optional<Order> findAnyOrderForUser(List<Order> orders, String userId) {
        // TODO: Use streams and findAny to find any order for the given userId
        throw new UnsupportedOperationException("Not implemented yet");
    }
}

