package patterns.creator.singleton;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SingletonTest {

    @Test
    public void singletonInstanceTest() {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        Singleton instance3 = Singleton.getInstance();
        assertTrue(instance1.equals(instance2));
        assertTrue(instance2.equals(instance3));
        assertTrue(instance1.equals(instance3));
    }
}
