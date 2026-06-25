package com.shopwise.service.basics;

import com.shopwise.model.Product;
import com.shopwise.util.DataGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class StreamBasicsExercises1Test {

    private List<Product> products;

    @BeforeEach
    public void setup() {
        products = new DataGenerator().generateProducts();
        assertNotNull(products);
        assertTrue(products.size() >= 10, "expect at least 10 products in sample data");
    }

    @Test
    void productNames_and_count() {
        List<String> names = StreamBasicsExercises1.productNames(products);
        assertEquals(products.size(), names.size());
        assertTrue(names.contains("Wireless Mouse"), "should contain Wireless Mouse");
    }

    @Test
    void productsInCategory_electronics() {
        List<Product> electronics = StreamBasicsExercises1.productsInCategory(products, "Electronics");
        // DataGenerator provides 4 electronics items
        assertEquals(4, electronics.size());
    }

    @Test
    void topRatedProducts_minRating() {
        List<Product> top = StreamBasicsExercises1.topRatedProducts(products, 4.6);
        // Expected at least the high-rated items (based on DataGenerator)
        assertTrue(top.size() >= 3);
    }

    @Test
    void productsWithTag_kitchen() {
        List<Product> kitchen = StreamBasicsExercises1.productsWithTag(products, "kitchen");
        assertTrue(kitchen.size() >= 2);
    }

    @Test
    void countAndAverageByCategory() {
        Map<String, Long> counts = StreamBasicsExercises1.countByCategory(products);
        Map<String, Double> avgs = StreamBasicsExercises1.averagePriceByCategory(products);
        assertFalse(counts.isEmpty());
        assertFalse(avgs.isEmpty());
        assertEquals(counts.get("Electronics").longValue(), 4L);
        assertTrue(avgs.containsKey("Electronics"));
    }

    @Test
    void mostExpensive_cheapest_sorting() {
        Optional<Product> most = StreamBasicsExercises1.mostExpensive(products);
        Optional<Product> least = StreamBasicsExercises1.cheapest(products);
        assertTrue(most.isPresent());
        assertTrue(least.isPresent());
        assertEquals("Espresso Machine", most.get().getName());
        assertEquals("Coffee Mug", least.get().getName());

        List<Product> asc = StreamBasicsExercises1.sortByPrice(products, true);
        assertEquals(least.get().getPrice(), asc.get(0).getPrice());
    }

    @Test
    void namesJoined_and_sum_and_stats() {
        String joined = StreamBasicsExercises1.namesJoined(products);
        assertTrue(joined.length() > 0);

        double sum = StreamBasicsExercises1.sumPrices(products);
        assertTrue(sum > 0.0);

        var stats = StreamBasicsExercises1.priceStats(products);
        assertEquals(products.size(), stats.getCount());
    }

    @Test
    void findFirstMatching_and_allTags() {
        Optional<Product> expensive = StreamBasicsExercises1.findFirstMatching(products, p -> p.getPrice() > 200);
        assertTrue(expensive.isPresent());
        assertEquals("Espresso Machine", expensive.get().getName());

        var tags = StreamBasicsExercises1.allTags(products);
        assertTrue(tags.contains("coffee") || tags.contains("kitchen"));
    }

    @Test
    void pagination_and_distinct_categories() {
        List<Product> page0 = StreamBasicsExercises1.paginate(products, 0, 5);
        assertEquals(5, page0.size());

        var cats = StreamBasicsExercises1.distinctCategories(products);
        assertTrue(cats.size() >= 3);
    }
}
