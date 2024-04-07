package Main;

import java.util.Scanner;

import MainMenu.AdministratorMenu;
import User.Customer;
import User.Administrator;
import MainMenu.CustomerMenu;

public class SkincareHealthSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Customer customer = new Customer();
        Administrator admin = new Administrator();

        while (true) {
            System.out.println("------------------------------------------");
            System.out.println("\t\t\tWelcome to\n\tSkincare & Health System");
            System.out.println("------------------------------------------");
            System.out.println("Please select your user type:\n");
            System.out.println("1. Administrator");
            System.out.println("2. Customer");
            System.out.println("3. Exit");
            System.out.print("\nSelect user type: ");

            // Read the user's choice
            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number (1-3).");
                continue; // Restart the loop to prompt the user again
            }

            switch (choice) {
                case 1:
                    admin.adminLogin(scanner);
                    AdministratorMenu.administratorMenu(scanner);
                    break;
                case 2:
                    customer.createCustomerProfile(scanner);
                    CustomerMenu.customerMenu(customer);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
