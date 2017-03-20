import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class SumaElementowJava8 {

    public static void main (String [] args) {

        Predicate<Integer> isEven = n -> n % 2 == 0;

        List<Integer> numbers = new ArrayList();
        numbers.add(4);
        numbers.add(5);
        numbers.add(2);
        numbers.add(1);
        numbers.add(10);

        int sum = getSum(numbers, isEven);
        System.out.printf("Suma: %d%n", sum);
    }

    public static int getSum(List<Integer> numbers, Predicate<Integer> filter) {
        return numbers.stream().filter(filter).filter(Objects::nonNull).reduce(0, Integer::sum);
    }
}
