package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PackTest {
    
    @Test
    public void testCreateState() {
        PackState state;
        state  = new InTransit();
        assertEquals(state.tellState(), "in transit");

        state = new Delivered();
        assertEquals(state.tellState(), "delievred");
    }

    @Test
    public void testStateSetPack() {
        PackState state;
        Pack pack;

        state  = new InTransit();
        pack = new Pack("book", 300, state);
        state.setPack(pack);
        assertEquals(state.getPack(), pack);

        state = new Delivered();
        pack = new Pack("book", 300, state);
        state.setPack(pack);
        state.deliver();
        assertEquals(state.getPack(), pack);
    }

    @Test
    public void testStateDeliver() {
        PackState state;
        Pack pack;

        state  = new InTransit();
        pack = new Pack("book", 300, state);
        state.setPack(pack);
        state.deliver();
        assertEquals(state.tellState(), "delivered");

        state = new Delivered();
        pack = new Pack("book", 300, state);
        state.setPack(pack);
        state.deliver();
        assertEquals(state.tellState(), "delivered");
    }

    @Test
    public void testCreatePack() {
        PackState state = new InTransit();
        Pack pack = new Pack("paper", 100, state);
        assertEquals(pack.tellState(), "in transit");
        assertEquals(pack.getName(), "paper");
        assertEquals(pack.getWeight(), 100);

        state = new Delivered();
        pack = new Pack("book", 300, state);
        assertEquals(pack.tellState(), "delivered");
        assertEquals(pack.getName(), "book");
        assertEquals(pack.getWeight(), 300);
    }

    @Test
    public void testPackChangeState() {
        PackState inTransit = new InTransit();
        PackState delievred = new Delivered();
        Pack pack = new Pack("paper", 100, inTransit);
        pack.changeState(delievred);
        assertEquals(pack.tellState(), "delivered");
        pack.changeState(inTransit);
        assertEquals(pack.tellState(), "in transit");
    }

    @Test
    public void testPackDeliver() {
        PackState state;
        Pack pack;

        state  = new InTransit();
        pack = new Pack("book", 300, state);
        state.setPack(pack);
        pack.deliver();
        assertEquals(pack.tellState(), "delivered");

        state = new Delivered();
        pack = new Pack("book", 300, state);
        state.setPack(pack);
        pack.deliver();
        assertEquals(pack.tellState(), "delivered");
    }


}
