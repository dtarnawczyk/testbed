package codility;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CountDistinctSlices {

    public static int solution (int M, int [] A) {

        int max = 1000000000;
        int limit = M;
        int counter = 0;
        List<List<Integer>> listOfPairs = new ArrayList<>();
        for(int i=0; i < A.length; i++) {
            for(int j=i; j < A.length; j++) {
                if(A[i] <= M && A[j] <= M) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(A[i]);
                    pair.add(A[j]);
                    boolean notFound = true;
                    for (List<Integer> existingPair : listOfPairs) {
                        if ((pair.get(0) == existingPair.get(0)) &&
                                (pair.get(1) == existingPair.get(1))) {
                            notFound = false;
                            break;
                        }
                    }
                    if (notFound) {
                        listOfPairs.add(pair);
                        counter++;
                        if (counter >= max) return max;
                    }
                }
            }
        }
        return counter;
    }

    @Test
    public void test() {

        int [] A = {3, 4, 5, 5, 2};
        int M = 6;

        Assert.assertEquals(9, CountDistinctSlices.solution(M, A));

    }
}
