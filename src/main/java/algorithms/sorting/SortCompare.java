package algorithms.sorting;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

public class SortCompare {

    public static void main(String[] args) {
        int arraySize = 100000;
        int maxBound = 200000;

        int [] unsorted = new int[arraySize];
        Random rand = new Random();
        for (int i=0; i < arraySize; i++) {
            unsorted[i] = rand.nextInt(maxBound);
        }
        System.out.println("Insertion sort time: " + measureSort(new InsertionSort(), unsorted)+" ms");
        System.out.println("Selection sort time: " + measureSort(new SelectionSort(), unsorted)+" ms");
        System.out.println("Quick sort time: " + measureSort(new QuickSort(), unsorted)+" ms");
        System.out.println("Merge sort time: " + measureSort(new MergeSort(), unsorted)+" ms");
        System.out.println("Bubble sort time: " + measureSort(new BubbleSort(), unsorted)+" ms");
    }

    public static long measureSort(Sort sortType, int [] input) {
        Instant start = Instant.now();
        Sort sort = sortType;
        sort.sort(Arrays.copyOf(input, input.length));
        Instant end = Instant.now();
        return Duration.between(start,end).toMillis();
    }
}
