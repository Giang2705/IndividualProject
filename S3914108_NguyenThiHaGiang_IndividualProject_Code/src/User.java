import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Nguyen Thi Ha Giang - S3914108
 */
public class User {
//    Attributes
    private String id;
    private String username;
    private String password;
    private Cart cart;
    private boolean isAdmin;

//    Constructor
    public User() {

    }

    public User(String id, String username, String password, Cart cart, boolean isAdmin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.cart = cart;
        this.isAdmin = isAdmin;
    }

//    Getter and Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

//    check if username is existed
    public boolean isExist(String name, ArrayList<User> listOfUsers){
        for (int i = 0; i < listOfUsers.size(); i++){
            if (name.equalsIgnoreCase(listOfUsers.get(i).getUsername())){
                return true;
            }
        }
        return false;
    }

//    check if password is correct
    public boolean isCorrect(String password, ArrayList<User> listOfUsers){
        for (int i = 0; i < listOfUsers.size(); i++){
            if (password.equalsIgnoreCase(listOfUsers.get(i).getPassword())){
                return true;
            }
        }
        return false;
    }

//    check if isAdmin
    public boolean checkAdmin(String username, String password) {
        Admin admin = new Admin();
        return admin.adminLogin(username, password);
    }

//    register method
    public void register(String username, ArrayList<User> listOfUsers) {
        Scanner scanner = new Scanner(System.in);

        while (isExist(username, listOfUsers)) {
            System.out.print("This account is existed. Please input another name: ");
            username = scanner.nextLine();
        }

        System.out.print("Please input password: ");
        String password = scanner.nextLine();

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);

        listOfUsers.add(newUser);

        System.out.print("Register successfully!");
    }

//    login method
    public boolean isLogedIn(String username, String password, ArrayList<User> listOfUsers) {
        if (checkAdmin(username, password)){
            System.out.println("Hello admin!");
            return true;
        } else if (!isExist(username, listOfUsers)){
            System.out.println("This account is not existed. Please try again!");
            return false;
        } else if (!isCorrect(password, listOfUsers)) {
            System.out.println("Password is not correct. Please try again!");
            return false;
        } else {
            User user = new User();
            for (int i = 0; i < listOfUsers.size(); i++){
                if (username.equalsIgnoreCase(listOfUsers.get(i).getUsername())){
                    user = listOfUsers.get(i);
                    break;
                }
            }

            System.out.println("Hello " + user.getUsername());
            return true;
        }
    }
}
