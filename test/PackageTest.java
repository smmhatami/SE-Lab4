package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PackageTest {
    
    @Test
    public void testCreateState() {
        PackageState state;
        state  = new InTransit();
        assertEquals(state.tellState(), "in transit");

        state = new Delivered();
        assertEquals(state.tellState(), "delievred");
    }

    @Test
    public void testStateSetPackage() {
        PackageState state;
        Package package;

        state  = new InTransit();
        package = new Package("book", 300, state);
        state.setPackage(package);
        assertEquals(state.getPackage(), package);

        state = new Delivered();
        package = new Package("book", 300, state);
        state.setPackage(package);
        state.deliver();
        assertEquals(state.getPackage(), package);
    }

    @Test
    public void testStateDeliver() {
        PackageState state;
        Package package;

        state  = new InTransit();
        package = new Package("book", 300, state);
        state.setPackage(package);
        state.deliver();
        assertEquals(state.tellState(), "delivered");

        state = new Delivered();
        package = new Package("book", 300, state);
        state.setPackage(package);
        state.deliver();
        assertEquals(state.tellState(), "delivered");
    }
}
