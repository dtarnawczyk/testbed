import java.util.Arrays;
import java.util.stream.IntStream;

public class CountSemiPrimes {

    public static void main(String [] args) {

        int N = 26;
        int P[] = {1,  4,  16};
        int Q[] = {26, 10, 20};

        System.out.println(solution(N, P, Q));


    }

    public static int[] solution(int N, int[] P, int[] Q) {

        // finding primes
        boolean [] primes = new boolean[N+1];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        for(int i=2; i < N; i++) {
            for(int j=i+1; j < N; j++) {
                if(primes[j]) {
                    if (j % i == 0) {
                        primes[j] = false;
                    }
                }
            }
        }


        int [] semiPrimesCountArray = new int[P.length];
        for(int s=0; s < semiPrimesCountArray.length; s++){
            int semiPrimesCount = 0;
            for(int i=P[s]; i <= Q[s]; i++){
                for(int j=0; j < primes.length;j++){
                    if(primes[j]){
                        if(i % j == 0) {
                            int div = i/j;
                            if(isPrimeInRange(div, primes)){
                                semiPrimesCount += 1;
                                break;
                            }
                        }
                    }
                }
            }
            semiPrimesCountArray[s] = semiPrimesCount;
        }


        IntStream.range(0, semiPrimesCountArray.length)
                .forEach(i -> System.out.println(semiPrimesCountArray[i]));

        return semiPrimesCountArray;
    }

    private static boolean isPrimeInRange(int n, boolean [] primes){
        for(int i=0; i < primes.length; i++){
            if(primes[i]){
                if(n == i){
                    return true;
                }
            }
        }
        return false;
    }

}
