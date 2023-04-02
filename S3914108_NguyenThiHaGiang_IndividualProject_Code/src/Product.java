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

    private double shippingFee;

    //    constructor
    public Product() {

    }
    public Product(String productName, String description, Type type, int quantityAvailable, double price, double weight, boolean isGift, double shippingFee) {
        this.productName = productName;
        this.description = description;
        this.type = type;
        this.quantityAvailable = quantityAvailable;
        this.price = price;
        this.weight = weight;
        this.isGift = isGift;
        this.shippingFee = shippingFee;
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

    public void setShippingFee(double shippingFee) {
        this.shippingFee = shippingFee;
    }

    public double getShippingFee() {
        return shippingFee;
    }

    public String toString() {
        return String.format("Product's name: %s \r\n" +
                            "Description: %s \r\n" +
                            "Type: %s \r\n" +
                            "Price: %s \r\n" +
                            "Weight: %s \r\n" +
                            "Message: %s \r\n" +
                            "Product's quantity available: %s"
                            ,
                this.productName, this.description, this.type.getType(), this.price, this.weight, this.message, this.quantityAvailable);
    }

    public void displayProduct (boolean isAdmin, Product product, ArrayList<Product> listOfProducts, Admin admin, ArrayList<Cart> listOfCarts){
        System.out.println(this.toString());

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
                    case "buy" -> {
                        if (product.getQuantityAvailable() > 0) {
                            System.out.println("List of carts:");
                            if (listOfCarts.size() == 0){
                                System.out.println("There is no cart. Please create cart before buying product.");
                                break;
                            } else {
                                for (int i = 0; i < listOfCarts.size(); i++) {
                                    System.out.println(i+1 + ". " + listOfCarts.get(i).toString(listOfProducts));
                                }
                            }
                            System.out.print("Please input the name of cart which you want to add product in: ");
                            String cartName = scanner.nextLine();
                            boolean existed = true;

                            for (int i = 0; i < listOfCarts.size(); i++) {
                                if (cartName.equalsIgnoreCase(listOfCarts.get(i).getName())) {
                                    if (listOfCarts.get(i).addItem(product.getProductName())) {
                                        product.setQuantityAvailable(product.getQuantityAvailable() - 1);
                                        product.setShippingFee(product.getWeight()*0.1);
                                        listOfCarts.get(i).addItem(product.getProductName());
                                        System.out.println("Product is added into cart successfully.");
                                    } else {
                                        System.out.println("This product already exists in cart");
                                    }
                                    existed = true;
                                } else {
                                    existed = false;
                                }
                            }

                            if (!existed){
                                System.out.println("There is no cart. Please try again.");
                                break;
                            }
                        } else {
                            System.out.println("Out of stock");
                        }
                        isContinue = false;
                    }
                    case "back" -> isContinue = false;
                }
            }
        }
    }

}
