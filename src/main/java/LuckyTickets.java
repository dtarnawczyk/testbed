import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LuckyTickets {

    public int numberOfTickets(int from, int to) {

        int counter = 0;
        for(int i= from; i <= to; i++) {

            if(isLuckyTicet(i)) counter += 1;

        }
        return counter;
    }

    private boolean isLuckyTicet(int i) {
        int threeCounter = 3;
        int firstHalfSum = 0, secondfHalfSum=0;
        while (i > 0) {
            int mod = i % 10;
            if(threeCounter > 0) firstHalfSum += mod;
            else secondfHalfSum += mod;
            i = i / 10;
            threeCounter-=1;
        }
        return firstHalfSum == secondfHalfSum;
    }


    LuckyTickets luckyTicket;

    @Before
    public void setUp() {
        luckyTicket = new LuckyTickets();
    }

    @Test
    public void testAll() {
        assertEquals(50412, luckyTicket.numberOfTickets(100000, 999999));
    }
}
