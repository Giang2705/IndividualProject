import java.lang.reflect.Field;
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
        this.isAdmin = true;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    //    admin's function

    public boolean adminLogin(String username, String password) {
        if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin123")){
            return true;
        }
        return false;
    }

    public boolean isExisted(String productName, ArrayList<Product> listOfProducts){
        for (int i = 0; i < listOfProducts.size(); i++){
            if (productName.equalsIgnoreCase(listOfProducts.get(i).getProductName())){
                return true;
            }
        }
        return false;
    }

    public void addNewProduct(String productName, String description, String typeName, int quantityAvailable, double price, String message, ArrayList<Product> listOfProducts) throws IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        Type type = new Type();

        while (isExisted(productName, listOfProducts)) {
            System.out.print("This product is existed. Please input another name: ");
            productName = scanner.nextLine();
        }


        Product newProduct = new Product();

        if (typeName.equalsIgnoreCase("physical")){
            System.out.print("Please set the weight for this product (kg): ");
            double input = scanner.nextDouble();
            type = new Physical(input);
            System.out.println(type.getType());
            newProduct = new Product(productName, description, type, quantityAvailable, price, message, input);
        } else {
            type = new Digital();
            System.out.println(type.getType());
            newProduct = new Product(productName, description, type, quantityAvailable, price, message, 0);
        }

        listOfProducts.add(newProduct);

        System.out.println("Add new product successfully!");
    }

}
