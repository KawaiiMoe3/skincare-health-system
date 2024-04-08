package MainMenu;

import java.util.InputMismatchException;
import java.util.Scanner;
import Report.ReportGenerator;

public class AdministratorMenu {
    public static void administratorMenu(Scanner scanner) {
        while (true) {
            System.out.println("------------------------------------------");
            System.out.println("\t\t\tAdministrator Menu");
            System.out.println("------------------------------------------");
            System.out.println("What are you going to do today?\n");
            System.out.println("1. Stock Manager");
            System.out.println("2. Generate Report");
            System.out.println("3. Logout");
            System.out.println("------------------------------------------");

            try {
                System.out.print("Enter your option (1-3): ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        StockManager.stockManagerMenu(scanner);
                        break;
                    case 2:
                        ReportGenerator.generateReports(scanner);
                        break;
                    case 3:
                        System.out.println("Logging out...");
                        return; // Return to main menu
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number (1-3).");
                scanner.nextLine(); // Clear the invalid input from scanner buffer
            }
        }
    }
}
