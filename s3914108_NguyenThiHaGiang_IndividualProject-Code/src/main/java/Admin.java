import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Nguyen Thi Ha Giang - S3914108
 */

public class Admin {
    private String username;
    private String password;
    private boolean isAdmin;


    //    Constructor
    public Admin() {

    }

    public Admin(String id, String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    //    Getter and Setter
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdmin(boolean isAdmin){
        this.isAdmin = isAdmin;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public boolean adminLogin(String username, String password) {
        if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin123")){
            this.isAdmin = true;
            return true;
        } else {
            System.out.println("Wrong username or password. Please try again!");
            return false;
        }
    }

    public boolean isExisted(String productName, ArrayList<Product> listOfProducts){
        for (int i = 0; i < listOfProducts.size(); i++){
            if (productName.equalsIgnoreCase(listOfProducts.get(i).getProductName())){
                return true;
            }
        }
        return false;
    }

    public void addNewProduct(String productName, String description, String typeName, int quantityAvailable, double price, ArrayList<Product> listOfProducts){
        Scanner scanner = new Scanner(System.in);
        Type type = new Type();
        Product newProduct = new Product();


        while (isExisted(productName, listOfProducts)) {
            System.out.print("This product is existed. Please input another name: ");
            productName = scanner.nextLine();
        }

        System.out.print("Can it be a gift? (y or n): ");
        String ans = scanner.nextLine();

        while (!ans.equalsIgnoreCase("y") && !ans.equalsIgnoreCase("n")){
            System.out.print("Please insert y/n: ");
            ans = scanner.nextLine();
        }

        if (ans.equalsIgnoreCase("y")){
            System.out.println("Input message: ");
            String mess = scanner.nextLine();

            newProduct.setMessage(mess);
            newProduct.setGift(true);
        } else {
            newProduct.setGift(false);
        }


        if (typeName.equalsIgnoreCase("physical")){
            System.out.print("Please set the weight for this product (kg): ");
            String input = scanner.nextLine();

            while (!isNumeric(input)){
                System.out.print("Please input double number for weight: ");
                input = scanner.nextLine();
            }

            type = new Physical(Double.parseDouble(input));
            newProduct.setWeight(Double.parseDouble(input));
            System.out.println(type.getType());
        } else {
            type = new Digital();
            System.out.println(type.getType());
        }

        newProduct.setProductName(productName);
        newProduct.setType(type);
        newProduct.setDescription(description);
        newProduct.setPrice(price);
        newProduct.setQuantityAvailable(quantityAvailable);

        listOfProducts.add(newProduct);

        System.out.println("Add new product successfully!");
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

        if (product.isGift()){
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

    public boolean isNumeric(String string) {
        if (string == null) {
            return false;
        }

        try {
            int i = Integer.parseInt(string);
        } catch (Exception exception) {
            try {
                double d = Double.parseDouble(string);
            } catch (NumberFormatException nfe) {
                return false;
            }
        }


        return true;
    }
}
