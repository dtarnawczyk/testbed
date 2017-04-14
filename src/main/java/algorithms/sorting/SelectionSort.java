package algorithms.sorting;

import java.util.Arrays;
/**
 * Selction sort - sortowanie przez wybieranie. Polega na wyszukaniu najmniejszego elementu i
 * ustawieniu go na początkowej pozycji. Następnie wyszukanie kolejnego najmniejszego i
 * ustawienie na kolejnej po początkowej pozycji itd. Jego złożoność obliczeniowa to O(n^2)
 */
public class SelectionSort implements Sort{

    public static void main(String[] args) {
        int[] unsorted = {9, 3, 5, 1, 6, 2, 4, 7, 8};
        SelectionSort selectionSort = new SelectionSort();
        System.out.println("Sorted: " + Arrays.toString(selectionSort.sort(unsorted)));
    }

    @Override
    public int[] sort(int[] unsorted) {
        for(int j=0; j < unsorted.length; j++) {
            int minIndex = j;
            int selectedIdx = j;
            int minValue = unsorted[j];
            for (int i = minIndex + 1; i < unsorted.length; i++) {
                if (minValue > unsorted[i]) {
                    selectedIdx = i;
                    minValue = unsorted[i];
                }
            }
            int tmp = unsorted[minIndex];
            unsorted[minIndex] = unsorted[selectedIdx];
            unsorted[selectedIdx] = tmp;
        }
        return unsorted;
    }
}
