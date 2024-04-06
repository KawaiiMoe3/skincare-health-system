package MainMenu;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class MakeOrder {

    private static final double[] PRICES = {29.90, 39.90, 59.90, 59.90, 49.90, 19.90, 79.90, 59.90, 49.90, 39.90};
    private static final String[] PRODUCTS = {
            "Cleanser",
            "Toner",
            "Serum",
            "Moisturizer",
            "Sunscreen",
            "Face masks",
            "Fish oil supplements",
            "Calcium supplements",
            "Protein powders",
            "Herbal supplements"
    };
    private static final int[] QUANTITIES = {1000, 550, 750, 600, 650, 500, 300, 450, 500, 700};
    private static Scanner scanner = new Scanner(System.in);
    public static void makeOrder(){
        System.out.println("------------------------------------------");
        System.out.println("\t\t\tMake Order");
        System.out.println("------------------------------------------");

        // List to store ordered items
        ArrayList<Invoice.InvoiceItem> items = new ArrayList<>();

        while (true) {
            int[] quantities = new int[PRODUCTS.length];
            double totalPrice = 0;

            // Loop for making orders
            while (true) {
                displayProductList();
                System.out.print("\nEnter product choice (1-" + PRODUCTS.length + "): ");
                int choice = scanner.nextInt();
                if (choice < 1 || choice > PRODUCTS.length) {
                    System.out.println("Invalid choice. Please enter a number between 1 and " + PRODUCTS.length);
                    continue;
                }
                System.out.print("Enter quantity: ");
                int quantity = scanner.nextInt();
                if (quantity > QUANTITIES[choice - 1]) {
                    System.out.println("Not enough quantity available.");
                    continue;
                }
                quantities[choice - 1] += quantity;
                QUANTITIES[choice - 1] -= quantity;
                double productTotal = PRICES[choice - 1] * quantity;
                totalPrice += productTotal;
                // Add the ordered item to the list
                items.add(new Invoice.InvoiceItem(PRODUCTS[choice - 1], quantity, PRICES[choice - 1], productTotal));

                System.out.print("\nDo you want to make another order? (Y/N): ");
                String option = scanner.next();
                if (!option.equalsIgnoreCase("Y")) {
                    break;
                }
            }

            // Display ordered products and total price
            System.out.println("\n\nOrdered Products:");
            for (int i = 0; i < PRODUCTS.length; i++) {
                if (quantities[i] > 0) {
                    double unitPrice = PRICES[i];
                    double productTotal = unitPrice * quantities[i];
                    System.out.printf("%-25s Quantity: %-10d Unit Price: RM %-10.2f Total Price: RM %.2f%n", PRODUCTS[i], quantities[i], unitPrice, productTotal);
                }
            }
            System.out.printf("Total Price: RM %.2f%n", totalPrice);

            // Payment process
            System.out.print("\nProceed to payment? (Y = Yes / N = No): ");
            String proceed = scanner.next();
            if (proceed.equalsIgnoreCase("Y")) {
                Payment.PaymentDetails paymentDetails = Payment.makePayment(totalPrice);
                String paymentMethod = paymentDetails.getPaymentMethod();
                double amountPaid = paymentDetails.getAmountPaid();
                Invoice invoice = new Invoice(items, paymentMethod, amountPaid, totalPrice, LocalDateTime.now());
                // Add the invoice to the list
                Invoice.addInvoice(invoice);
            } else {
                System.out.println("Thank you for shopping with us!");
            }

            // Ask if the customer wants to make another order
            System.out.print("Do you want to make another order? (Y = Yes / N = No): ");
            String repeat = scanner.next();
            if (!repeat.equalsIgnoreCase("Y")) {
                break;
            }
        }
    }

    private static void displayProductList() {
        System.out.println("\nSkincare and Health Product List:");
        for (int i = 0; i < PRODUCTS.length; i++) {
            System.out.printf("%d. %-26s Quantity: %-10d Unit Price: RM %.2f%n", i + 1, PRODUCTS[i], QUANTITIES[i], PRICES[i]);
        }
    }
}