import java.lang.reflect.Field;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.PropertyPermission;
import java.util.Scanner;

/**
 * @author Nguyen Thi Ha Giang - S3914108
 */

public class Main {
    public static void userHomeMenu(ArrayList<Product> listOfProducts) throws IllegalAccessException {
        boolean isContinue = true;

        while (isContinue){
            System.out.println("                         Welcome to online shopping application                                  ");
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println("| 1. Browse products.                                                                           |");
            System.out.println("| 2. Search product.                                                                            |");
            System.out.println("| 3. View product.                                                                              |");
            System.out.println("| 4. View cart.                                                                                 |");
            System.out.println("| 5. Log in as an admin.                                                                        |");
            System.out.println("| 6. Exit                                                                                       |");
            System.out.println("-------------------------------------------------------------------------------------------------");

            System.out.print("What do you want to do? Please insert a number from 1 to 6 in the menu above: ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            switch (input){
                case "1":

                    break;
                case "2":
                    searchProduct(listOfProducts);
                    break;
                case "3":
                    displayProducts(listOfProducts);
                    viewProduct(false, listOfProducts);
                    break;
                case "4":
                    break;
                case "5":
                    System.out.print("Username: ");
                    String username = new Scanner(System.in).nextLine();
                    System.out.print("Password: ");
                    String password = new Scanner(System.in).nextLine();

                    Admin admin = new Admin();
                    if (admin.adminLogin(username, password)){
                        adminHomeMenu(admin, listOfProducts);
                    }
                    break;
                case "6":
                    System.out.println("Thank you for joining our system!");
                    isContinue = false;
                    break;
            }
        }
    }

    public static void adminHomeMenu(Admin admin, ArrayList<Product> listOfProducts) throws IllegalAccessException {
        boolean isContinue = true;

        while (isContinue){
            System.out.println("                                        Welcome Admin                                            ");
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println("| 1. Browse products.                                                                           |");
            System.out.println("| 2. Search product.                                                                            |");
            System.out.println("| 3. View product.                                                                              |");
            System.out.println("| 4. Add product.                                                                               |");
            System.out.println("| 5. Log out.                                                                                   |");
            System.out.println("-------------------------------------------------------------------------------------------------");

            System.out.print("What do you want to do? Please insert a number from 1 to 5 in the menu above: ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            switch (input){
                case "1":
                    displayProducts(listOfProducts);
                    break;
                case "2":
                    searchProduct(listOfProducts);
                    break;
                case "3":
                    displayProducts(listOfProducts);
                    viewProduct(admin.isAdmin(), listOfProducts);
                    break;
                case "4":
                    System.out.print("Input product's name: ");
                    String productName = scanner.nextLine();

                    System.out.print("Input product's description: ");
                    String description = scanner.nextLine();

                    System.out.print("Input product's type (Physical or Digital): ");
                    String typeName = scanner.nextLine();

                    System.out.print("Input quantity available: ");
                    int quantity = scanner.nextInt();

                    System.out.print("Input product's price: ");
                    double price = scanner.nextDouble();

                    admin.addNewProduct(productName, description, typeName, quantity, price, listOfProducts);
                    break;
                case "5":
                    System.out.println("Going back to main menu...");
                    isContinue = false;
                    break;
            }
        }
    }

    public static void searchProduct(ArrayList<Product> listOfProducts) {
        if (listOfProducts.size() == 0) {
            System.out.println("There is no product exists.");
        } else {
            Scanner scanner = new Scanner(System.in);
            ArrayList<Product> foundedProducts = new ArrayList<Product>();
            System.out.print("Input product's name: ");
            String name = scanner.nextLine();

            for (int i = 0; i < listOfProducts.size(); i++){
                if (listOfProducts.get(i).getProductName().toLowerCase().contains(name.toLowerCase())){
                    foundedProducts.add(listOfProducts.get(i));
                }
            }

            System.out.println("Product(s) which contains the searched words: ");
            if (foundedProducts.size() == 0) {
                System.out.println("There is no product which contains these words, please try again!");
            } else {
                for (int i = 0; i < foundedProducts.size(); i++){
                    System.out.println(i+1 + ". " + foundedProducts.get(i).getType().getType().toUpperCase() + " - " + foundedProducts.get(i).getProductName());
                }
            }
        }
    }
    public static void displayProducts(ArrayList<Product> listOfProducts) {
        if (listOfProducts.size() == 0) {
            System.out.println("There is no product exists.");
        } else {
            System.out.println("List of products");
            for (int i = 0; i < listOfProducts.size(); i++){
                System.out.println(i+1 + ". " + listOfProducts.get(i).getType().getType().toUpperCase() + " - " + listOfProducts.get(i).getProductName());
            }
        }
    }
    public static void viewProduct(boolean isAdmin, ArrayList<Product> listOfProducts){
        if (listOfProducts.size() > 0){
            Scanner scanner = new Scanner(System.in);
            Product foundedProduct = new Product();
            System.out.print("Input product's name: ");
            String name = scanner.nextLine();

            for (int i = 0; i < listOfProducts.size(); i++){
                if (name.equalsIgnoreCase(listOfProducts.get(i).getProductName())){
                    foundedProduct = listOfProducts.get(i);
                }
            }

            if (foundedProduct == null){
                System.out.println("No product founded. Please try again!");
            } else {
                Admin admin = new Admin();
                if (isAdmin){
                    foundedProduct.displayProduct(isAdmin, foundedProduct, listOfProducts, admin);
                } else  {
                    foundedProduct.displayProduct(isAdmin, foundedProduct, listOfProducts, null);
                }
            }
        }
    }

    public static void main(String[] args) throws IllegalAccessException {
        ArrayList<Product> listOfProducts = new ArrayList<Product>();
        userHomeMenu(listOfProducts);
    }
}