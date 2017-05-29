import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SequenceAndSeries {
    public static long getScore(long n) {
        long a = 50;
        long b = 0;
        for(long i = 1; i <= n; i++){
            b = b + a;
            a+=50;
        }
        return b;
    }

    @Test
    public void basicTests() {
        assertEquals("getScore(1) returns a wrong result", 50, SequenceAndSeries.getScore(1));
        assertEquals("getScore(2) returns a wrong result", 150, SequenceAndSeries.getScore(2));
        assertEquals("getScore(3) returns a wrong result", 300, SequenceAndSeries.getScore(3));
        assertEquals("getScore(4) returns a wrong result", 500, SequenceAndSeries.getScore(4));
        assertEquals("getScore(5) returns a wrong result", 750, SequenceAndSeries.getScore(5));
    }
}
