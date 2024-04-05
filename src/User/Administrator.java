package User;

import java.util.Scanner;

public class Administrator {
    private static final String ADMIN_ID = "ad001";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "1234";
    private static final String EMAIL = "admin@gmail.com";

    public void adminLogin(Scanner scanner) {
        System.out.println("------------------------------------------");
        System.out.println("\t\t\tAdministrator Login");
        System.out.println("------------------------------------------");

        boolean loggedIn = false;
        while (!loggedIn){
            System.out.print("Enter username: ");
            String enteredUsername = scanner.nextLine();

            System.out.print("Enter password: ");
            String enteredPassword = scanner.nextLine();

            if (USERNAME.equals(enteredUsername) && PASSWORD.equals(enteredPassword)) {
                System.out.println("------------------------------------------");
                System.out.println("\t\t\tWelcome " + USERNAME);
                System.out.println("------------------------------------------");
                System.out.println("What are you going to do today?\n");
                loggedIn = true;
            } else {
                System.out.println("\nInvalid username or password. Please try again.");
            }
        }
    }
}
