package algorithms.sorting;

import java.util.Arrays;

/**
 * Insertion sort - sortowanie przez wstawianie. Polega na wybieraniu po kolei elementow ze zbioru i
 * porównywanie ich z elementami już posortowanymi. Jego złożoność obliczeniowa to O(n^2)
 */
public class InsertionSort implements Sort {

    public static void main(String[] args) {
        int[] unsorted = {9, 3, 5, 1, 6, 2, 4, 7, 8};
        InsertionSort insertionSort = new InsertionSort();
        System.out.println("Sorted: " + Arrays.toString(insertionSort.sort(unsorted)));
    }


    @Override
    public int[] sort(int[] input) {
        int temp;
        for (int i = 1; i < input.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(input[j] < input[j-1]){
                    temp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = temp;
                }
            }
        }
        return input;
    }

}
