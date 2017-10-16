import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LineVasyaClerk {

    private static int ticketPrice = 25;

    public static String tickets(int[] peopleInLine) {
        int bill25 = 0, bill50 = 0;
        for (int payment : peopleInLine){
            if(payment==25){
                bill25++;
            } else if(payment==50){
                bill25--;
                bill50++;
            } else if(payment==100){
                if(bill50>0){
                    bill50--;
                    bill25--;
                } else{
                    bill25-=3;
                }
            }
            if(bill25<0 || bill50 <0){
                return "NO";
            }
        }
        return "YES";
    }


    @Test
    public void test1() {
        assertEquals("YES", LineVasyaClerk.tickets(new int[] {25, 25, 50}));
    }
    @Test
    public void test2() {
        assertEquals("NO", LineVasyaClerk.tickets(new int []{25, 100}));
    }
    @Test
    public void test3() {
        assertEquals("YES", LineVasyaClerk.tickets(new int []{25, 25, 25, 25, 50, 100, 50}));
    }
    @Test
    public void test4() {
        assertEquals("NO", LineVasyaClerk.tickets(new int []{25, 25, 25, 25, 25, 100, 100}));
    }
}