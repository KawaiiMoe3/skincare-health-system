package Product;

public class ProductList {

    //Maximum of products is 100
    private static final int MAX_PRODUCTS = 100;
    private static Product[] productList = new Product[MAX_PRODUCTS];
    private static int productCount = 0;

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
}
