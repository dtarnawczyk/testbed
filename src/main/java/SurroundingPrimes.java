import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SurroundingPrimes {

    public static long[] primeBefAft(long num) {
        long beforeCounter = num;
        long primeBefore = -1l;
        for(long i = beforeCounter-1; i >= 0; i--){
            if(isPrime(i)){
                primeBefore = i;
                break;
            }
        }

        long afterCounter = num;
        long primeAfter = -1l;
        while(true){
            afterCounter++;
            if(isPrime(afterCounter)){
                primeAfter = afterCounter;
                break;
            }
        }
        return new long[]{primeBefore, primeAfter};
    }

    private static boolean isPrime(long p){
        if (p < 2) return false;
        if (p == 2) return true;
        if (p % 2 == 0) return false;
        for(int i=3; i < Math.sqrt(p)+1; i += 2){
            if(p % i == 0){
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println("Fixed Tests");
        assertEquals(89, SurroundingPrimes.primeBefAft(97)[0]);
        assertEquals(101, SurroundingPrimes.primeBefAft(97)[1]);
        assertEquals(97, SurroundingPrimes.primeBefAft(100)[0]);
        assertEquals(101, SurroundingPrimes.primeBefAft(100)[1]);
        assertEquals(97, SurroundingPrimes.primeBefAft(101)[0]);
        assertEquals(103, SurroundingPrimes.primeBefAft(101)[1]);
        assertEquals(113, SurroundingPrimes.primeBefAft(120)[0]);
        assertEquals(127, SurroundingPrimes.primeBefAft(120)[1]);
        assertEquals(127, SurroundingPrimes.primeBefAft(130)[0]);
        assertEquals(131, SurroundingPrimes.primeBefAft(130)[1]);
    }
}
