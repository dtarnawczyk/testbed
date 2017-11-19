package functionalProgramming.flowControl;

import static java.util.stream.IntStream.range;

public class DoublerTest {
    public static void main(String[] args) {
        Integer x = Doubler.doubleValue(2);
        System.out.println(x);

        Integer y = Doubler.doubleValue.apply(2);

        System.out.println(y);

    }
}
