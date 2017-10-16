import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertEquals;

public class SpinWords {

    public String spinWords(String sentence) {
        return Arrays.stream(sentence.split(" ")).map(str -> {
            if(str.length() >= 5)
                return new StringBuffer(str).reverse().toString();
            return str;
        }).collect(Collectors.joining(" "));
    }

    @Test
    public void test() {
        assertEquals("emocleW", new SpinWords().spinWords("Welcome"));
        assertEquals("Hey wollef sroirraw", new SpinWords().spinWords("Hey fellow warriors"));
    }
}
