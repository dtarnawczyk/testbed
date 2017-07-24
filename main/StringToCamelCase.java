import java.util.stream.IntStream;

/**
 * Created by dominik on 2017-03-29.
 */
public class StringToCamelCase {

    public static void main (String [] args) {

        System.out.println(toCamelCase("the-stealth-warrior"));

        System.out.println(toCamelCase("The_Stealth_Warrior"));

    }

    public static String toCamelCase(String s) {

        StringBuilder builder = new StringBuilder();
        String [] strings = s.split("-|_");
        builder.append(strings[0]);
        IntStream.range(1, strings.length).forEach(i -> {
            builder.append(strings[i].substring(0,1).toUpperCase());
            builder.append(strings[i].substring(1).toLowerCase());
        });
        return builder.toString();
    }
}
