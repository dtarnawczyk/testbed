import java.util.Arrays;

public class BookJava8Chapter8 {
    public static void main(String[] args) {

        String [] words = {"pierwsze", "drugie", "trzecie", "czwarte", "piate"};
        Double average = Arrays.stream(words).mapToInt(w -> w.length()).average().getAsDouble();
        System.out.println(average);

        int max = Arrays.stream(words).mapToInt(w -> w.length()).max().getAsInt();
        System.out.println(max);

    }
}
