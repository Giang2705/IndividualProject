import java.lang.reflect.Field;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Nguyen Thi Ha Giang - S3914108
 */

public class Main {
    public static void mainMenu() {
        System.out.println("---------------------------------------- Online Shopping ----------------------------------------");
        System.out.println("| 1. Don't have an account? Register.                                                           |");
        System.out.println("| 2. Login (Already had an account).                                                            |");
        System.out.println("| 3. Exit.                                                                                      |");
        System.out.println("-------------------------------------------------------------------------------------------------");
    }

    public static void userHomeMenu(User user, ArrayList<Product> listOfProducts) {
        boolean isContinue = true;

        while (isContinue){
            System.out.println("                                Welcome " + user.getUsername()                                    );
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println("| 1. Browse products.                                                                           |");
            System.out.println("| 2. Search product.                                                                            |");
            System.out.println("| 3. View product.                                                                              |");
            System.out.println("| 4. View cart.                                                                                 |");
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
                    searchProduct(user, listOfProducts);
                    break;
                case "3":
                    displayProducts(listOfProducts);
                    viewProduct(user, listOfProducts);
                    break;
                case "4":
                    break;
                case "5":
                    System.out.println("Going back to main menu...");
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

            System.out.print("What do you want to do? Please insert a number from 1 to 6 in the menu above: ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            switch (input){
                case "1":
                    displayProducts(listOfProducts);
                    break;
                case "2":
                    searchProduct(admin, listOfProducts);
                    break;
                case "3":
                    displayProducts(listOfProducts);
                    viewProduct(admin, listOfProducts);
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

                    String message = null;
                    System.out.print("Can it be a gift? (y or n): ");
                    String ans = scanner.next();

                    if(ans.equalsIgnoreCase("y")){
                        System.out.print("Input message: ");
                        message = new Scanner(System.in).nextLine();
                    }

                    admin.addNewProduct(productName, description, typeName, quantity, price, message, listOfProducts);
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
    public static void viewProduct(Admin user, ArrayList<Product> listOfProducts){
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
                foundedProduct.displayProduct(user, foundedProduct, listOfProducts);
            }
        }
    }

    public static void main(String[] args) throws IllegalAccessException {
        ArrayList<User> listOfUsers = new ArrayList<User>();
        ArrayList<Product> listOfProducts = new ArrayList<Product>();
        Admin admin = new Admin();

        Scanner scanner = new Scanner(System.in);
        boolean isContinue = true;

        while (isContinue){
            mainMenu();
            System.out.print("Please choose 1 of 3 options above (input a number 1, 2 or 3): ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    User user = new User();

                    System.out.print("Please input username: ");
                    String username = scanner.nextLine();

                    user.register(username, listOfUsers);

                    break;
                case "2":
                    User logInUser = new User();

                    System.out.print("Username: ");
                    String name = scanner.nextLine();
                    System.out.print("Password: ");
                    String password = scanner.nextLine();

                    if(logInUser.isLogedIn(name, password, listOfUsers) && !admin.adminLogin(name, password)){
                        logInUser.setUsername(name);
                        logInUser.setPassword(password);
                        userHomeMenu(logInUser, listOfProducts);
                    } else if (admin.adminLogin(name, password)) {
                        adminHomeMenu(admin, listOfUsers, listOfProducts);
                    }

                    break;
                case "3":
                    System.out.println("Thank you for joining our system!");
                    isContinue = false;
                    break;
            }
        }
    }
}