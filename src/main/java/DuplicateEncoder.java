import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DuplicateEncoder {

    // BEST PRACTICE
    static String encode(String word){
        word = word.toLowerCase();
        String result = "";
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            result += word.lastIndexOf(c) == word.indexOf(c) ? "(" : ")";
        }
        return result;
    }
/*

    private static String encode(String input) {
        input = input.toLowerCase();
        StringBuilder builder = new StringBuilder(input);
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (inputMoreThenOnce(c, input)){
                builder.setCharAt(i,')');
            } else {
                builder.setCharAt(i,'(');
            }
        }
        return builder.toString();
    }

    private static boolean inputMoreThenOnce(char c, String input){
        int counter = 0;
        for (int i = 0; i < input.length(); i++) {
            char n = input.charAt(i);
            if(n == c){
                counter++;
            }
            if(counter>1){
                return true;
            }
        }
        return false;
    }
*/

    @Test
    public void test() {
        assertEquals(")()())()(()()(", DuplicateEncoder.encode("Prespecialized"));
        assertEquals("))))())))",DuplicateEncoder.encode("   ()(   "));
        assertEquals(")())())",DuplicateEncoder.encode("Success"));
        assertEquals("))((",DuplicateEncoder.encode("(( @"));
        assertEquals("()()()",DuplicateEncoder.encode("recede"));

    }
}
