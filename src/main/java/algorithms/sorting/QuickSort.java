package algorithms.sorting;

import java.util.Arrays;

/**
 * Quick Sort - sortowanie przez scalanie. Algorym sortowania opierający się o zasadę dziel i zwyciężaj.
 * (Divide and conquer). Złożoność obliczeniowa, w zależności od rozkładu to od O(n log n) do O (n^2)
 * Według ustalonego schematu wybierany jest jeden element w sortowanej tablicy, który będziemy nazywać pivot.
 * Pivot może być elementem środkowym, pierwszym, ostatnim, losowym lub wybranym według jakiegoś innego
 * schematu dostosowanego do zbioru danych. Następnie ustawiamy elementy nie większe na lewo tej wartości,
 * natomiast nie mniejsze na prawo. W ten sposób powstaną nam dwie części tablicy (niekoniecznie równe),
 * gdzie w pierwszej części znajdują się elementy nie większe od drugiej. Następnie każdą z tych podtablic
 * sortujemy osobno według tego samego schematu.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] unsorted = {9, 3, 5, 1, 6, 2, 4, 7, 8};
        QuickSort quickSort = new QuickSort();
        System.out.println("Sorted: " + Arrays.toString(quickSort.quicksort(unsorted)));
    }

    public int[] quicksort(int[] input) {

        sort(input, 0, input.length-1);

        return input;
    }

    public void sort(int[] input, int start, int end) {
        if(start < end) {
            int pivot = partition(input, start, end);
            sort(input, start, pivot-1);
            sort(input, pivot+1, end);
        }
    }

    private int partition(int [] input, int start, int end) {
        // Selecting pivot element
        int pivot = input[end];
        // Index of first element
        int index = start;
        for(int i=start; i <= end-1; i++) {
            if(input[i] <= pivot){
                swap(input, index, i);
                index += 1;
            }
        }
        swap(input, index, end);
        return index;
    }

    private void swap(int [] inputs, int i, int j) {
        int tmp = inputs[i];
        inputs[i] = inputs[j];
        inputs[j] = tmp;
    }
}