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

    // Getter and setter methods for id
    public String getId() {
        return id;
    }

    // Getter and setter methods for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and setter methods for quantity
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Getter and setter methods for unitPrice
    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return String.format("ID: %-10s Product Name: %-20s Quantity: %-5d Unit Price: RM %.2f",
                id, name, quantity, unitPrice);
    }
}
