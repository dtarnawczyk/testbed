import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SortTheOdd {

    public static int[] sortArray(int[] array) {

        boolean unsorted = true;

        while (unsorted) {
            unsorted = false;
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = i + 1; j < array.length; j++) {
                    if ((array[i] % 2 != 0) && (array[j] % 2 != 0)) {

                        if (array[i] > array[j]) {
                            int tmp = array[i];
                            array[i] = array[j];
                            array[j] = tmp;

                            unsorted = true;
                        }
                        break;
                    }
                }
            }
        }

        return array;
    }

    @Test
    public void exampleTest1() {
        assertArrayEquals(new int[]{ 1, 3, 2, 8, 5, 4 }, SortTheOdd.sortArray(new int[]{ 5, 3, 2, 8, 1, 4 }));
    }

    @Test
    public void exampleTest2() {
        assertArrayEquals(new int[]{ 1, 3, 5, 8, 0 }, SortTheOdd.sortArray(new int[]{ 5, 3, 1, 8, 0 }));
    }

    @Test
    public void exampleTest3() {
        assertArrayEquals(new int[]{}, SortTheOdd.sortArray(new int[]{}));
    }

}
