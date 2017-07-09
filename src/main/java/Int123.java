import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Int123 {

    public static long countB(final int a) {
        long b = 123 - a;
        return b >= 0 ? b : (Long.MIN_VALUE - (a - 123));

        // OR: return Integer.toUnsignedLong(123 - a);
    }

    private void doIntTest(final int a) {
        final long b = Int123.countB(a);
        System.out.println("" + a + " + " + b + " = " + (int)(a+b));
        assertTrue("B must be >= 0", b >= 0);
        assertEquals("A + B must give 123", 123, (int)(a+b));
    }

    @Test
    public void testLess() {
        doIntTest(0);
    }

    @Test
    public void testSame() {
        doIntTest(123);
    }

    @Test
    public void testGreater() {
        doIntTest(500);
    }

}
