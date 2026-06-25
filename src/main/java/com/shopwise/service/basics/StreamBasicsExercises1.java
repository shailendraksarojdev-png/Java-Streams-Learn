package com.shopwise.service.basics;

import com.shopwise.model.Product;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.DoubleSummaryStatistics;
import java.util.stream.Collectors;

/**
 * 20 short stream exercises over Product lists to learn intermediate and terminal operations.
 * Each method is a small, self-contained example with a clear purpose.
 */
public class StreamBasicsExercises1 {

    // 1. Map product list to product names
    public static List<String> productNames(List<Product> products) {
        return products == null ? List.of() : products.stream().map(Product::getName).collect(Collectors.toList());
    }

    // 2. Filter products by category
    public static List<Product> productsInCategory(List<Product> products, String category) {
        return products == null ? List.of() : products.stream().filter(p -> p.getCategory() != null && p.getCategory().equals(category)).collect(Collectors.toList());
    }

    // 3. Top rated products above threshold
    public static List<Product> topRatedProducts(List<Product> products, double minRating) {
        return products == null ? List.of() : products.stream().filter(p -> p.getRating() >= minRating).collect(Collectors.toList());
    }

    // 4. Products that contain a specific tag
    public static List<Product> productsWithTag(List<Product> products, String tag) {
        if (products == null || tag == null) return List.of();
        return products.stream()
                .filter(p -> p.getTags() != null && p.getTags().contains(tag))
                .collect(Collectors.toList());
    }

    // 5. Count products by category
    public static Map<String, Long> countByCategory(List<Product> products) {
        return products == null ? Map.of() : products.stream().collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));
    }

    // 6. Average price by category
    public static Map<String, Double> averagePriceByCategory(List<Product> products) {
        return products == null ? Map.of() : products.stream().collect(Collectors.groupingBy(Product::getCategory, Collectors.averagingDouble(Product::getPrice)));
    }

    // 7. Most expensive product (optional)
    public static Optional<Product> mostExpensive(List<Product> products) {
        return products == null ? Optional.empty() : products.stream().max((a,b) -> Double.compare(a.getPrice(), b.getPrice()));
    }

    // 8. Cheapest product (optional)
    public static Optional<Product> cheapest(List<Product> products) {
        return products == null ? Optional.empty() : products.stream().min((a,b) -> Double.compare(a.getPrice(), b.getPrice()));
    }

    // 9. Sort products by price
    public static List<Product> sortByPrice(List<Product> products, boolean ascending) {
        if (products == null) return List.of();
        return products.stream().sorted((a,b) -> ascending ? Double.compare(a.getPrice(), b.getPrice()) : Double.compare(b.getPrice(), a.getPrice())).collect(Collectors.toList());
    }

    // 10. Get a comma-separated list of product names
    public static String namesJoined(List<Product> products) {
        return products == null ? "" : products.stream().map(Product::getName).collect(Collectors.joining(", "));
    }

    // 11. Any product out of stock (stock <= 0)
    public static boolean anyOutOfStock(List<Product> products) {
        return products != null && products.stream().anyMatch(p -> p.getStock() <= 0);
    }

    // 12. All products have positive price
    public static boolean allPositivePrice(List<Product> products) {
        return products == null ? true : products.stream().allMatch(p -> p.getPrice() > 0);
    }

    // 13. No products with null name
    public static boolean noneNullName(List<Product> products) {
        return products == null ? true : products.stream().noneMatch(p -> p.getName() == null);
    }

    // 14. Paginate products (page is 0-based)
    public static List<Product> paginate(List<Product> products, int page, int pageSize) {
        if (products == null || pageSize <= 0 || page < 0) return List.of();
        return products.stream().skip((long) page * pageSize).limit(pageSize).collect(Collectors.toList());
    }

    // 15. Distinct categories
    public static Set<String> distinctCategories(List<Product> products) {
        return products == null ? Set.of() : products.stream().map(Product::getCategory).filter(c -> c != null).collect(Collectors.toSet());
    }

    // 16. Map of id -> price
    public static Map<String, Double> idToPrice(List<Product> products) {
        return products == null ? Map.of() : products.stream().collect(Collectors.toMap(Product::getId, Product::getPrice));
    }

    // 17. Sum of all prices
    public static double sumPrices(List<Product> products) {
        return products == null ? 0.0 : products.stream().mapToDouble(Product::getPrice).sum();
    }

    // 18. Price statistics summary
    public static DoubleSummaryStatistics priceStats(List<Product> products) {
        return products == null ? new DoubleSummaryStatistics() : products.stream().collect(Collectors.summarizingDouble(Product::getPrice));
    }

    // 19. First product matching predicate
    public static Optional<Product> findFirstMatching(List<Product> products, java.util.function.Predicate<Product> predicate) {
        return products == null ? Optional.empty() : products.stream().filter(predicate).findFirst();
    }

    // 20. Demonstrate flatMap to get all tags across products
    public static List<String> allTags(List<Product> products) {
        if (products == null) return List.of();
        return products.stream().flatMap(p -> p.getTags() == null ? java.util.stream.Stream.empty() : p.getTags().stream()).distinct().collect(Collectors.toList());
    }
}

