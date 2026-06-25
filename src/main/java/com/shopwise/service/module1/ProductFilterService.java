package com.shopwise.service.module1;

import com.shopwise.model.Product;
import java.util.List;

/**
 * Filter products by category, minimum rating, and price range.
 */
public class ProductFilterService {

    /**
     * Return products that match the given optional filters. Any null filter means "no filter".
     */
    public List<Product> filterProducts(List<Product> products, String category, Double minRating, Double maxPrice) {
        // TODO: Implement using Java 8 Streams: filter by category, rating >= minRating, price <= maxPrice
        throw new UnsupportedOperationException("Not implemented yet");
    }
}

