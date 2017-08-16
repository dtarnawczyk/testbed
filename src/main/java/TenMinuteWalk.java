import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class TenMinuteWalk {

    private static boolean isValid(char[] walk) {
        if(walk.length != 10) return false;
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put('s','n');
        pairs.put('n','s');
        pairs.put('w','e');
        pairs.put('e','w');
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : walk){
            if(stack.isEmpty())
                stack.push(c);
            else {
                if(stack.peek() == pairs.get(c)){
                    stack.pop();
                } else
                    stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void Test() {
        assertEquals("Should return true", true, TenMinuteWalk.isValid(new char[] {'n','s','n','s','n','s','n','s','n','s'}));
        assertEquals("Should return false", false, TenMinuteWalk.isValid(new char[] {'w','e','w','e','w','e','w','e','w','e','w','e'}));
        assertEquals("Should return false", false, TenMinuteWalk.isValid(new char[] {'w'}));
        assertEquals("Should return false", false, TenMinuteWalk.isValid(new char[] {'n','n','n','s','n','s','n','s','n','s'}));
    }
}
