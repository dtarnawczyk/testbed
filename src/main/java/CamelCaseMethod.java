import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class CamelCaseMethod {
    public static String camelCase(final String string) {
        return string.length() > 0 ? Arrays.stream(string.split(" ")).map(w -> {
            String firstLetter = w.substring(0,1).toUpperCase();
            return w.length() >= 2 ? firstLetter+w.substring(1) : firstLetter;
        }).collect(Collectors.joining()) : "";
    }

    @Test
    public void basicTests() {
        assertEquals("For input \"test case\"", "TestCase", CamelCaseMethod.camelCase("test case"));
        assertEquals("For input \"camel case method\"", "CamelCaseMethod", CamelCaseMethod.camelCase("camel case method"));
        assertEquals("For input \"say hello \"", "SayHello", CamelCaseMethod.camelCase("say hello "));
        assertEquals("For input \"a b cd\"", "ABCd", CamelCaseMethod.camelCase("a b cd"));
        assertEquals("For input \"\"", "", CamelCaseMethod.camelCase(""));
    }
}
