/**
 * @author Nguyen Thi Ha Giang - S3914108
 */
public class Physical extends Type{
    private double weight;

    public Physical(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Physical() {
        super();
    }

    @Override
    public void setType(String type) {
        super.setType(type);
    }

    @Override
    public String getType() {
        return super.getType();
    }
}
