package com.shopwise.service.module2;

import com.shopwise.model.Product;

import java.util.Comparator;
import java.util.List;

/**
 * Sorting products and simple pagination using skip/limit.
 */
public class ProductCatalogService {

    public List<Product> sortByPrice(List<Product> products, boolean ascending) {
        // TODO: Sort by price ascending/descending using streams and comparator
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public List<Product> paginate(List<Product> products, int page, int pageSize) {
        // TODO: Use skip and limit to return requested page
        throw new UnsupportedOperationException("Not implemented yet");
    }
}

