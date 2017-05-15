import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class WhereIsMyParent {
    static String findChildren(final String text) {
        Map<String, List<Character>> parentChildren = new TreeMap<>();
        List<Character> mums = text.chars()
                .filter(Character::isUpperCase)
                .mapToObj(c -> (char)c)
                .collect(Collectors.toList());

        for(Character m : mums){
            char lower = Character.toLowerCase(m);
            List<Character> children = new ArrayList<>();
            for(Character c : text.toCharArray()) {
                if(lower == c)
                    children.add(c);
            }

            if(parentChildren.containsKey(m.toString())){
                String parents = m.toString() + m.toString();
                parentChildren.remove(m.toString());
                parentChildren.put(parents, children);
            } else {
                parentChildren.put(m.toString(), children);

            }

        }

        StringBuilder builder = new StringBuilder();
        for(String mms : parentChildren.keySet()){
            builder.append(mms);
            String children = parentChildren.get(mms).stream().map(e->e.toString()).collect(Collectors.joining());
            builder.append(children);
        }
        return builder.toString();
    }

    private static void test(final String expected, final String input) {
        assertEquals("For input \"" + input + '"', expected, WhereIsMyParent.findChildren(input));
    }

    @Test
    public void basicTests() {
        test("AaBb", "abBA");
        test("AaaaaaZzzz", "AaaaaZazzz");
        test("AaBbbCcc", "CbcBcbaA");
        test("FfUuuuXx", "xXfuUuuF");
        test("", "");
        test("CccccHhhhhOoTttttW[W]wwwXxxx","OhWhhHhoCccccTttttXxxxWwww");
    }
}
