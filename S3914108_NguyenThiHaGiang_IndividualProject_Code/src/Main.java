/**
 * @author Nguyen Thi Ha Giang - S3914108
 */

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void userHomeMenu(ArrayList<Product> listOfProducts, ArrayList<Cart> listOfCarts) throws IllegalAccessException {
        boolean isContinue = true;

        while (isContinue){
            System.out.println("                         Welcome to online shopping application                                  ");
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println("| 1. Browse products.                                                                           |");
            System.out.println("| 2. Search product.                                                                            |");
            System.out.println("| 3. View product.                                                                              |");
            System.out.println("| 4. Create new cart.                                                                           |");
            System.out.println("| 5. View cart.                                                                                 |");
            System.out.println("| 6. Log in as an admin.                                                                        |");
            System.out.println("| 7. Exit                                                                                       |");
            System.out.println("-------------------------------------------------------------------------------------------------");

            System.out.print("What do you want to do? Please insert a number from 1 to 6 in the menu above: ");
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
                    viewProduct(false, listOfProducts, listOfCarts);
                    break;
                case "4":
                    System.out.print("Please input name for new cart: ");
                    String cartName = scanner.nextLine();

                    Cart cart = new Cart();
                    cart.setName(cartName);

                    listOfCarts.add(cart);
                    System.out.println("Create cart successfully!");
                    break;
                case "5":
                    ArrayList<Cart> sortedList;
                    sortedList = new Cart().sortedAscendingCarts(listOfCarts);

                    System.out.println("List of carts:");
                    if (sortedList.size() == 0){
                        System.out.println("There is no cart.");
                    } else {
                        boolean existed = true;

                        for (int i = 0; i < sortedList.size(); i++) {
                            System.out.println(i+1 + ". " + sortedList.get(i).toString(listOfProducts));
                        }
                        System.out.print("Input the name of a cart that you want to see details: ");
                        String c = scanner.nextLine();

                        for (int i = 0; i < sortedList.size(); i++) {
                            if (c.equalsIgnoreCase(sortedList.get(i).getName())){
                                if (sortedList.get(i).getListOfBoughtProducts().size() == 0) {
                                    System.out.println("There is no product in cart.");
                                } else {
                                    for (int j = 0; j < sortedList.get(i).getListOfBoughtProducts().size(); j++){
                                        for (int k = 0; k < listOfProducts.size(); k++){
                                            if (sortedList.get(i).getListOfBoughtProducts().get(j).equalsIgnoreCase(listOfProducts.get(k).getProductName())){
                                                System.out.println(j+1 + ". " + toString(listOfProducts.get(k)));
                                            }
                                        }
                                    }
                                    System.out.println("Total price: " + sortedList.get(i).calculateCartAmount(listOfProducts));
                                    System.out.print("Do you want to remove product? (y/n): ");
                                    String ans = scanner.nextLine();
                                    while (!ans.equalsIgnoreCase("y") && !ans.equalsIgnoreCase("n")){
                                        System.out.print("Please input y/n: ");
                                        ans = scanner.nextLine();
                                    }
                                    switch (ans){
                                        case "y":
                                            System.out.print("Input name of product that you want to remove: ");
                                            String productName = scanner.nextLine();

                                            for (int j = 0; j < sortedList.get(i).getListOfBoughtProducts().size(); j++){
                                                if (productName.equalsIgnoreCase(sortedList.get(i).getListOfBoughtProducts().get(j))){
                                                    if (sortedList.get(i).removeItem(productName, listOfProducts)) {
                                                        for (int k = 0; k < listOfProducts.size(); k++){
                                                            if (productName.equalsIgnoreCase(listOfProducts.get(k).getProductName())){
                                                                listOfProducts.get(k).setQuantityAvailable(listOfProducts.get(k).getQuantityAvailable() + 1);
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    System.out.println("The product is not exist in this cart.");
                                                }
                                            }

                                            break;
                                        case "n":
                                            break;
                                    }

                                }
                                existed = true;
                            } else {
                                existed = false;
                            }
                        }

                        if (!existed){
                            System.out.println("There is no cart. Please try again.");
                        }
                    }

                    break;
                case "6":
                    System.out.print("Username: ");
                    String username = new Scanner(System.in).nextLine();
                    System.out.print("Password: ");
                    String password = new Scanner(System.in).nextLine();

                    Admin admin = new Admin();
                    if (admin.adminLogin(username, password)){
                        adminHomeMenu(admin, listOfProducts);
                    }
                    break;
                case "7":
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
                    viewProduct(admin.isAdmin(), listOfProducts, null);
                    break;
                case "4":
                    System.out.print("Input product's name: ");
                    String productName = scanner.nextLine();

                    System.out.print("Input product's description: ");
                    String description = scanner.nextLine();

                    System.out.print("Input product's type (Physical or Digital): ");
                    String typeName = scanner.nextLine();

                    System.out.print("Input quantity available: ");
                    String quantity = scanner.nextLine();
                    while (!isInteger(quantity)){
                        System.out.print("Please input integer number for quantity: ");
                        quantity = scanner.nextLine();
                    }

                    System.out.print("Input product's price: ");
                    String price = scanner.nextLine();
                    while (!isDouble(price)){
                        System.out.print("Please input double number for price: ");
                        price = scanner.nextLine();
                    }

                    admin.addNewProduct(productName, description, typeName, Integer.parseInt(quantity), Double.parseDouble(price), listOfProducts);
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
    public static void viewProduct(boolean isAdmin, ArrayList<Product> listOfProducts, ArrayList<Cart> listOfCarts){
        if (listOfProducts.size() > 0){
            Scanner scanner = new Scanner(System.in);
            Product foundedProduct = new Product();
            System.out.print("Input product's name: ");
            String name = scanner.nextLine();

            for (int i = 0; i < listOfProducts.size(); i++){
                if (name.equalsIgnoreCase(listOfProducts.get(i).getProductName())){
                    foundedProduct = listOfProducts.get(i);
                } else foundedProduct = null;
            }

            if (foundedProduct == null){
                System.out.println("No product founded. Please try again!");
            } else {
                Admin admin = new Admin();
                if (isAdmin){
                    foundedProduct.displayProduct(isAdmin, foundedProduct, listOfProducts, admin, null);
                } else  {
                    foundedProduct.displayProduct(isAdmin, foundedProduct, listOfProducts, null, listOfCarts);
                }
            }
        }
    }

    public static String toString(Product product) {
        return String.format("Product's name: %s - Type: %s, Price: %s - Weight: %s - Message: %s - Shipping Fee: %s",
                product.getProductName(), product.getType().getType(), product.getPrice(), product.getWeight(), product.getMessage(), product.getShippingFee());
    }

    public static boolean isInteger(String string) {
        if (string == null) {
            return false;
        }

        try {
            int i = Integer.parseInt(string);
        } catch (NumberFormatException nfe) {
                return false;
        }

        return true;
    }

    public static boolean isDouble(String string) {
        if (string == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(string);
        } catch (NumberFormatException nfe) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) throws IllegalAccessException {
        ArrayList<Product> listOfProducts = new ArrayList<Product>();
        ArrayList<Cart> listOfCarts = new ArrayList<Cart>();
        userHomeMenu(listOfProducts, listOfCarts);
    }
}