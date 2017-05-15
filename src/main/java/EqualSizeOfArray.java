import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class EqualSizeOfArray {

    public static int findEvenIndex(int [] input) {
        int size = input.length;
        if(size <=2 || size > 1000) return -1;
        for(int i=1; i < size; i++) {
            int leftSum = IntStream.range(0, i).map(n -> input[n]).sum();
            int rightSum = IntStream.range(i+1, size).map(n -> input[n]).sum();
            if(leftSum == rightSum) return i;
        }
        return -1;
    }

    @Test
    public void test() {
        assertEquals(3,EqualSizeOfArray.findEvenIndex(new int[] {1,2,3,4,3,2,1}));
        assertEquals(1,EqualSizeOfArray.findEvenIndex(new int[] {1,100,50,-51,1,1}));
        assertEquals(-1,EqualSizeOfArray.findEvenIndex(new int[] {1,2,3,4,5,6}));
        assertEquals(3,EqualSizeOfArray.findEvenIndex(new int[] {20,10,30,10,10,15,35}));
        assertEquals(-1,EqualSizeOfArray.findEvenIndex(new int[] {-8505, -5130, 1926, -9026}));
        assertEquals(1,EqualSizeOfArray.findEvenIndex(new int[] {2824, 1774, -1490, -9084, -9696, 23094}));
        assertEquals(6,EqualSizeOfArray.findEvenIndex(new int[] {4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4}));
    }
}
