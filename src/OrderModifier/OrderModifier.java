package OrderModifier;

import MainMenu.Invoice;
import MainMenu.StockManager;
import Report.ReportGenerator;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OrderModifier {
    public static void orderModifier(Scanner scanner) {
        while (true) {
            System.out.println("------------------------------------------");
            System.out.println("\t\t\tOrder Modifier");
            System.out.println("------------------------------------------");
            System.out.println("1. View Customer Invoice");
            System.out.println("2. Go Back");
            System.out.println("------------------------------------------");

            try {
                System.out.print("Enter your option (1-3): ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        ViewCustomerInvoice.viewInvoices();
                        break;
                    case 2:
                        System.out.println("Going back...");
                        return; // Return to main menu
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number (1-2).");
                scanner.nextLine(); // Clear the invalid input from scanner buffer
            }
        }
    }
}
