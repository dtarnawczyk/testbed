import org.junit.Test;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static org.junit.Assert.assertEquals;

public class SameNbDivisors {

    public static void main(String[] args) {
        System.out.println(getDivisorsCount(14));
    }

    public static int countPairsInt(int diff, long nMax) {
        long counter = LongStream.rangeClosed(1, nMax)
                .filter(n -> (n + diff <= nMax) && (getDivisorsCount(n) == getDivisorsCount(n+diff)))
                .count();

        return (int) counter;

    }

    private static long getDivisorsCount(long number){
        long count = 0;
        for (long i = 1; i <= Math.floor(Math.sqrt(number)); i++) {
            if (number % i == 0) {
                count += 1;
                if (number / i != i) count += 1;
            }
        }
        return count;
//        return LongStream
//                .rangeClosed(1, number/2)
//                .filter(i -> (number % i) == 0)
//                .count();
    }

    private static void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }
    @Test
    public void test() {
        System.out.println("Basic Tests");
        testing(SameNbDivisors.countPairsInt(1, 50), 8);
        testing(SameNbDivisors.countPairsInt(3, 100), 7);
        testing(SameNbDivisors.countPairsInt(3, 200), 18);
        testing(SameNbDivisors.countPairsInt(6, 350), 86);
        testing(SameNbDivisors.countPairsInt(6, 1000), 214);
        testing(SameNbDivisors.countPairsInt(7, 1500), 189);
        testing(SameNbDivisors.countPairsInt(7, 2500), 309);
        testing(SameNbDivisors.countPairsInt(7, 3000), 366);
        testing(SameNbDivisors.countPairsInt(9, 4000), 487);
        testing(SameNbDivisors.countPairsInt(9, 5000), 622);
        testing(SameNbDivisors.countPairsInt(11, 5000), 567);
    }}
