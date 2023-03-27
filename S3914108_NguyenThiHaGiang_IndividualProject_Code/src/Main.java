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

    public static void userHomeMenu(User user) {
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
                    break;
                case "2":
                    break;
                case "3":
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

    public static void adminHomeMenu(ArrayList<User> listOfUsers) {
        boolean isContinue = true;

        while (isContinue){
            System.out.println("                                        Welcome Admin                                            ");
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println("| 1. Browse products.                                                                           |");
            System.out.println("| 2. Search product.                                                                            |");
            System.out.println("| 3. View product.                                                                              |");
            System.out.println("| 4. Add product.                                                                               |");
            System.out.println("| 5. View users                                                                                 |");
            System.out.println("| 6. Log out.                                                                                   |");
            System.out.println("-------------------------------------------------------------------------------------------------");

            System.out.print("What do you want to do? Please insert a number from 1 to 6 in the menu above: ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            switch (input){
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    if (listOfUsers == null){
                        System.out.println("There is no user exits.");
                    } else {
                        System.out.println("List of users: ");
                        for (int i = 0; i < listOfUsers.size(); i++){
                            System.out.println((i + 1) + ". " + listOfUsers.get(i).getUsername());
                        }
                    }
                    break;
                case "6":
                    System.out.println("Going back to main menu...");
                    isContinue = false;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<User> listOfUsers = new ArrayList<User>();
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
                        userHomeMenu(logInUser);
                    } else if (admin.adminLogin(name, password)) {
                        adminHomeMenu(listOfUsers);
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