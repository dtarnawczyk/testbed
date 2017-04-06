import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class CartesianNeighbors {

    public static void main(String[] args) {
        cartesianNeighbor(2,2);
//        cartesianNeighbor(5,7);
    }

    public static int[][] cartesianNeighbor(int x, int y){

        int [] first = {x-1, x, x+1};
        int [] second = {y-1, y, y+1};
        int [][] result = new int[8][2];
        int c =0;
        for(int i=0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int a = first[i];
                int b = second[j];
                if (a != x || b != y) {
                    result[c][0] = a;
                    result[c][1] = b;
                    c += 1;
                }

            }
        }
        return result;

    }

    @Test
    public void exampleTest() {
        assertArrayEquals(new int[][]{{1,1},{1,2},{1,3},{2,1},{2,3},{3,1},{3,2},{3,3}}, CartesianNeighbors.cartesianNeighbor(2, 2));
    }

}
