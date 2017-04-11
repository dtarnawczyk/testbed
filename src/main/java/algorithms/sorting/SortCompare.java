package algorithms.sorting;

import java.util.Random;

public class SortCompare {

    public static void main(String[] args) {
        int arraySize = 100;
        int maxBound = 2000;

        int [] unsorted = new int[arraySize];
        Random rand = new Random();
        for (int i=0; i < arraySize; i++) {
            unsorted[i] = rand.nextInt(maxBound);
        }

        long qstartTime = System.currentTimeMillis();
        QuickSort quickSort = new QuickSort();
        quickSort.quicksort(unsorted);
        long qstopTime = System.currentTimeMillis();
        long qelapsedTime = qstopTime - qstartTime;
        System.out.println("QuickSort time: " + qelapsedTime+" ms");

        long mstartTime = System.currentTimeMillis();
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(unsorted);

        long mstopTime = System.currentTimeMillis();
        long melapsedTime = mstopTime - mstartTime;
        System.out.println("MergeSort time: " + melapsedTime+" ms");
    }
}
