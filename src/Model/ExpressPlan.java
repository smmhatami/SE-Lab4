package Model;

public class ExpressPlan implements ShippingPlan {

    private int weight;
    @Override
    public int calcPrice(double weight) {
        return (int) (3.5*weight);
    }

    @Override
    public String toString() {
        return "Express";
    }
}
