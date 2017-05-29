import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ExpandedForm {

    public static String expandedForm(int num) {
        List<Integer> numbers = new ArrayList();
        while(num > 0) {
            numbers.add(num % 10);
            num = num / 10;
        }
        StringBuilder builder = new StringBuilder();
        int counter = numbers.size();
        Collections.reverse(numbers);
        for(Integer n : numbers) {
            counter--;
            if(n != 0) {
                builder.append(n);
                for (int i = 0; i < counter; i++) {
                    builder.append("0");
                }
                if(counter == 0) break;
                builder.append(" + ");
            }
            if(counter == 0) break;
        }
        if(builder.length() > 2 && builder.substring(builder.length()-3).equals(" + "))
            return builder.substring(0, builder.length()-3);
        else
            return builder.toString();
    }

    @Test
    public void testSomething() {
//        assertEquals("10 + 2", ExpandedForm.expandedForm(12));
//        assertEquals("40 + 2", ExpandedForm.expandedForm(42));
//        assertEquals("70000 + 300 + 4", ExpandedForm.expandedForm(70304));
        assertEquals("900", ExpandedForm.expandedForm(900));
        assertEquals("", ExpandedForm.expandedForm(0));
    }
}
