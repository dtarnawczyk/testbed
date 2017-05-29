import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Pizza {

    public static int  maxPizza(int cut) {
        return cut < 0 ? -1 : (cut * (cut+1)/2) + 1 ;
    }

    @Test
    public void testNegative() {
        assertEquals(-1,Pizza.maxPizza(-2));
    }

    @Test
    public void testZero() {
        assertEquals(1,Pizza.maxPizza(0));
    }

    @Test
    public void test3() {
        assertEquals(7,Pizza.maxPizza(3));
    }
}
