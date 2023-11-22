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

    @Test
    public void testCreatePackage() {
        PackageState state = new InTransit();
        Package package = new Package("paper", 100, state);
        assertEquals(package.tellState(), "in transit");
        assertEquals(package.getName(), "paper");
        assertEquals(package.getWeight(), 100);

        state = new Delivered();
        package = new Package("book", 300, state);
        assertEquals(package.tellState(), "delivered");
        assertEquals(package.getName(), "book");
        assertEquals(package.getWeight(), 300);
    }

    @Test
    public void testPackageChangeState() {
        PackageState inTransit = new InTransit();
        PackageState delievred = new Delivered();
        Package package = new Package("paper", 100, inTransit);
        package.changeState(delievred);
        assertEquals(package.tellState(), "delivered");
        package.changeState(inTransit);
        assertEquals(package.tellState(), "in transit");
    }

    @Test
    public void testPackageDeliver() {
        PackageState state;
        Package package;

        state  = new InTransit();
        package = new Package("book", 300, state);
        state.setPackage(package);
        package.deliver();
        assertEquals(package.tellState(), "delivered");

        state = new Delivered();
        package = new Package("book", 300, state);
        state.setPackage(package);
        package.deliver();
        assertEquals(package.tellState(), "delivered");
    }


}
