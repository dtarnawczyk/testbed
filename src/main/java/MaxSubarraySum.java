import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class MaxSubarraySum {
    public static int sequence(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int rangeSum = IntStream.rangeClosed(i, j).map(a -> arr[a]).sum();
                if(rangeSum > max) {
                    max = rangeSum;
                }
            }
        }
        return max;
    }

    @Test
    public void testEmptyArray() throws Exception {
        assertEquals("Empty arrays should have a max of 0", 0, MaxSubarraySum.sequence(new int[]{}));
    }
    @Test
    public void testExampleArray() throws Exception {
        assertEquals("Example array should have a max of 6", 6, MaxSubarraySum.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
