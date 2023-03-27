import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Nguyen Thi Ha Giang - S3914108
 */
public class Admin extends User{
//    Getter and Setter
    @Override
    public boolean isAdmin() {
        return true;
    }

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

    public void addNewProduct(String productName, String description, String typeName, int quantityAvailable, double price, String message, ArrayList<Product> listOfProducts) {
        Scanner scanner = new Scanner(System.in);
        Type type = new Type();
        type.setType(typeName);

        Physical physical = new Physical();
        Digital digital = new Digital();

        while (isExisted(productName, listOfProducts)) {
            System.out.print("This product is existed. Please input another name: ");
            productName = scanner.nextLine();
        }


        Product newProduct = new Product();

        if (type.getType().equalsIgnoreCase("physical")){
            System.out.print("Please set the weight for this product (kg): ");
            double input = scanner.nextDouble();
            physical.setWeight(input);
            physical.setType("physical");
            newProduct = new Product(productName, description, physical, quantityAvailable, price, message, physical.getWeight());
        } else {
            digital.setType("digital");
            newProduct = new Product(productName, description, digital, quantityAvailable, price, message, 0);
        }

        listOfProducts.add(newProduct);

        System.out.print("Add new product successfully!");
    }
}
