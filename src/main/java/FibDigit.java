import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class FibDigit {

    public static int lastFibDigit(int counter) {
        BigInteger first = BigInteger.ONE;
        BigInteger second = BigInteger.ONE;
        BigInteger next;
        for(int i=3; i <= counter; i++){
            next = first.add(second);
            first = second;
            second = next;
        }
        return second.mod(BigInteger.valueOf(10)).intValue();
    }

    @Test
    public void basicTests() {
        assertEquals("For n = 1", 1, FibDigit.lastFibDigit(1));
        assertEquals("For n = 21", 6, FibDigit.lastFibDigit(21));
        assertEquals("For n = 302", 1, FibDigit.lastFibDigit(302));
//        assertEquals("For n = 4003", 7, FibDigit.lastFibDigit2(4003));
//        assertEquals("For n = 50004", 8, FibDigit.lastFibDigit(50004));
//        assertEquals("For n = 600005", 5, FibDigit.lastFibDigit2(600005));
//        assertEquals("For n = 7000006", 3, FibDigit.lastFibDigit2(7000006));
//        assertEquals("For n = 80000007", 8, FibDigit.lastFibDigit(80000007));
//        assertEquals("For n = 900000008", 1, FibDigit.lastFibDigit(900000008));
//        assertEquals("For n = 1000000009", 9, FibDigit.lastFibDigit(1000000009));
    }
}
