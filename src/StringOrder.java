import java.util.Map;
import java.util.StringJoiner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringOrder {

    public static void main(String [] args) {

        String input = "is2 Thi1s T4est 3a";
        System.out.println(order(input));
    }

    public static String order(String input) {

        String [] inputs = input.split(" ");

        Map<Integer, String> stringMap = new TreeMap();

        for(String str : inputs) {

            Pattern p = Pattern.compile("\\d");
            Matcher m = p.matcher(str);

            if(m.find()) {
                stringMap.put(Integer.parseInt(m.group()), str);
            }
        }
        StringJoiner joiner = new StringJoiner(" ");
        for(String str : stringMap.values()) {
            joiner.add(str);
        }

        return joiner.toString();
    }
}
