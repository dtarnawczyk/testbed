import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SemiPrimes {

    public static void main(String[] args) {
        System.out.println(semiPrimess(100));
    }

    public static List<Integer> semiPrimess(int range) {
        List<Integer> semiprimes = new ArrayList<>(range);
        for(int i=3; i < range; i++){
            if(isSemiPrime(i, range)){
                semiprimes.add(i);
            }
        }
        return semiprimes;
    }

    private static Boolean isSemiPrime(int number, int range){
        Boolean [] primes = primes(range);
        for(int i=number-1; i > 1; i--){
            if(primes[i])
            if(number % i == 0){
                int prime = number / i;
                if(primes[prime]){
                    return true;
                }
            }
        }
        return false;
    }

    private static Boolean [] primes(int range) {
        Boolean [] primes = new Boolean[range];
        Arrays.fill(primes, Boolean.TRUE);
        for(int i=2; i < range; i++){
            for(int j = i+1; j < range; j++) {
                if(primes[j])
                if((j % i) == 0){
                    primes[j] = Boolean.FALSE;
                }
            }
        }
        return primes;
    }

}
