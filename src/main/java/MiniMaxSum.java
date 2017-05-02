import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MiniMaxSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        long b = in.nextLong();
        long c = in.nextLong();
        long d = in.nextLong();
        long e = in.nextLong();

        List<Long> longList = new ArrayList<>();
        longList.add(a);
        longList.add(b);
        longList.add(c);
        longList.add(d);
        longList.add(e);

        List<Long> sumsList = new ArrayList<>(longList.size());

        for(int i=0; i < longList.size(); i++) {
            long sum = 0;
            for(int j=0; j < longList.size(); j++) {
                if(j != i) {
                    sum += longList.get(j);
                }
            }
            sumsList.add(sum);
        }
        Long max = sumsList.stream().max(Long::compareTo).get();
        Long min = sumsList.stream().min(Long::compareTo).get();
        System.out.print(String.join(" ", String.valueOf(min), String.valueOf(max)));

    }


}
