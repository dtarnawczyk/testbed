import java.math.BigInteger;

public class NumberOfTrailingZeros {

    public static void main (String [] args) {
        System.out.println(zeros(1000));
        System.out.println(zeros(12));
        System.out.println(zeros(14));
        System.out.println(zeros(0));
    }

    public static int zeros(int n) {
        BigInteger number = new BigInteger("1");
        for(int i = 1; i <= n; i++){
            number = number.multiply(new BigInteger(String.valueOf(i)));
        }
        System.out.println(number);
        String s = String.valueOf(number);
        int counter = 0;
        while(s.length() > 0) {
            int lastZeroIndex = s.lastIndexOf('0');
            if(s.length()-1 == lastZeroIndex) {
                counter += 1;
                s = s.substring(0, lastZeroIndex);
            } else {
                break;
            }
        }
        return counter;
    }
}
