import java.util.ArrayList;
import java.util.List;

public class SumDigitPower {

    public static void main (String [] args) {
        List<Long> findings = sumDigPow(10, 200);
        findings.forEach(l -> System.out.println(l));
    }

    public static List<Long> sumDigPow(long a, long b) {

        List<Long> sumDigPowList = new ArrayList<>();

        for(long l=a; l <= b; l++) {
            List<Integer> digits = new ArrayList();
            long number = l;

            while(number > 0) {
                int i = (int) number % 10;
                digits.add(i);
                number = number / 10;
            }
            long sum = 0;
            for(int i = digits.size()-1; i >= 0; i--){
                sum += power(digits.get(i), digits.size()-i);
//                sum += power(digits.get(i), powerCounter += 1);
            }

            if(sum == l) {
                sumDigPowList.add(l);
            }
        }

        return sumDigPowList;
    }

    private static long power(int number, int power){
        if ( power == 0) return 1;
        if ( power == 1) return number;
        long result = number;
        power--;
        while(power > 0) {
            result *= number;
            power--;
        }
        return result;
    }
}
