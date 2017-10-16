import org.junit.Test;

import java.util.Collections;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertEquals;

public class Diamond {

    public static String print(int i){
        if(i < 0 || i % 2 == 0)
            return null;
        int spacesNum = i / 2;
        int starsCount = 1;
        StringBuilder builder = new StringBuilder();
        int j = i;
        while(j-- > 0){
            if(spacesNum > 0) {
                builder.append(repeatString(spacesNum, " "));
                builder.append(repeatString(starsCount, "*"));
                builder.append("\n");
                starsCount += 2;
            } else if (spacesNum == 0){
                builder.append(repeatString(starsCount, "*"));
                builder.append("\n");
                starsCount -= 2;
            } else {
                builder.append(repeatString(spacesNum, " "));
                builder.append(repeatString(starsCount, "*"));
                builder.append("\n");
                starsCount -= 2;
            }
            spacesNum--;
        }
        return builder.toString();
    }

    private static String repeatString(int times, String stringToRepeat){
        return Collections.nCopies(Math.abs(times),  stringToRepeat)
                .stream()
                .collect(Collectors.joining(""));
    }


    @Test
    public void testDiamond51() {
        System.out.println(Diamond.print(51));
    }

    @Test
    public void testDiamond3() {
        StringBuffer expected = new StringBuffer();
        expected.append(" *\n");
        expected.append("***\n");
        expected.append(" *\n");

        assertEquals(expected.toString(), Diamond.print(3));
    }

    @Test
    public void testDiamond5() {
        StringBuffer expected = new StringBuffer();
        expected.append("  *\n");
        expected.append(" ***\n");
        expected.append("*****\n");
        expected.append(" ***\n");
        expected.append("  *\n");

        assertEquals(expected.toString(), Diamond.print(5));
    }
}
