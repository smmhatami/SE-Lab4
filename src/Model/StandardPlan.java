package Model;

public class StandardPlan implements ShippingPlan {

    private int weight;

    @Override
    public int calcPrice(double weight) {
        return (int) (2.5*weight);
    }

    @Override
    public String toString() {
        return "Standard";
    }
}
