import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Nguyen Thi Ha Giang - S3914108
 */
public class Cart {
    private User user;
    private ArrayList<AddedProduct> listOfAddedProducts;
    private String message;
    private double total;

    public Cart() {

    }

    public Cart(User user, ArrayList<AddedProduct> listOfAddedProducts, String message, double total) {
        this.user = user;
        this.listOfAddedProducts = listOfAddedProducts;
        this.message = message;
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<AddedProduct> getListOfAddedProducts() {
        return listOfAddedProducts;
    }

    public void setListOfAddedProducts(ArrayList<AddedProduct> listOfAddedProducts) {
        this.listOfAddedProducts = listOfAddedProducts;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getTotal(){
        return total;
    }

    public void setTotal(double total){
        this.total = total;
    }

    public boolean addItem (String productName){
        for (int i = 0; i < this.listOfAddedProducts.size(); i++){
            if (productName.equalsIgnoreCase(this.listOfAddedProducts.get(i).getProductName())){
                System.out.print("This product has been already added. Do you want change the amount? (y or n): ");
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("y")){
                    System.out.println("The amount has been added: " + this.listOfAddedProducts.get(i).getAmount());
                    System.out.println("Please input new amount: ");
                    int amount = scanner.nextInt();
                    this.listOfAddedProducts.get(i).setAmount(amount);
                    this.calculateTotal();

                    System.out.println("The amount has been changed!");
                } else {
                    System.out.println("Going back to user home...");
                }
                return false;
            }
        }

        AddedProduct addedProduct = new AddedProduct();
        System.out.println("Please input amount of product you want to buy: ");
        int amount = new Scanner(System.in).nextInt();
        addedProduct.setAmount(amount);
        addedProduct.calculateShippingFee(addedProduct.getTotalWeight());

        listOfAddedProducts.add(addedProduct);
        System.out.println("Product has been added into cart successfully!");
        return true;
    }

    public void calculateTotal(){
        for (int i = 0; i < this.listOfAddedProducts.size(); i++){
            this.total += this.listOfAddedProducts.get(i).getTotalPrice() + this.listOfAddedProducts.get(i).getShippingFee();
        }
    }
}
