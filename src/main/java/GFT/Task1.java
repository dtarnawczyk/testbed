package GFT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {


        int [] [] testArray = new int [3][4];

        testArray [0][0] = 4;
        testArray [0][1] = 5;
        testArray [0][2] = 7;
        testArray [0][3] = 8;

        testArray [1][0] = 2;
        testArray [1][1] = 1;
        testArray [1][2] = 4;
        testArray [1][3] = 1;

        testArray [2][0] = 3;
        testArray [2][1] = 0;
        testArray [2][2] = 2;
        testArray [2][3] = 3;

        System.out.println(Arrays.toString(process(testArray)));
    }

    //int[N][M] matrixA
    public static int[] process(int[][] matrixA) {

        int rows = matrixA.length;
        int columns = matrixA[0].length;
        if(rows < 1 || columns < 1) {
            throw new RuntimeException();
        }
        List<Integer> sums = new ArrayList<>();
        for(int i=0; i < columns; i++){
            int sum = 0;
            for(int j=0; j < rows; j++) {
                sum += matrixA[j][i];
            }
            sums.add(sum);
        }
        Collections.sort(sums);
        int[] output = new int[sums.size()];
        for(int i = 0; i < sums.size(); i++) {
            if (sums.get(i) != null) {
                output[i] = sums.get(i);
            }
        }
        return output;
    }

}
