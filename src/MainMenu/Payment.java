package MainMenu;

import java.util.Scanner;

public class Payment {
    private static Scanner scanner = new Scanner(System.in);

    public static void makePayment(double totalPrice) {
        System.out.println("------------------------------------------");
        System.out.println("\t\t\tPayment");
        System.out.println("------------------------------------------");
        while (true) {
            System.out.println("\nSelect payment method:");
            System.out.println("1. Cash");
            System.out.println("2. Credit/Debit Card");
            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();

            System.out.print("Enter amount to pay: ");
            double amountPaid = scanner.nextDouble();

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
    }
}
