package MainMenu;

import User.Customer;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerMenu {
    public static void customerMenu(Customer customer){
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("------------------------------------------");
            System.out.println("\t\t\tWelcome, " + customer.getUsername());
            System.out.println("------------------------------------------");
            System.out.println("What are you going to do today?\n");
            System.out.println("1. Make Order\n2. View Invoice\n3. Logout\n");
            System.out.print("Please enter the option (1-3): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            //Call the corresponding function based on choice
            switch (choice){
                case 1:
                    MakeOrder.makeOrder(customer.getUsername(), customer.getId());
                    break;
                case 2:
                    viewInvoices();
                    break;
                case 3:
                    System.out.println("Logging out...");
                    return; // Return to main menu
                default:
                    System.out.println("Invalid choice. Please select again.");
                    break;
            }
        }
    }

    //Get invoices to review
    private static void viewInvoices() {
        ArrayList<Invoice> invoices = Invoice.getInvoiceList();
        if (invoices.isEmpty()) {
            System.out.println("No invoices available. Please make an order first.");
        } else {
            System.out.println("\nAvailable Invoices:\n");
            for (int i = 0; i < invoices.size(); i++) {
                System.out.println("\nInvoice " + (i + 1) + ":");
                invoices.get(i).generateInvoice();
            }
        }
    }
}
