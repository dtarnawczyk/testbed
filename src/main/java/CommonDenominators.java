import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class CommonDenominators {

    public static String convertFrac(long[][] lst) {

        // Maxymalny mianownik
        long max = Long.MIN_VALUE;
        for(int i=0; i < lst.length; i++){
            if(lst[i][1] > max){
                max = lst[i][1];
            }
        }
        long maxD = IntStream.range(0, lst.length)
                .mapToObj(i -> lst[i][1])
                .mapToLong(i->i)
                .max()
                .getAsLong();
        System.out.printf("Maxymalny mianownik: %s \n" , maxD);

        // Najmniejszy wspolny mianownik;
        long denominator = max;
        while (true) {
            boolean found = false;
            for (int i = 0; i < lst.length; i++) {
                if (denominator % lst[i][1] != 0) {
                    found = true;
                    break;
                }
            }
            if(found)
                denominator += max;
            else
                break;
        }
        System.out.printf("Najmniejszy wspolny mianownik: %s \n" , denominator);

        StringBuilder builder = new StringBuilder();
        for (int i=0; i < lst.length; i++) {
            builder.append("(");
            builder.append(lst[i][0] * (denominator / lst[i][1]));
            builder.append(",");
            builder.append(denominator);
            builder.append(")");
        }
        return builder.toString();
    }

    @Test
    public void test_fractions() throws Exception {
        long[][] lst;
        lst = new long[][] { {1, 2}, {1, 3}, {1, 4} };
        assertEquals("(6,12)(4,12)(3,12)", CommonDenominators.convertFrac(lst));
    }

    @Test
    public void test_fractions2() throws Exception {
        long[][] lst;
        lst = new long[][] {};
        assertEquals("", CommonDenominators.convertFrac(lst));
    }
}
