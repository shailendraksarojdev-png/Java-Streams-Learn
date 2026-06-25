Act as a Principal Java Architect. I want to deeply learn and master Java 8 Streams by working on a real-world, hands-on project. I need you to scaffold a complete, compilable, basic monolithic E-Commerce backend using Spring Boot (Java 17 or 11, using Java 8 Stream features).

Instead of writing the stream logic for me, you will leave specific sections blank (using `// TODO: Implement using Java 8 Streams`) so I can write the code myself to make the project work.

### Project Setup Requirements
1. Provide the complete `pom.xml` with dependencies for Spring Boot Starter Web and Lombok.
2. Provide standard, robust Domain Models (POJOs) using Lombok:
    - `Product` (id, name, category, price, stock, rating, tags)
    - `User` (id, username, email, tier [GOLD, SILVER, PLATINUM], active)
    - `Order` (id, userId, items [List<OrderItem>], orderDate, status [PENDING, SHIPPED, DELIVERED, CANCELLED], totalAmount)
    - `OrderItem` (productId, quantity, unitPrice)
3. Provide a `DataGenerator` class that pre-populates a mock in-memory database (`List<Product>`, `List<User>`, `List<Order>`) with realistic data for testing.

### Exercise Structure
Generate exactly 15 separate Service/Component classes, cleanly divided into 4 progressive modules (Beginner to Advanced). Each class must contain:
- A clear business scenario.
- A fully defined method signature with inputs and return types.
- A `// TODO` block where the Java 8 Stream logic belongs.
- A brief comment explaining the expected behavior.

Generate the code for the following 15 files:

#### MODULE 1: Beginner (Filtering, Mapping, and Basic Matching)
1. `ProductFilterService.java`: Filter products by category, rating, or price ranges.
2. `UserTransformService.java`: Extract emails, convert usernames to uppercase, and map users to simple DTOs.
3. `InventoryCheckService.java`: Use `anyMatch`, `allMatch`, and `noneMatch` to check stock availability and active users.
4. `BasicSearchService.java`: Use `findFirst` and `findAny` to locate specific products or orders safely using `Optional`.

#### MODULE 2: Intermediate (Slicing, Sorting, and Reductions)
5. `ProductCatalogService.java`: Sort products by price (ascending/descending) and implement pagination using `skip` and `limit`.
6. `SalesAnalyticsService.java`: Calculate total revenue, average order values, and max/min priced orders using `mapToDouble`, `sum`, and `summaryStatistics`.
7. `TagCloudService.java`: Use `flatMap` to extract and flatten distinct tags across all products in the catalog.
8. `OrderStringService.java`: Reduce order data into formatted CSV or display strings using `Collectors.joining`.

#### MODULE 3: Advanced (Grouping, Partitioning, and Advanced Collecting)
9. `OrderSegmentationService.java`: Group orders by their status (`OrderStatus`) using `Collectors.groupingBy`.
10. `CustomerTierService.java`: Partition users into VIP vs. Regular customers based on their tier using `Collectors.partitioningBy`.
11. `AdvancedAnalyticsService.java`: Group products by category and find the most expensive product in each category (`Collectors.collectingAndThen`).
12. `FinancialReportService.java`: Compute total revenue generated per product category using downstream collectors (`groupingBy` + `summingDouble`).

#### MODULE 4: Senior/Expert (Infinite Streams, Custom Collectors, and Parallel Processing)
13. `PromoCodeGenerator.java`: Use `Stream.generate` or `Stream.iterate` to create a stream of infinite unique promo codes, limited to a specific batch size.
14. `ParallelOrderProcessor.java`: Process a massive list of orders using `parallelStream`, showing performance-critical filtering and total calculations safely.
15. `CustomOrderCollector.java`: Implement a custom `Collector` or use a complex custom mutable reduction to aggregate order statistics into a specialized `DashboardMetrics` DTO.

### Output Style
Please provide the complete code for these 15 files sequentially. Ensure the boilerplate (imports, class definitions, method headers) is entirely syntactically correct and compilable so I can copy-paste it directly into an IDE like IntelliJ.