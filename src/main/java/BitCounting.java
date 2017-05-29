import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BitCounting {

    public static int countBits1(int n) {
        return Math.toIntExact(Integer.toBinaryString(n).chars().filter(c -> c == '1').count());
    }

    public static int countBits(int n) {
        return Integer.bitCount(n);
    }

    @Test
    public void testGame() {
        assertEquals(5, BitCounting.countBits(1234));
        assertEquals(1, BitCounting.countBits(4));
        assertEquals(3, BitCounting.countBits(7));
        assertEquals(2, BitCounting.countBits(9));
        assertEquals(2, BitCounting.countBits(10));
    }
}
