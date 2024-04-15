package Report;

import MainMenu.Invoice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SalesReport {

    public static void generateSalesReport() {
        ArrayList<Invoice> invoiceList = Invoice.getInvoiceList();

        double totalSales = 0.0;
        Map<String, Integer> productQuantityMap = new HashMap<>();
        Map<String, Double> productTotalPriceMap = new HashMap<>();

        // Generate Sales Report ID
        String reportId = generateReportId();

        // Get current date and time
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t\t\t\t\t\tSales Report");
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("Sales Report ID: " + reportId);
        System.out.println("Date/Time: " + formattedDateTime);

        // Iterate through each invoice
        for (Invoice invoice : invoiceList) {
            totalSales += invoice.getTotalSales();

            // Iterate through each item in the invoice
            for (MainMenu.Invoice.InvoiceItem item : invoice.getItems()) {
                String productName = item.getProductName();
                int quantity = item.getQuantity();
                double totalPrice = item.getTotalPrice();

                // Update product quantity map
                productQuantityMap.put(productName, productQuantityMap.getOrDefault(productName, 0) + quantity);

                // Update product total price map
                productTotalPriceMap.put(productName, productTotalPriceMap.getOrDefault(productName, 0.0) + totalPrice);
            }
        }

        // Print sales report table header
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.printf("| %-5s | %-25s | %-13s | %-17s | %-17s |\n", "No.", "Product Name", "Quantity Sold", "Unit Price (RM)", "Total Price (RM)");
        System.out.println("--------------------------------------------------------------------------------------------");

        // Print sales report table content
        int i = 1;
        for (Map.Entry<String, Integer> entry : productQuantityMap.entrySet()) {
            String productName = entry.getKey();
            int totalQuantity = entry.getValue();
            double totalPrice = productTotalPriceMap.get(productName);
            double unitPrice = totalPrice / totalQuantity;

            // Print each product's sales information
            System.out.printf("| %-5d | %-25s | %-13d | %-17.2f | %-17.2f |\n", i++, productName, totalQuantity, unitPrice, totalPrice);
        }

        // Print sales report table footer
        System.out.println("--------------------------------------------------------------------------------------------");

        // Print total sales
        System.out.printf("Total Sales: RM %.2f\n", totalSales);
        System.out.println("--------------------------------------------------------------------------------------------");
    }

    // Method to generate a unique Sales Report ID
    private static String generateReportId() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HHmmss");
        String formattedDateTime = now.format(formatter);
        return "SALES_REPORT_" + formattedDateTime;
    }
}
