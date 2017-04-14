package algorithms.sorting;

import java.util.Arrays;

/**
 * Bubble sort - sortowanie bąbelkowo. Przechodzimy po kolei po liście i porównujemy sąsiednie elementy;
 * jeśli potrzeba, zamieniamy je. Złożoność obliczeniowa O(n^2)
 */
public class BubbleSort implements Sort{
    public static void main(String[] args) {
        int[] unsorted = {9, 3, 5, 1, 6, 2, 4, 7, 8};
        BubbleSort bubbleSort = new BubbleSort();
        System.out.println("Sorted: " + Arrays.toString(bubbleSort.sort(unsorted)));
    }

    public int [] sort(int [] input) {
        boolean unsorted = true;
        while(unsorted) {
            unsorted = false;
            for(int i=0; i < input.length-1; i++){
                if(input[i] > input[i+1]){
                    int tmp = input[i];
                    input[i] = input[i+1];
                    input[i+1] = tmp;
                    unsorted = true;
                }
            }
        }
        return input;
    }
}
