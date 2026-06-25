package com.shopwise.service.basics;

import com.shopwise.model.Order;
import com.shopwise.model.User;
import com.shopwise.model.OrderItem;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 20 exercises focusing on Orders and Users to practice stream queries (filter, grouping, aggregations)
 */
public class StreamBasicsExercises2 {

    // 1. Order ids list
    public static List<String> orderIds(List<Order> orders) {
        return orders == null ? List.of() : orders.stream().map(Order::getId).collect(Collectors.toList());
    }

    // 2. Orders by user id
    public static List<Order> ordersForUser(List<Order> orders, String userId) {
        return orders == null ? List.of() : orders.stream().filter(o -> userId.equals(o.getUserId())).collect(Collectors.toList());
    }

    // 3. Recent orders within days
    public static List<Order> recentOrders(List<Order> orders, int days) {
        if (orders == null) return List.of();
        LocalDateTime cutoff = LocalDateTime.now().minusDays(days);
        return orders.stream().filter(o -> o.getOrderDate().isAfter(cutoff)).collect(Collectors.toList());
    }

    // 4. Group orders by status
    public static Map<Order.Status, List<Order>> groupByStatus(List<Order> orders) {
        return orders == null ? Map.of() : orders.stream().collect(Collectors.groupingBy(Order::getStatus));
    }

    // 5. Total revenue per user
    public static Map<String, Double> revenuePerUser(List<Order> orders) {
        return orders == null ? Map.of() : orders.stream().collect(Collectors.groupingBy(Order::getUserId, Collectors.summingDouble(Order::getTotalAmount)));
    }

    // 6. Distinct user ids who ordered
    public static Set<String> distinctUserIds(List<Order> orders) {
        return orders == null ? Set.of() : orders.stream().map(Order::getUserId).collect(Collectors.toSet());
    }

    // 7. Count orders per user
    public static Map<String, Long> countOrdersPerUser(List<Order> orders) {
        return orders == null ? Map.of() : orders.stream().collect(Collectors.groupingBy(Order::getUserId, Collectors.counting()));
    }

    // 8. Max order per user
    public static Map<String, Optional<Order>> maxOrderPerUser(List<Order> orders) {
        return orders == null ? Map.of() : orders.stream().collect(Collectors.groupingBy(Order::getUserId, Collectors.maxBy((a,b) -> Double.compare(a.getTotalAmount(), b.getTotalAmount()))));
    }

    // 9. Users with no orders
    public static List<User> usersWithNoOrders(List<User> users, List<Order> orders) {
        if (users == null) return List.of();
        Set<String> orderedUserIds = orders == null ? Set.of() : orders.stream().map(Order::getUserId).collect(Collectors.toSet());
        return users.stream().filter(u -> !orderedUserIds.contains(u.getId())).collect(Collectors.toList());
    }

    // 10. Average order value per user
    public static Map<String, Double> averageOrderValuePerUser(List<Order> orders) {
        return orders == null ? Map.of() : orders.stream().collect(Collectors.groupingBy(Order::getUserId, Collectors.averagingDouble(Order::getTotalAmount)));
    }

    // 11. Any order cancelled
    public static boolean anyCancelled(List<Order> orders) {
        return orders != null && orders.stream().anyMatch(o -> o.getStatus() == Order.Status.CANCELLED);
    }

    // 12. All orders have positive total
    public static boolean allPositiveTotal(List<Order> orders) {
        return orders == null ? true : orders.stream().allMatch(o -> o.getTotalAmount() > 0);
    }

    // 13. Find first pending order
    public static Optional<Order> findFirstPending(List<Order> orders) {
        return orders == null ? Optional.empty() : orders.stream().filter(o -> o.getStatus() == Order.Status.PENDING).findFirst();
    }

    // 14. Flatten all order item productIds
    public static Set<String> allProductIdsInOrders(List<Order> orders) {
        return orders == null ? Set.of() : orders.stream().flatMap(o -> o.getItems().stream()).map(OrderItem::getProductId).collect(Collectors.toSet());
    }

    // 15. Partition orders into recent vs older than days
    public static Map<Boolean, List<Order>> partitionRecent(List<Order> orders, int days) {
        if (orders == null) return Map.of();
        LocalDateTime cutoff = LocalDateTime.now().minusDays(days);
        return orders.stream().collect(Collectors.partitioningBy(o -> o.getOrderDate().isAfter(cutoff)));
    }

    // 16. Top N orders by value
    public static List<Order> topNOrders(List<Order> orders, int n) {
        if (orders == null || n <= 0) return List.of();
        return orders.stream().sorted((a,b) -> Double.compare(b.getTotalAmount(), a.getTotalAmount())).limit(n).collect(Collectors.toList());
    }

    // 17. Sum of all order totals
    public static double totalRevenue(List<Order> orders) {
        return orders == null ? 0.0 : orders.stream().mapToDouble(Order::getTotalAmount).sum();
    }

    // 18. Orders grouped by day (simple: toString of date)
    public static Map<String, List<Order>> ordersByDay(List<Order> orders) {
        return orders == null ? Map.of() : orders.stream().collect(Collectors.groupingBy(o -> o.getOrderDate().toLocalDate().toString()));
    }

    // 19. Average items per order
    public static double averageItemsPerOrder(List<Order> orders) {
        if (orders == null || orders.isEmpty()) return 0.0;
        return orders.stream().mapToInt(o -> o.getItems().stream().mapToInt(i -> i.getQuantity()).sum()).average().orElse(0.0);
    }

    // 20. Orders for VIP users (GOLD or PLATINUM) — requires user map or provided predicate
    public static List<Order> ordersForVipUsers(List<Order> orders, Set<String> vipUserIds) {
        if (orders == null || vipUserIds == null) return List.of();
        return orders.stream().filter(o -> vipUserIds.contains(o.getUserId())).collect(Collectors.toList());
    }
}

