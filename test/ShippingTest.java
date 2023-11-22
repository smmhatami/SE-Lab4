import static org.junit.Assert.assertEquals;

import Model.*;
import org.junit.Test;


public class ShippingTest {
    
    @Test
    public void testCreatePlan() {
        ShippingPlan plan;
        plan = new StandardPlan();
        assertEquals(plan.calcPrice(100), 250);
        assertEquals(plan.calcPrice(300), 750);
        assertEquals(plan.calcPrice(2), 5);
        assertEquals(plan.calcPrice(10), 25);
        assertEquals(plan.calcPrice(10), 25);

        plan = new ExpressPlan();
        assertEquals(plan.calcPrice(100), 350);
        assertEquals(plan.calcPrice(300), 1050);
        assertEquals(plan.calcPrice(10), 35);
        assertEquals(plan.calcPrice(20), 70);
        assertEquals(plan.calcPrice(40), 140);
    }


    @Test
    public void testCreateShipping() {
        PackState state;
        Pack pack;
        ShippingPlan plan;
        Shipping shipping;
        state = new InTransit();
        pack = new Pack("book", 300, state);
        plan = new StandardPlan();
        shipping = new Shipping(pack, plan);
        assertEquals(shipping.getPlan(), plan);
        assertEquals(shipping.getPack(), pack);
    }


    @Test
    public void testShippingSetPlan() {
        PackState state;
        Pack pack;
        ShippingPlan plan;
        Shipping shipping;
        state = new InTransit();
        pack = new Pack("book", 300, state);
        plan = new StandardPlan();
        shipping = new Shipping(pack, plan);
        plan = new ExpressPlan();
        shipping.setPlan(plan);
        assertEquals(shipping.getPlan(), plan);
    }


    @Test
    public void testShippingCalcPrice() {
        PackState state;
        Pack pack;
        ShippingPlan plan;
        Shipping shipping;
        state = new InTransit();
        pack = new Pack("book", 300, state);
        plan = new StandardPlan();
        shipping = new Shipping(pack, plan);
        assertEquals(shipping.calcPrice(), 750);
        plan = new ExpressPlan();
        shipping.setPlan(plan);
        assertEquals(shipping.calcPrice(), 1050);
    }

}