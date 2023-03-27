import java.util.Scanner;

/**
 * @author Nguyen Thi Ha Giang - S3914108
 */
public class Product {
//    attributes
    private String productName;
    private String description;
    private Type type;
    private int quantityAvailable;
    private double price;
    private String message = null;
    private double weight = 0;

//    constructor
    public Product() {

    }
    public Product(String productName, String description, Type type, int quantityAvailable, double price, String message, double weight) {
        this.productName = productName;
        this.description = description;
        this.type = type;
        this.quantityAvailable = quantityAvailable;
        this.price = price;
        this.message = message;
        this.weight = weight;
    }

//    getter and setter
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void displayProduct (Product product){
        System.out.println("Product's name: " + product.getProductName());
        System.out.println("Product's description: " + product.getDescription());
        System.out.println("Product's type: " + product.getType().getType());
        System.out.println("Product's quantity available: " + product.getQuantityAvailable());
        System.out.println("Product's price: " + product.getPrice());
        if(product.weight != 0) {
            System.out.println("Product's weight: " + product.getWeight());
        }
        if(product.message != null) {
            System.out.println("Product's message: " + product.getMessage());
        }
    }
}
