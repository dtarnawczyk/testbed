package algorithms.searching;

import algorithms.sorting.QuickSort;

public class BinarySearch {

    public static void main(String[] args) {
        int[] input = {9, 3, 5, 1, 6, 2, 4, 7, 8};

        int searchValue = 10;

        QuickSort quickSort = new QuickSort();
        input = quickSort.sort(input);

        boolean existsInInput = searchIfContains(input, searchValue);
        System.out.println("Search value exists in array ? "+existsInInput);

        System.out.println("Search value index in array ? "+ searchIndex(input, searchValue));
    }

    private static int searchIndex(int [] input, int searchValue) {

        int startIndex = 0;
        int endIndex = input.length-1;
        while (startIndex <= endIndex) {
            int middleIndex = (startIndex + endIndex) / 2;
            if (searchValue == input[middleIndex]) {
                return middleIndex;
            }
            if (searchValue < input[middleIndex]) {
                endIndex = middleIndex - 1;
            } else {
                startIndex = middleIndex + 1;
            }
        }
        return -1;
    }

    private static boolean searchIfContains(int [] input, int searchValue) {
        if (input.length == 0) {
            return false;
        }
        int low = 0;
        int high = input.length-1;

        while(low <= high ) {
            int middle = (low+high) /2;
            if (searchValue > input[middle] ){
                low = middle +1;
            } else if (searchValue < input[middle]){
                high = middle -1;
            } else {
                return true;
            }
        }
        return false;
    }
}
