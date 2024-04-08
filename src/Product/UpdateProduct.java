package Product;

import java.util.Scanner;

public class UpdateProduct {
    public static void updateProduct(Scanner scanner) {
        // Get all products
        Product[] products = ProductList.getAllProducts();

        // Check if there are any products available
        if (ProductList.getProductCount() == 0) {
            System.out.println("No product available. Please add at least one product first.");
            return;
        }

        // Display all products
        System.out.println("All Products:\n");
        for (Product product : products) {
            if (product != null) {
                System.out.println(product);
            }
        }
        System.out.println("------------------------------------------");

        // Prompt for productId to update
        System.out.print("\nEnter the ID of the product you want to update:");
        String productId = scanner.nextLine();

        // Iterate through the product list to find the product with the specified ID
        boolean productFound = false;
        for (int i = 0; i < ProductList.getProductCount(); i++) {
            Product product = products[i];
            if (product.getId().equals(productId)) {
                productFound = true;
                // Product found, prompt user for new details
                System.out.println("Enter new details for the product:");
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Quantity: ");
                int quantity = scanner.nextInt();
                System.out.print("Unit Price: ");
                double unitPrice = scanner.nextDouble();

                // Update product details
                product.setName(name);
                product.setQuantity(quantity);
                product.setUnitPrice(unitPrice);

                System.out.println("\nProduct updated successfully.");
                break;
            }
        }

        // If product with specified ID is not found
        if (!productFound) {
            System.out.println("\nProduct not found with ID: " + productId);
        }
    }
}
