package com.shopwise.service.module2;

import com.shopwise.model.Order;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Reduce order information into CSV or readable strings using joining.
 */
public class OrderStringService {

    public String ordersToCsv(List<Order> orders) {
        // TODO: Use streams and Collectors.joining to produce CSV string of orders
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public String ordersSummary(List<Order> orders) {
        // TODO: Use streams to produce a compact summary string
        throw new UnsupportedOperationException("Not implemented yet");
    }
}

