import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MigratoryBirds {

    static int migratoryBirds(int n, int[] ar) {
        Map<Integer, Integer> birdTypes = new TreeMap<>();
        birdTypes.put(1,0);
        birdTypes.put(2,0);
        birdTypes.put(3,0);
        birdTypes.put(4,0);
        birdTypes.put(5,0);

        for (int i : ar) {
            birdTypes.replace(i, birdTypes.get(i)+1);
        }

        return birdTypes.entrySet().stream()
                .max(Map.Entry.comparingByValue()).get().getKey();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = migratoryBirds(n, ar);
        System.out.println(result);
    }
}