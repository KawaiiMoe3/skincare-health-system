package Report;

import Product.Product;
import Product.ProductList;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StockReport {

    public static void generateStockReport() {
        Product[] products = ProductList.getAllProducts();

        if (ProductList.getProductCount() == 0) {
            System.out.println("\nThe stock is empty. No available to generate the stock report.");
            return;
        }

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String reportDateTime = now.format(formatter);
        String reportId = "STOCK_REPORT_" + reportDateTime.replace(" ", "_").replace(":", "");

        System.out.println("------------------------------------------");
        System.out.println("\t\t\tStock Report");
        System.out.println("------------------------------------------");
        System.out.println("Report ID: " + reportId);
        System.out.println("Date/Time: " + reportDateTime);

        // Table header
        System.out.println("\n--------------------------------------------------------------------");
        System.out.printf("| %-12s | %-25s | %-8s | %-10s |%n", "Product ID", "Product Name", "Quantity", "Unit Price");
        System.out.println("--------------------------------------------------------------------");

        // Table body
        for (Product product : products) {
            if (product != null) {
                System.out.printf("| %-12s | %-25s | %-8d | %-10.2f |%n", product.getId(), product.getName(), product.getQuantity(), product.getUnitPrice());
            }
        }

        // Table footer
        System.out.println("--------------------------------------------------------------------");
    }
}
