package User;

import java.util.Scanner;
import MainMenu.AdministratorMenu;

public class Administrator {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin";

    public void adminLogin(Scanner scanner) {
        System.out.println("------------------------------------------");
        System.out.println("\t\t\tAdministrator Login");
        System.out.println("------------------------------------------");

        while (true) {
            System.out.print("Enter username: ");
            String enteredUsername = scanner.nextLine();

            System.out.print("Enter password: ");
            String enteredPassword = scanner.nextLine();

            if (ADMIN_USERNAME.equals(enteredUsername) && ADMIN_PASSWORD.equals(enteredPassword)) {
                System.out.println("\nLogin successful!");
                break; // Break out of the login loop
            } else {
                System.out.println("\nInvalid username or password. Please try again.");
            }
        }
    }
}
