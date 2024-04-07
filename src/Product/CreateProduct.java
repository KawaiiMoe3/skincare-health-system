package Product;

import java.util.Scanner;

public class CreateProduct {
    public static void addProduct(Scanner scanner) {
        System.out.println("Enter product details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Unit Price: ");
        double unitPrice = scanner.nextDouble();

        Product product = new Product(name, quantity, unitPrice); // Automatically generate ID
        ProductList.addProduct(product);
    }
}
