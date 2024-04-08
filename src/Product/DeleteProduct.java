package Product;

import java.util.Scanner;

public class DeleteProduct {
    public static void deleteProduct(Scanner scanner) {
        // Get all products
        Product[] products = ProductList.getAllProducts();

        // Check if there are any products available
        if (ProductList.getProductCount() == 0) {
            System.out.println("No product available. Please add at least one product first.");
            return;
        }

        // Display all products
        System.out.println("All Products:");
        for (Product product : products) {
            if (product != null) {
                System.out.println(product);
            }
        }
        System.out.println("------------------------------------------");

        // Prompt for productId to delete
        System.out.print("Enter the ID of the product you want to delete: ");
        String productId = scanner.nextLine();

        // Iterate through the product list to find the product with the specified ID
        boolean productFound = false;
        for (int i = 0; i < ProductList.getProductCount(); i++) {
            Product product = products[i];
            if (product.getId().equals(productId)) {
                productFound = true;
                // Delete product from the list
                ProductList.deleteProduct(i);
                break;
            }
        }

        // If product with specified ID is not found
        if (!productFound) {
            System.out.println("\nProduct not found with ID: " + productId);
        }
    }
}
