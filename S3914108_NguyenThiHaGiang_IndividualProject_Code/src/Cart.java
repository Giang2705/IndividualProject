/**
 * @author Nguyen Thi Ha Giang - S3914108
 */

import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;

public class Cart implements Comparable<Cart>{
    private String name;
    private ArrayList<String> listOfBoughtProducts = new ArrayList<String>();

    private double cartAmount;
    private double totalWeight;

    public Cart(){

    }

    public Cart(String name, ArrayList<String> listOfBoughtProducts){
        this.name = name;
        this.listOfBoughtProducts = listOfBoughtProducts;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setListOfBoughtProducts(ArrayList<String> listOfBoughtProducts){
        this.listOfBoughtProducts = listOfBoughtProducts;
    }

    public ArrayList<String> getListOfBoughtProducts() {
        return listOfBoughtProducts;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public boolean addItem (String productName) {
        if (this.listOfBoughtProducts.contains(productName)){
            return false;
        } else {
            this.listOfBoughtProducts.add(productName);
            return true;
        }
    }

    public boolean removeItem (String productName, ArrayList<Product> listOfProducts) {
        if (this.listOfBoughtProducts.contains(productName)){
            this.listOfBoughtProducts.remove(productName);
            this.calculateTotalWeight(listOfProducts);
            this.calculateCartAmount(listOfProducts);
            return true;
        }
        return false;
    }

    public double calculateTotalWeight (ArrayList<Product> listOfProducts){
        for (int i = 0; i < listOfBoughtProducts.size(); i++){
            for (int j = 0; j < listOfProducts.size(); j++){
                if (listOfBoughtProducts.get(i).equalsIgnoreCase(listOfProducts.get(j).getProductName())){
                    this.totalWeight += listOfProducts.get(j).getWeight();
                }
            }
        }

        return this.totalWeight;
    }

    public double calculateCartAmount(ArrayList<Product> listOfProducts){
        double total = 0;

        for (int i = 0; i < listOfBoughtProducts.size(); i++){
            for (int j = 0; j < listOfProducts.size(); j++){
                if (listOfBoughtProducts.get(i).equalsIgnoreCase(listOfProducts.get(j).getProductName())){
                    total += listOfProducts.get(j).getPrice();
                }
            }
        }
        this.cartAmount = total + calculateTotalWeight(listOfProducts)*0.1;
        return this.cartAmount;
    }

    public String toString(ArrayList<Product> listOfProducts) {
        return String.format("Cart's name: %s - Total weight: %s - Total Amount: %s",
                this.name, this.calculateCartAmount(listOfProducts), this.cartAmount);
    }

    public ArrayList<Cart> sortedAscendingCarts (ArrayList<Cart> listOfCarts){
        Collections.sort(listOfCarts);
        return listOfCarts;
    }

    @Override
    public int compareTo(Cart c) {
        return Double.compare(this.totalWeight, c.getTotalWeight());
    }
}
