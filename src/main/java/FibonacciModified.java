import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciModified {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] input = sc.nextLine().split("\\s");
        BigInteger t1 = BigInteger.valueOf(Long.parseLong(input[0]));
        BigInteger t2 = BigInteger.valueOf(Long.parseLong(input[1]));
        BigInteger n = BigInteger.valueOf(Long.parseLong(input[2]));
        BigInteger diff = t2.subtract(t1);
        BigInteger t3 = BigInteger.ZERO;
        for (BigInteger bi = t1;
             n.subtract(BigInteger.valueOf(2)).compareTo(bi) > 0;
             bi = bi.add(diff)) {
            t3 = t1.add(t2.multiply(t2));
            t1 = t2;
            t2 = t3;
        }
        System.out.println(t3.toString());
    }
}
