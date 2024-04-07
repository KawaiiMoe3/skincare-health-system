package Product;

public class Product {
    private static int nextId = 1; // Static variable to keep track of the next available ID
    private String id;
    private String name;
    private int quantity;
    private double unitPrice;

    public Product(String name, int quantity, double unitPrice) {
        this.id = "prod" + String.format("%03d", nextId++); // Generate ID automatically
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    // Getters and setters (not shown for brevity)

    @Override
    public String toString() {
        return String.format("ID: %-10s Product Name: %-20s Quantity: %-5d Unit Price: RM %.2f",
                id, name, quantity, unitPrice);
    }
}
