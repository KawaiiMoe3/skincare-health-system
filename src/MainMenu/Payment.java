package MainMenu;

import java.util.Scanner;

public class Payment {
    private static Scanner scanner = new Scanner(System.in);

    public static PaymentDetails makePayment(double totalPrice) {
        System.out.println("------------------------------------------");
        System.out.println("\t\t\tPayment");
        System.out.println("------------------------------------------");
        double amountPaid = 0; // Initialize the amount paid
        String paymentMethod = "";

        while (true) {
            System.out.println("\nSelect payment method:");
            System.out.println("1. Cash");
            System.out.println("2. Credit/Debit Card");
            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    paymentMethod = "Cash";
                    break;
                case 2:
                    paymentMethod = "Credit/Debit Card";
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    continue;
            }

            System.out.print("Enter amount to pay: ");
            amountPaid = scanner.nextDouble();

            // Check the required amount of payment
            if (amountPaid < totalPrice) {
                System.out.printf("\nTotal amount that you need to pay is RM %.2f%n", totalPrice);
            } else if (amountPaid == totalPrice) {
                System.out.println("\nPayment Successfully, Thank you!");
                break;
            } else {
                double change = amountPaid - totalPrice;
                System.out.printf("\nTotal amount you need to pay is RM %.2f%n", totalPrice);
                System.out.printf("Amount you paid is RM %.2f%n", amountPaid);
                System.out.printf("Change amount: RM %.2f%n", change);
                System.out.println("\nPayment Successfully, Thank you!");
                break;
            }
        }
        return new PaymentDetails(paymentMethod, amountPaid);
    }

    public static class PaymentDetails {
        private String paymentMethod;
        private double amountPaid;

        // PaymentDetails constructor
        public PaymentDetails(String paymentMethod, double amountPaid) {
            this.paymentMethod = paymentMethod;
            this.amountPaid = amountPaid;
        }

        // Method to get payment method
        public String getPaymentMethod() {
            return paymentMethod;
        }

        // Method to get amount paid
        public double getAmountPaid() {
            return amountPaid;
        }
    }
}
