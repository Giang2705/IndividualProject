import java.util.ArrayList;
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

    public void displayProduct (Admin admin, Product product, ArrayList<Product> listOfProducts){
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

        boolean isContinue = true;
        if (admin.isAdmin()){
            while (isContinue){
                System.out.print("Do you want to delete/update product or go back? Please enter DELETE/UPDATE/BACK to do the action: ");
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("delete")){
                    deleteProduct(product, listOfProducts);
                    isContinue = false;
                } else if (input.equalsIgnoreCase("update")) {
                    updateProduct(product);
                    product.displayProduct(admin, product, listOfProducts);
                    isContinue = false;
                } else if (input.equalsIgnoreCase("back")){
                    isContinue = false;
                } else {
                    System.out.println("Please input DELETE/UPDATE/BACK");
                }
            }
        } else {
            while (isContinue){
                System.out.print("Do you want to buy product or go back? Please enter BUY/BACK to do the action: ");
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("buy")){
                    user.getCart().addItem(product.getProductName());
                } else if (input.equalsIgnoreCase("back")){
                    isContinue = false;
                } else {
                    System.out.println("Please input BUY/BACK");
                }
            }
        }
    }

    public void deleteProduct(Product product, ArrayList<Product> listOfProducts){
        for (int i = 0; i < listOfProducts.size(); i++){
            if (product == listOfProducts.get(i)){
                listOfProducts.remove(listOfProducts.get(i));
            }
        }

        System.out.println("Product has been deleted!");
    }

    public void updateProduct(Product product){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Product's name: " + product.getProductName());
        System.out.print("New name (enter to skip this field): ");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()){
            product.setProductName(newName);
        }

        System.out.println("Product's description: " + product.getDescription());
        System.out.print("New description (enter to skip this field): ");
        String description = scanner.nextLine();
        if (!description.isEmpty()){
            product.setDescription(description);
        }

        System.out.println("Product's type: " + product.getType().getType());
        System.out.print("New type (physical/digital) (enter to skip this field): ");
        String newType = scanner.nextLine();
        if (!newType.isEmpty()){
            if (newType.equalsIgnoreCase("physical")){
                System.out.print("Please input product's weight: ");
                double weight = scanner.nextDouble();
                product.setType(new Physical(weight));
                product.setWeight(weight);
            } else if (newType.equalsIgnoreCase("digital")){
                product.setWeight(0);
                product.setType(new Digital());
            }
        }

        System.out.println("Product's price: " + product.getPrice());
        System.out.print("New price (enter to skip this field): ");
        String newPrice = new Scanner(System.in).nextLine();
        if (!newPrice.isEmpty()){
            double price = Double.parseDouble(newPrice);
            product.setPrice(price);
        }

        if (product.getMessage() != null){
            System.out.println("Product's message: " + product.getMessage());
        }
        System.out.print("New message: ");
        String newMessage = new Scanner(System.in).nextLine();
        if (!newMessage.isEmpty()){
            product.setMessage(newMessage);
        }

        if(product.getWeight() != 0){
            System.out.println("Product's weight: " + product.getWeight());
            System.out.print("New weight: ");
            String newWeight = new Scanner(System.in).nextLine();
            if (!newWeight.isEmpty()){
                double weight = Double.parseDouble(newWeight);
                product.setWeight(weight);
            }
        }

        System.out.println("Update product successfully!");
    }

}
