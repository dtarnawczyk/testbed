package algorithms.sorting;

import java.util.Arrays;

/**
 * Merge Sort - sortowanie przez scalanie. Rekurencyjny algorym sortowania opierający się o zasadę dziel i zwyciężaj
 * (Divide and conquer). Złożoność obliczeniowa O(n log n) Kroki:
 * 1. Podziel zbiór na dwie równe części.
 * 2. Zastosuj sortowanie przez scalanie dla każdej z części odzielnie, chyba że pozostał już tylko jeden element.
 * 3. Połącz posortowanie podciągi w jeden ciąg posortowany.
 */
public class MergeSort {

    public static void main(String[] args) {
        int [] unsorted = {9, 3, 5, 1, 6, 2, 4, 7, 8};
        MergeSort mergeSort = new MergeSort();
        System.out.println("Sorted: "+ Arrays.toString(mergeSort.mergeSort(unsorted)));
    }

    public int [] mergeSort(int [] array){
        if(array.length > 1) {
            int [] firstHalf = Arrays.copyOfRange(array, 0, array.length/2);
            int [] secondHalf = Arrays.copyOfRange(array, (array.length/2), array.length);
            mergeSort(firstHalf);
            mergeSort(secondHalf);
            merge(array, firstHalf, secondHalf);
        }
        return array;
     }

    private void merge(int [] array, int [] first, int [] second) {
        //Index Position in first array - starting with first element
        int idxFirst = 0;

        //Index Position in second array - starting with first element
        int idxSecond = 0;

        //Index Position in merged array - starting with first position
        int idxMerged = 0;

        while (idxFirst < first.length && idxSecond < second.length) {
            if(first[idxFirst] < second[idxSecond]) {
                array[idxMerged] = first[idxFirst];
                idxFirst += 1;
            } else {
                array[idxMerged] = second[idxSecond];
                idxSecond += 1;
            }
            idxMerged += 1;
        }

        //copy remaining elements from both halves - each half will have already sorted elements
        for(int i = idxFirst; i < first.length; i++) {
            array[idxMerged] = first[i];
            idxMerged +=1;
        }

        for(int i = idxSecond; i < second.length; i++) {
            array[idxMerged] = second[i];
            idxMerged +=1;
        }
    }
}
