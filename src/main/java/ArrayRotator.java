import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertArrayEquals;

public class ArrayRotator {

    public Object[] rotate(Object[] data, int n) {
        Collections.rotate(Arrays.asList(data), n);
        return data;
    }

    public Object[] rotate2(Object[] data, int n) {
        Object [] rotatedArray = new Object[0];
        if(n < 0) {
            rotatedArray = rotatedLeft(data, Math.abs(n));
        } else if (n > 0) {
            rotatedArray = rotatedRight(data, n);
        } else {
            return data;
        }
        return rotatedArray;
    }

    private Object [] rotatedRight(Object [] input, int n) {
        Object [] newArray = new Object[input.length];
        for(int i=0; i < input.length; i++) {
            int newI = (i+n) % input.length;
            newArray[newI] = input[i];
        }
        return newArray;
    }

    private Object [] rotatedLeft(Object [] input, int n) {
        Object [] newArray = new Object[input.length];
        for(int i=input.length-1; i >= 0; i--) {
            if(n > input.length) n = n / input.length;
            int newI;
            if(i - n >= 0)
                newI = (i-n) % input.length;
            else
                newI = (input.length - Math.abs(i-n)) % input.length;

            newArray[newI] = input[i];
        }
        return newArray;
    }

    private ArrayRotator rotator;

    @Before
    public void setUp() {
        this.rotator = new ArrayRotator();
    }

    @After
    public void tearDown() {
        this.rotator = null;
    }

    @Test
    public void testRotateOne_ArrayOfFive() {
        assertArrayEquals(new Object[]{5, 1, 2, 3, 4},
                rotator.rotate(new Object[]{1, 2, 3, 4, 5}, 1));
    }

    @Test
    public void testRotateTwo_ArrayOfFive() {
        assertArrayEquals(new Object[]{4, 5, 1, 2, 3},
                rotator.rotate(new Object[]{1, 2, 3, 4, 5}, 2));
    }

    @Test
    public void testRotateThree_ArrayOfFive() {
        assertArrayEquals(new Object[]{3, 4, 5, 1, 2},
                rotator.rotate(new Object[]{1, 2, 3, 4, 5}, 3));
    }

    @Test
    public void testRotateFour_ArrayOfFive() {
        assertArrayEquals(new Object[]{2, 3, 4, 5, 1},
                rotator.rotate(new Object[]{1, 2, 3, 4, 5}, 4));
    }

    @Test
    public void testRotateFive_ArrayOfFive() {
        assertArrayEquals(new Object[]{1, 2, 3, 4, 5},
                rotator.rotate(new Object[]{1, 2, 3, 4, 5}, 5));
    }

    @Test
    public void testRotateSix_ArrayOfFive() {
        assertArrayEquals(new Object[]{5, 1, 2, 3, 4},
                rotator.rotate(new Object[]{1, 2, 3, 4, 5}, 6));
    }

    @Test
    public void testRotateNegOne_ArrayOfFive() {
        assertArrayEquals(new Object[]{2, 3, 4, 5, 1},
                rotator.rotate(new Object[]{1, 2, 3, 4, 5}, -1));
    }

    @Test
    public void testRotateNegTwo_ArrayOfFive() {
        assertArrayEquals(new Object[]{3, 4, 5, 1, 2},
                rotator.rotate(new Object[]{1, 2, 3, 4, 5}, -2));
    }

    @Test
    public void testRotateNegThree_ArrayOfFive() {
        assertArrayEquals(new Object[]{4, 5, 1, 2, 3},
                rotator.rotate(new Object[]{1, 2, 3, 4, 5}, -3));
    }

    @Test
    public void testRotateNegFour_ArrayOfFive() {
        assertArrayEquals(new Object[]{5, 1, 2, 3, 4},
                rotator.rotate(new Object[]{1, 2, 3, 4, 5}, -4));
    }

    @Test
    public void testRotateNegFive_ArrayOfFive() {
        assertArrayEquals(new Object[]{1, 2, 3, 4, 5},
                rotator.rotate(new Object[]{1, 2, 3, 4, 5}, -5));
    }

    @Test
    public void testRotateNegSix_ArrayOfFive() {
        assertArrayEquals(new Object[]{2, 3, 4, 5, 1},
                rotator.rotate(new Object[]{1, 2, 3, 4, 5}, -6));
    }

}
