import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CountingDuplicates {

    public static int duplicateCount(String text) {
        Map<Character, Integer> counterMap = new HashMap<>();
        for(char character : text.toCharArray()){
            character = Character.toLowerCase(character);
            if(counterMap.containsKey(character)){
                int l = counterMap.get(character);
                l += 1;
                counterMap.replace(character, l);
            }  else {
                counterMap.put(character, 1);
            }
        }
        Long countL = counterMap.values().stream().filter(i -> i > 1).count();
        return countL.intValue();
    }

    @Test
    public void abcdeReturnsZero() {
        assertEquals(0, CountingDuplicates.duplicateCount("abcde"));
    }

    @Test
    public void abcdeaReturnsOne() {
        assertEquals(1, CountingDuplicates.duplicateCount("abcdea"));
    }

    @Test
    public void indivisibilityReturnsOne() {
        assertEquals(1, CountingDuplicates.duplicateCount("indivisibility"));
    }

    @Test
    public void alphabetTwice() {
        assertEquals(26, CountingDuplicates.duplicateCount("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"));
    }
}
