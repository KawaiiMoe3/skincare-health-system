package MainMenu;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Invoice {
    private static ArrayList<Invoice> invoiceList = new ArrayList<>(); // Static list to store invoices
    private ArrayList<InvoiceItem> items;
    private String paymentMethod;
    private double paidAmount;
    private double totalPrice;
    private LocalDateTime dateTime;
    private String customerUsername;
    private String customerId;

    //Invoice constructor
    public Invoice(ArrayList<InvoiceItem> items, String paymentMethod, double paidAmount, double totalPrice, LocalDateTime dateTime, String customerUsername, String customerId) {
        this.items = items;
        this.paymentMethod = paymentMethod;
        this.paidAmount = paidAmount;
        this.totalPrice = totalPrice;
        this.dateTime = dateTime;
        this.customerUsername = customerUsername;
        this.customerId = customerId;
    }

    // Method to add an invoice to the list
    public static void addInvoice(Invoice invoice) {
        invoiceList.add(invoice);
    }

    // Method to get the list of invoices
    public static ArrayList<Invoice> getInvoiceList() {
        return invoiceList;
    }

    // Getter method for customer username
    public String getCustomerUsername() {
        return customerUsername;
    }

    // Getter method for customer ID
    public String getCustomerId() {
        return customerId;
    }

    // Method to get the product items
    public ArrayList<InvoiceItem> getItems() {
        return items;
    }

    // Method to calculate the total sales of the invoice
    public double getTotalSales() {
        double total = 0.0;
        for (InvoiceItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public void generateInvoice() {

        // Define the desired date and time format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // Format the LocalDateTime object using the formatter
        String formattedDateTime = dateTime.format(formatter);
        // Format the customer ID
        String formattedCustomerId = "cus" + String.format("%03d", Integer.parseInt(customerId));


        System.out.println("------------------------------------------");
        System.out.println("\t\t\tInvoice");
        System.out.println("------------------------------------------");
        System.out.println("Customer ID: " + formattedCustomerId);
        System.out.println("Customer Username: " + customerUsername);
        System.out.println("Date & Time: " + formattedDateTime);
        System.out.println("------------------------------------------");
        System.out.println("Details:");
        System.out.printf("Total Price: RM %.2f" , totalPrice);
        System.out.println("\n");
        System.out.println("Payment Method: " + paymentMethod);
        System.out.printf("Paid Amount: RM %.2f" , paidAmount);
        System.out.println("\n");
        System.out.println("------------------------------------------");

        for (InvoiceItem item : items) {
            System.out.println(item);
        }

        double change = paidAmount - totalPrice;
        if (change < 0) {
            System.out.println("Change Amount: RM 0.00\n");
        }
        else {
            System.out.printf("\nChange Amount: RM %.2f" , change);
            System.out.println("\n");
        }
    }

    // Invoice details
    public static class InvoiceItem {
        private String productName;
        private int quantity;
        private double unitPrice;
        private double totalPrice;

        public InvoiceItem(String productName, int quantity, double unitPrice, double totalPrice) {
            this.productName = productName;
            this.quantity = quantity;
            this.unitPrice = unitPrice;
            this.totalPrice = totalPrice;
        }

        @Override
        public String toString() {
            return String.format("Product: %s, Quantity: %d, Unit Price: RM %.2f, Total Price: RM %.2f",
                    productName, quantity, unitPrice, totalPrice);
        }

        // Method to get product name
        public String getProductName() {
            return productName;
        }

        // Method to get quantity sold
        public int getQuantity() {
            return quantity;
        }

        // Method to get unit price of product
        public double getUnitPrice() {
            return unitPrice;
        }

        // Method to get total price by quantity * quantity product sold
        public double getTotalPrice() {
            return totalPrice;
        }
    }
}
