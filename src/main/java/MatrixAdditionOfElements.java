import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MatrixAdditionOfElements {

    public static int sumOfElements(int matrix[][]) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int sum = 0;
        for(int i=0; i < rows; i++){
            for(int j=0; j < columns; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    @Test
    public void test1() {
        int a[][] = {{1,0},{0,1}};
        int b[][] = {{1,2,3},{4,5,6},{7,8,9}};
        int c[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,2}};
        assertEquals(MatrixAdditionOfElements.sumOfElements(a), 2);
        assertEquals(MatrixAdditionOfElements.sumOfElements(b), 45);
        assertEquals(MatrixAdditionOfElements.sumOfElements(c), 122);
    }
}
