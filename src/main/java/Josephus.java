import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Josephus {

    public static void main(String[] args) {

        // Expected {3, 6, 2, 5, 1, 4, 7}
        System.out.println(josephusPermutation(Arrays.asList(1,2,3,4,5,6,7), 3));

        // Expected: {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
        System.out.println(
                josephusPermutation(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 1));

        // Expected: {2, 4, 6, 8, 10, 3, 7, 1, 9, 5}
        System.out.println(
                josephusPermutation(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 2));

        System.out.println(
                josephusPermutation(Arrays.asList(), 2));

    }

    public static <T> List<T> josephusPermutation(final List<T> items, final int k) {
        List<T> output = new ArrayList<>();
        List<T> input = new ArrayList<>(items);
        int size = input.size();
        if(size <= 0) return output;
        boolean [] marked = new boolean[size];
        Arrays.fill(marked, Boolean.TRUE);
        int n = k % size - 1;
        for(int i=0; i < items.size(); i++){
            output.add(input.get(n));
            marked[n] = Boolean.FALSE;
            List<T> tmp = new ArrayList<>();
            for(int j=0; j < size; j++) {
                if(marked[j]) {
                    tmp.add(input.get(j));
                }
            }
            input = tmp;
            size = input.size();
            boolean [] tmpMarked = new boolean[size];
            Arrays.fill(tmpMarked, Boolean.TRUE);
            marked = tmpMarked;
            if(size > 0)
                n = (n-1 + k) % size;
            else
                n = 0;
        }
        return output;
    }
}
