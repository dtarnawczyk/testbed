import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InfiniteFibonacciStream {

    public static void main(String[] args) {
        generateFibonacciSequence().forEach(System.out::println);
    }

    public static IntStream generateFibonacciSequence() {
        return Stream.iterate(new int[]{1, 1}, pair -> new int[]{pair[1], pair[0] + pair[1]}).limit(20)
                .mapToInt(p -> p[0]);
    }
}
