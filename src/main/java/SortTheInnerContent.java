import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertEquals;

public class SortTheInnerContent {


    public static String sortTheInnerContent(String words) {
        String [] wordsArray = words.split("\\s");
        String [] newWordsArray = Arrays.stream(wordsArray).map(word -> {
            if(word.length() > 2) {
                String inner = word.substring(1, word.length()-1);
                Character [] innerContent = inner.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
                Arrays.sort(innerContent, (c1, c2) -> c2.compareTo(c1));
                StringBuilder contentBuilder = new StringBuilder();
                for(char sign : innerContent)
                    contentBuilder.append(sign);
                return word.charAt(0)+contentBuilder.toString()+word.charAt(word.length()-1);
            } else {
                return word;
            }
        }).toArray(String[]::new);
        return String.join(" ", newWordsArray);
    }

    @Test
    public void exampleTests() {
        assertEquals("srot the inner ctonnet in dsnnieedcg oredr", SortTheInnerContent.sortTheInnerContent("sort the inner content in descending order"));
        assertEquals("wiat for me", SortTheInnerContent.sortTheInnerContent("wait for me"));
        assertEquals("tihs ktaa is esay", SortTheInnerContent.sortTheInnerContent("this kata is easy"));
    }

    public static String sortTheInnerContent2(String words) {
        return Arrays.asList(words.split(" ")).stream()
                .map(word -> word.length() < 3 ? word : word.charAt(0) + sortChars(word) + word.charAt(word.length() - 1))
                .collect(Collectors.joining(" "));
    }

    public static String sortChars(String word) {
        String[] chars = word.substring(1, word.length() - 1).split("");
        Arrays.sort(chars, Collections.reverseOrder());
        return String.join("", chars);
    }
}
