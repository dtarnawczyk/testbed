import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class WeightSort {

    public static void main(String [] args) {



    }

    @Test
    public void BasicTests() {
        System.out.println("****** Basic Tests ******");
        assertEquals("2000 103 123 4444 99", WeightSort.orderWeight("103 123 4444 99 2000"));
        assertEquals("11 11 2000 10003 22 123 1234000 44444444 9999", WeightSort.orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));
        System.out.println(WeightSort.orderWeight("59544965313"));

    }

    public static String orderWeight(String strng) {
        String [] weights = strng.split("\\s");
        if(weights.length == 1) {
            weights = strng.split("");
        }
        Arrays.sort(weights, (String weight1, String weight2) -> {
            long sum1 = countSumOfDigits(weight1);
            long sum2 = countSumOfDigits(weight2);
            if( sum1 > sum2) {
                return 1;
            } else if (sum1 < sum2) {
                return -1;
            } else {
                return weight1.compareTo(weight2);
            }
        });
        return strng.split("\\s").length == 1 ? Arrays.stream(weights).collect(Collectors.joining(""))
                : Arrays.stream(weights).collect(Collectors.joining(" "));
    }

    private static long countSumOfDigits(String number) {
        long weight = Long.parseLong(number);
        long sum = 0;
        while(weight > 0) {
            sum += weight % 10;
            weight = weight / 10;
        }
        return sum;
    }

}
