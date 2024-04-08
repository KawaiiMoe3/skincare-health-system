package Product;

public class ProductList {

    //Maximum of products is 100
    private static final int MAX_PRODUCTS = 100;
    private static Product[] productList = new Product[MAX_PRODUCTS];
    private static int productCount = 0;

    // To add a product method
    public static void addProduct(Product product) {
        if (productCount < MAX_PRODUCTS) {
                productList[productCount] = product;
            productCount++;
            System.out.println("\nProduct added successfully.");
        } else {
            System.out.println("\nProduct list is full. Cannot add more products.");
        }
    }

    // Method to get all products
    public static Product[] getAllProducts() {
        return productList;
    }

    // Method to get the number of products stored
    public static int getProductCount() {
        return productCount;
    }

    // To delete a product
    public static void deleteProduct(int index) {
        if (index >= 0 && index < productCount) {
            // Shift products to fill the gap left by the removed product
            for (int i = index; i < productCount - 1; i++) {
                productList[i] = productList[i + 1];
            }
            // Nullify the last element
            productList[productCount - 1] = null;
            // Decrease product count
            productCount--;
            System.out.println("\nProduct deleted successfully.");
        } else {
            System.out.println("\nInvalid index.");
        }
    }
}
