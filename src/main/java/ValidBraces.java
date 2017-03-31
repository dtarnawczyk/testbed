import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ValidBraces {
    public static void main(String [] args) {
        System.out.println(isValid("(){}[]"));
        System.out.println(isValid("(}"));
        System.out.println(isValid("[(])"));
        System.out.println(isValid("([{}])"));
        System.out.println(isValid("[({})](]"));
        System.out.println(isValid(")"));
        System.out.println(isValid("("));
    }

    public static boolean isValid(String braces) {
        if(braces == null || braces.isEmpty()) return false;
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> closings = new HashMap<>();
        closings.put(')', '(');
        closings.put(']', '[');
        closings.put('}', '{');
        char [] bracesArray = braces.toCharArray();
        for(char brace : bracesArray) {
            if(closings.containsKey(brace)) {
                if(stack.peek() == closings.get(brace)) {
                    stack.pop();
                } else {
                    stack.push(brace);
                }
            } else {
                stack.push(brace);
            }
        }
        return stack.isEmpty() ? true : false;
    }

}
