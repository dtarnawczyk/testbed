import org.junit.Test;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.LongStream;

import static org.junit.Assert.assertEquals;

public class StepInPrimes {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(step(6,100,110)));
    }

    @Test
    public void test() {
        System.out.println("Fixed Tests");
        assertEquals("[101, 103]", Arrays.toString(StepInPrimes.step(2,100,110)));
        assertEquals("[103, 107]", Arrays.toString(StepInPrimes.step(4,100,110)));
        assertEquals("[101, 107]", Arrays.toString(StepInPrimes.step(6,100,110)));
        assertEquals("[359, 367]", Arrays.toString(StepInPrimes.step(8,300,400)));
        assertEquals("[307, 317]", Arrays.toString(StepInPrimes.step(10,300,400)));
    }

    public static long[] step(int g, long m, long n) {
        Optional<Long> prime = LongStream.rangeClosed(m, n)
                .filter(i -> isPrime(i) && isPrime(i+g)).boxed().findFirst();
        return prime.isPresent() ? new long [] {prime.get(), prime.get()+g} : null;
//        for(long i = 0; i < primes.size(); i++){
//            for(long j = i+1; j < primes.size(); j++) {
//                if (primes.get((int) j) - primes.get((int) (i)) == g) {
//                    return new long[]{primes.get((int) (i)), primes.get((int) (j))};
//                }
//            }
//        }
//      return null;
    }

    private static boolean isPrime(long x) {
        for(long i=2; i <= Math.sqrt(x); i++){
            if(x % i == 0){
                return false;
            }
        }
        return true;
    }
}
