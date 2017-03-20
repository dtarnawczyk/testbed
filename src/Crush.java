import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Crush {

    public static void main(String []args){

        Scanner sc = new Scanner(System.in);
        String [] firstLine = sc.nextLine().split("\\s");
        int N = Integer.parseInt(firstLine[0]);
        long M = Long.parseLong(firstLine[1]);
        long [] array = new long [N];
        LongStream.range(0, M).forEach(i -> {
            String [] numbers = sc.nextLine().split("\\s");
            int rangeStart = Integer.parseInt(numbers[0]);
            int rangeEnd = Integer.parseInt(numbers[1]);
            long k = Long.parseLong(numbers[2]);
            IntStream.range(rangeStart-1, rangeEnd).forEach(
                    j -> array[j] += k
            );
        });
        sc.close();
        System.out.println(Arrays.stream(array).max().getAsLong());

    }
}
