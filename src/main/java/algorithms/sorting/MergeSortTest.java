package algorithms.sorting;


import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class MergeSortTest {

    private int [] unsorted;
    private static final int UNSORTED_SIZE = 555;
    private static final int MAX_BOUND = 1500;

    @Before
    public void setupUnsortedArray() {
        unsorted = new int[UNSORTED_SIZE];
        Random rand = new Random();
        for (int i=0; i < UNSORTED_SIZE; i++) {
            unsorted[i] = rand.nextInt(MAX_BOUND);
        }
        System.out.println("Unsorted: "+Arrays.toString(unsorted));
    }

    @Test
    public void testMergeSort() {
        long startTime = System.currentTimeMillis();

        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(unsorted);

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Sorted: " + Arrays.toString(unsorted));
        System.out.println("MergeSort time: " + elapsedTime+" ms");

        for(int i=0; i < unsorted.length-1; i++){
            if(unsorted[i] > unsorted[i+1]){
                fail();
            }
        }
        assertTrue(true);
    }

}
