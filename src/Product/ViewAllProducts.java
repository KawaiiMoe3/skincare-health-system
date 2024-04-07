package Product;

public class ViewAllProducts {
    public static void viewAllProducts() {
        Product[] products = ProductList.getAllProducts();

        System.out.println("\nAll Products:\n");
        boolean productsExist = false; // Flag to track if any products exist

        for (Product product : products) {
            if (product != null) {
                productsExist = true;
                System.out.println(product);
            }
        }

        if (!productsExist) {
            System.out.println("\nNo products available.");
        }
    }
}
