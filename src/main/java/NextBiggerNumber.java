import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class NextBiggerNumber {

    public static long nextBiggerNumber(long n) {
        if(n == Long.MAX_VALUE) return -1;
        long next = n;
        while(true) {
            next = next + 1;
            if(next == Long.MAX_VALUE) return -1;
            List<Integer> numberList = number(n);
            int numberSize = numberList.size();
            List<Integer> nextNumber = number(next);
            if(nextNumber.size() > numberSize){
                return -1;
            }
            for(int a: nextNumber){
                for(Iterator<Integer> it = numberList.iterator(); it.hasNext();) {
                    int b = it.next();
                    if(a == b){
                        it.remove();
                        break;
                    }
                }
            }
            if(numberList.size() == 0){
                return getLongFromList(nextNumber);
            }
        }
    }

    private static long getLongFromList(List<Integer> integerList){
        String s = "";
        for(int i : integerList){
            s += i;
        }
        return Long.parseLong(s);
    }

    private static List<Integer> number(long n) {
        List<Integer> number = new ArrayList<>();
        while(n > 0) {
            long a = n % 10;
            number.add((int) n % 10);
            n = n / 10;
        }
        Collections.reverse(number);
        return number;
    }

    @Test
    public void basicTests() {
        assertEquals(21, NextBiggerNumber.nextBiggerNumber(12));
        assertEquals(531, NextBiggerNumber.nextBiggerNumber(513));
        assertEquals(2071, NextBiggerNumber.nextBiggerNumber(2017));
        assertEquals(441, NextBiggerNumber.nextBiggerNumber(414));
        assertEquals(414, NextBiggerNumber.nextBiggerNumber(144));
        assertEquals(-1, NextBiggerNumber.nextBiggerNumber(9));
        assertEquals(-1, NextBiggerNumber.nextBiggerNumber(111));
        assertEquals(-1, NextBiggerNumber.nextBiggerNumber(531));

    }
}
