import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SigmaOne {

    public static int equalSigma1(int nmax) {
        int divisorsSum = 0;
        for (int i = 12; i <= nmax; i++) {
            int sum = 0;
            for(int j = 1; j <= i; j++){
                if(i % j == 0){
                    sum += j;
                }
            }
            if(isReversedSumSame(i, sum))
                divisorsSum += i;
        }
        return divisorsSum;
    }

    private static boolean isReversedSumSame(int number, int sum) {
        StringBuilder strNum = new StringBuilder();
        int num = number;
        while(num > 0) {
            int n = num % 10;
            strNum.append(n);
            num = num / 10;

        }
        int finalInt = Integer.parseInt(strNum.toString());
        if(number == finalInt) return false;
        int s = 0;
        for(int j = 1; j <= finalInt; j++){
            if(finalInt % j == 0){
                s += j;
            }
        }
        return s == sum;
    }


    @Test
    public void test() {
        System.out.println("Fixed Tests");
        assertEquals(0, SigmaOne.equalSigma1(100));
        assertEquals(528, SigmaOne.equalSigma1(738));
        assertEquals(1353, SigmaOne.equalSigma1(917));
        assertEquals(1353, SigmaOne.equalSigma1(1500));
        assertEquals(4565, SigmaOne.equalSigma1(2000));
    }
}
