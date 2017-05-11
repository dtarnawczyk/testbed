package algorithms.permutations;

import java.util.Arrays;

public class Permutations {

    public static void main(String[] args) {

        int [] array = {1,2,3};
        permutation(array);
    }

    public static void permutation(int [] array) {
        generate(array, array.length-1);
    }

    public static void generate(int [] array, int n){
        if(n == 0){
            System.out.println(Arrays.toString(array));
        } else {
            for(int i=0; i <= n; i++){
                generate(array, n-1);
                if(i < n) {
                    swap(array, i, n);
                    reverse(array, n-1);
                }
            }
        }
    }

    public static void reverse(int [] array, int m){
        int n = m;
        int i = 0;
        while(i < n){
            swap(array, i, n);
            i++;
            n--;
        }
    }

    private static void swap(int [] array, int index1, int index2){
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }
}
