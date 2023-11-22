package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class ShippingTest {
    
    @Test
    public void testCreatePlan() {
        ShippingPlan plan;
        plan = new StandardPlan();
        assertEquals(plan.calcPrice(100), 250);
        assertEquals(plan.calcPrice(300), 750);
        assertEquals(plan.calcPrice(1), 2.5);
        assertEquals(plan.calcPrice(10), 25);
        assertEquals(plan.calcPrice(1.5), 3.75);

        plan = new ExpressPlan();
        assertEquals(plan.calcPrice(100), 350);
        assertEquals(plan.calcPrice(300), 1225);
        assertEquals(plan.calcPrice(1), 3.5);
        assertEquals(plan.calcPrice(10), 35);
        assertEquals(plan.calcPrice(1.5), 5.25);
    }

}