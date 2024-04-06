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

    public Invoice(ArrayList<InvoiceItem> items, String paymentMethod, double paidAmount, double totalPrice, LocalDateTime dateTime) {
        this.items = items;
        this.paymentMethod = paymentMethod;
        this.paidAmount = paidAmount;
        this.totalPrice = totalPrice;
        this.dateTime = dateTime;
    }

    // Method to add an invoice to the list
    public static void addInvoice(Invoice invoice) {
        invoiceList.add(invoice);
    }

    // Method to get the list of invoices
    public static ArrayList<Invoice> getInvoiceList() {
        return invoiceList;
    }


    public void generateInvoice() {

        // Define the desired date and time format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // Format the LocalDateTime object using the formatter
        String formattedDateTime = dateTime.format(formatter);

        System.out.println("------------------------------------------");
        System.out.println("\t\t\tInvoice");
        System.out.println("------------------------------------------");
        System.out.println("Details:");
        System.out.printf("Total Price: RM %.2f" , totalPrice);
        System.out.println("\n");
        System.out.println("Payment Method: " + paymentMethod);
        System.out.printf("Paid Amount: RM %.2f" , paidAmount);
        System.out.println("\n");
        System.out.println("Date & Time: " + formattedDateTime);

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
            return "Product: " + productName +
                    ", Quantity: " + quantity +
                    ", Unit Price: RM " + unitPrice +
                    ", Total Price: RM " + totalPrice;
        }
    }
}
