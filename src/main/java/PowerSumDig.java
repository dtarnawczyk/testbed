import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PowerSumDig {

    public static long powerSumDigTerm(int n) {
        int foundCounter = 0;
        long number = 10;
        while(true){
            number += 1;
            long unitSum = 0;
            int unitCounter = 0;
            long testedNumber = number;
            while(testedNumber > 0) {
                unitSum += testedNumber % 10;
                testedNumber = testedNumber / 10;
                unitCounter += 1;
            }
            for(int i=2; i <= unitCounter; i++){
                long power = (long) Math.pow(unitSum, i);
                if(power == number){
                    if (++foundCounter == n){
                        return number;
                    }
                }
            }
        }
    }

    private static void testing(long act, long exp) {
        assertEquals(exp, act);
    }
    @Test
    public void test1() {
        testing(PowerSumDig.powerSumDigTerm(1), 81);
        testing(PowerSumDig.powerSumDigTerm(2), 512);
        testing(PowerSumDig.powerSumDigTerm(3), 2401);
        testing(PowerSumDig.powerSumDigTerm(4), 4913);
    }

}
