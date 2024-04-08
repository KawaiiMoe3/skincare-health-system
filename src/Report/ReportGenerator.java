package Report;

import java.util.Scanner;

public class ReportGenerator {

    public static void generateReports(Scanner scanner) {
        while (true) {
            System.out.println("------------------------------------------");
            System.out.println("\t\t\tReport Generator");
            System.out.println("------------------------------------------");
            System.out.println("1. Generate Stock Report");
            System.out.println("2. Generate Sales Report");
            System.out.println("3. Go Back");
            System.out.print("\nPlease enter your choice (1-3): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    StockReport.generateStockReport();
                    break;
                case 2:
                    generateSalesReport();
                    break;
                case 3:
                    System.out.println("Going back...");
                    return; // Exit the method
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                    break;
            }
        }
    }

    private static void generateSalesReport() {
        // Implement logic to generate sales report
        System.out.println("Sales report generated.");
    }
}
