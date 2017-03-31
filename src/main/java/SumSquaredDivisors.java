import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Created by dominik on 2017-03-26.
 */
public class SumSquaredDivisors {

    public static void main (String [] args) {
//        listSquared(1, 250);
        System.out.println(listSquared(1, 250));
        System.out.println(listSquared(42, 250));
        System.out.println(listSquared(250, 500));
    }

    public static String listSquared(long m, long n) {

        List<Long[]> result = new ArrayList();
        for(long i = m; i <= n; i++) {

            Set<Long> divisorsSquared = new HashSet<>();
            divisorsSquared.add(1L);
            for(long j = 2; j <= i/2; j++){
                if(i % j == 0) {
                    divisorsSquared.add(j*j);
                }
            }
            divisorsSquared.add(i*i);
            long sum = divisorsSquared.stream().mapToLong(Long::longValue).sum();
            double sqrt = Math.sqrt(sum);
            if(Math.floor(sqrt) == sqrt) {
                result.add(new Long [] {i, sum});
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        IntStream.range(0, result.size()).forEach(l -> {
            stringBuilder.append("["+result.get(l)[0]+ ", "+ result.get(l)[1]+"], ");
        });
        stringBuilder.append("]");
        return stringBuilder.toString().replaceAll(", ]", "]");

    }

}
