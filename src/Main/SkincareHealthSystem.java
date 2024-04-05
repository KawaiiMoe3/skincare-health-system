package Main;

import java.util.Scanner;
import User.Customer;
import User.Administrator;
import MainMenu.CustomerMenu;

public class SkincareHealthSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Customer customer = new Customer();
        Administrator admin = new Administrator();

        System.out.println("Welcome to the system!");

        while (true) {
            System.out.println("------------------------------------------");
            System.out.println("\t\t\tWelcome to\n\tSkincare & Health System");
            System.out.println("------------------------------------------");
            System.out.println("1. Administrator");
            System.out.println("2. Customer");
            System.out.println("3. Exit");
            System.out.print("\nSelect user type: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    admin.adminLogin(scanner);
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
