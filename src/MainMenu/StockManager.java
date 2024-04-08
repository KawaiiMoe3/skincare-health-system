package MainMenu;

import Product.CreateProduct;
import Product.ViewAllProducts;
import Product.UpdateProduct;
import Product.DeleteProduct;
import java.util.Scanner;

public class StockManager {
    public static void stockManagerMenu(Scanner scanner) {
        while (true) {
            System.out.println("------------------------------------------");
            System.out.println("\t\t\tStock Manager");
            System.out.println("------------------------------------------");
            System.out.println("1. Create Product");
            System.out.println("2. Update Product");
            System.out.println("3. View All Products");
            System.out.println("4. Delete Product");
            System.out.println("5. Go Back");
            System.out.println("------------------------------------------");

            System.out.print("Enter your option (1-4): ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        CreateProduct.addProduct(scanner);
                        break;
                    case 2:
                        UpdateProduct.updateProduct(scanner);
                        break;
                    case 3:
                        ViewAllProducts.viewAllProducts();
                        break;
                    case 4:
                        DeleteProduct.deleteProduct(scanner);
                        break;
                    case 5:
                        System.out.println("Going back...");
                        return; // Return to AdministratorMenu
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                scanner.nextLine(); // Consume invalid input
            }
        }
    }
}
