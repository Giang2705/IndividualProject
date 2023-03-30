/**
 * @author Nguyen Thi Ha Giang - S3914108
 */
public class AddedProduct extends Product{

    private int amount;
    private double totalPrice;
    private double totalWeight;
    private double shippingFee;


    public AddedProduct() {

    }
    public AddedProduct(int amount, double totalPrice, double totalWeight, double shippingFee) {
        this.amount = amount;
        this.totalPrice = totalPrice;
        this.totalWeight = totalWeight;
        this.shippingFee = shippingFee;
    }

    public AddedProduct(String productName, String description, Type type, int quantityAvailable, double price, String message, double weight, int amount, double totalPrice, double totalWeight, double shippingFee) {
        super(productName, description, type, quantityAvailable, price, message, weight);
        this.amount = amount;
        this.totalPrice = totalPrice;
        this.totalWeight = totalWeight;
        this.shippingFee = shippingFee;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight() {
        this.totalWeight = this.amount * this.getWeight();
    }

    public double getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(double shippingFee) {
        this.shippingFee = shippingFee;
    }

    public void calculateShippingFee(double totalWeight){
        this.shippingFee = totalWeight*0.1;
    }

}
