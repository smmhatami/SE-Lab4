package Model;

public class Shipping {

    private Pack pack;
    private ShippingPlan plan;

    public Shipping(Pack pack, ShippingPlan plan) {
        this.pack = pack;
        this.plan = plan;
    }

    public ShippingPlan getPlan() {
        return plan;
    }

    public Pack getPack() {
        return pack;
    }

    public void setPlan(ShippingPlan plan) {
        this.plan = plan;
    }

    public int calcPrice() {
        return (int) plan.calcPrice(pack.getWeight());
    }
}
