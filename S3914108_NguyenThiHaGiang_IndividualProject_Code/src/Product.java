import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Nguyen Thi Ha Giang - S3914108
 */
public class Product {
    private String productName;
    private String description;
    private Type type;
    private int quantityAvailable;
    private double price;
    private double weight;
    private String message;
    private boolean isGift;

    //    constructor
    public Product() {

    }
    public Product(String productName, String description, Type type, int quantityAvailable, double price, double weight, boolean isGift) {
        this.productName = productName;
        this.description = description;
        this.type = type;
        this.quantityAvailable = quantityAvailable;
        this.price = price;
        this.weight = weight;
        this.isGift = isGift;
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isGift() {
        return isGift;
    }

    public void setGift(boolean gift) {
        isGift = gift;
    }

    public void displayProduct (boolean isAdmin, Product product, ArrayList<Product> listOfProducts, Admin admin){
        System.out.println("Product's name: " + product.getProductName());
        System.out.println("Product's description: " + product.getDescription());
        System.out.println("Product's type: " + product.getType().getType());
        System.out.println("Product's quantity available: " + product.getQuantityAvailable());
        System.out.println("Product's price: " + product.getPrice());
        if(product.getWeight() != 0) {
            System.out.println("Product's weight: " + product.getWeight());
        }
        if (product.isGift()){
            if(product.getMessage() != "") {
                System.out.println("Product's message: " + product.getMessage());
            }
        }

        boolean isContinue = true;
        if (isAdmin){
            while (isContinue){
                System.out.print("Do you want to delete/update product or go back? Please enter DELETE/UPDATE/BACK to do the action: ");
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();

                switch (input.toLowerCase()){
                    case "delete":
                        admin.deleteProduct(product, listOfProducts);
                        isContinue = false;
                        break;
                    case "update":
                        admin.updateProduct(product);
                        isContinue = false;
                        break;
                    case "back":
                        isContinue = false;
                        break;
                }

                System.out.println("Please input DELETE/UPDATE/BACK");
            }
        } else {
            while (isContinue){
                System.out.print("Do you want to buy product or go back? Please enter BUY/BACK to do the action: ");
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();

                switch (input.toLowerCase()) {
                    case "buy":

                        isContinue = false;
                        break;
                    case "back":

                        isContinue = false;
                        break;
                }

                System.out.println("Please input BUY/BACK");

            }
        }
    }


}
