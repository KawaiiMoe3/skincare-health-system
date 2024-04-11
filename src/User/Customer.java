package User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Customer {
    private int nextCustomerId = 1;
    private String dateCreated;
    private String username;

    public void createCustomerProfile(Scanner scanner) {
        System.out.println("------------------------------------------");
        System.out.println("\t\t\tCreate Profile");
        System.out.println("------------------------------------------");

        System.out.print("Enter username: ");
        this.username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        getCurrentDate();
        String cusID = "cus" + String.format("%03d", nextCustomerId++);

        System.out.println("------------------------------------------");
        System.out.println("Customer profile created successfully!");
        System.out.println("Customer ID: " + cusID);
        System.out.println("Username: " + this.username);
        System.out.println("Email: " + email);
        System.out.println("Date Created: " + dateCreated);
        System.out.println("------------------------------------------");
    }

    public String getUsername() {
        return this.username;
    }

    public String getId(){
        return String.valueOf(this.nextCustomerId);
    }

    private void getCurrentDate() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        dateCreated = currentDate.format(formatter);
    }
}
