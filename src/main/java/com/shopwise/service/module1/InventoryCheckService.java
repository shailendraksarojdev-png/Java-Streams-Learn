package com.shopwise.service.module1;

import com.shopwise.model.Product;
import com.shopwise.model.User;

import java.util.List;

/**
 * Business scenarios using anyMatch/allMatch/noneMatch for inventory and user checks.
 */
public class InventoryCheckService {

    /**
     * Return true if any product is out of stock.
     */
    public boolean anyOutOfStock(List<Product> products) {
        // TODO: Implement using anyMatch
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Return true if all users are active.
     */
    public boolean allUsersActive(List<User> users) {
        // TODO: Implement using allMatch
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Return true if no product has negative stock.
     */
    public boolean noneNegativeStock(List<Product> products) {
        // TODO: Implement using noneMatch
        throw new UnsupportedOperationException("Not implemented yet");
    }
}

