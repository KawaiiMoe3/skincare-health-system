package MainMenu;

import User.Customer;

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
                    MakeOrder.makeOrder();
                    break;
                case 2:
                    Invoice.viewInvoice();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please select again.");
                    break;
            }
        }
    }
}
